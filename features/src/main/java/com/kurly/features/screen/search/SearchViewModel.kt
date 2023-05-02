package com.kurly.features.screen.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kurly.domain.usecase.GetGithubRepos
import com.kurly.features.screen.search.effects.SearchSideEffects
import com.kurly.features.screen.search.mapper.SearchItemMapper
import com.kurly.features.screen.search.state.SearchItemState
import com.kurly.features.utils.MutableEffectFlow
import com.kurly.features.utils.asEffectFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
@HiltViewModel
class SearchViewModel @Inject constructor(
    getGithubRepos: GetGithubRepos
) : ViewModel() {
    private val scope = viewModelScope + Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    private val searchItemMapper by lazy {
        SearchItemMapper()
    }

    private val _searchQuery = MutableStateFlow(String.empty)
    val searchQuery = _searchQuery.asStateFlow()

    @ExperimentalCoroutinesApi
    @FlowPreview
    val searchItemState: StateFlow<SearchItemState> = searchQuery
        .debounce(SEARCH_DEBOUNCE_TIME_MILLIS)
        .flatMapLatest { query ->
            flow {
                if (query.isEmpty()) {
                    emit(SearchItemState.Empty)
                    return@flow
                }

                emit(SearchItemState.Loading)

                getGithubRepos(GetGithubRepos.Param(query)).onSuccess {
                    val items = it.map { entity ->
                        searchItemMapper.to(entity)
                    }
                    if (items.isEmpty()) {
                        emit(SearchItemState.Empty)
                    } else {
                        emit(SearchItemState.Content(items = items))
                    }
                }.onFailure {
                    emit(SearchItemState.Error)
                    it.printStackTrace()
                }
            }
        }.stateIn(scope, SharingStarted.Lazily, SearchItemState.Empty)

    private val _sideEffects: MutableEffectFlow<SearchSideEffects?> = MutableEffectFlow()
    val sideEffects = _sideEffects.asEffectFlow()

    fun typing(input: String) {
        scope.launch {
            _searchQuery.emit(input)
        }
    }

    fun showToast(text: String) {
        scope.launch {
            _sideEffects.emit(SearchSideEffects.OnToast(text = text))
        }
    }

    companion object {
        private const val SEARCH_DEBOUNCE_TIME_MILLIS = 200L
    }
}

private val String.Companion.empty get() = ""