package com.kurly.features.screen.search

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kurly.designsystem.component.progress.LoadingProgress
import com.kurly.designsystem.component.progress.ProgressType
import com.kurly.designsystem.component.textfield.SearchTextField
import com.kurly.designsystem.utils.addFocusClear
import com.kurly.features.screen.search.effects.HandleSearchSideEffects
import com.kurly.features.screen.search.state.SearchItemState
import com.kurly.features.screen.search.view.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
internal fun SearchRoute(
    viewModel: SearchViewModel = hiltViewModel()
) {
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
    val searchItemState by viewModel.searchItemState.collectAsStateWithLifecycle()

    HandleSearchSideEffects(effects = viewModel.sideEffects)

    SearchScreen(
        searchQuery = searchQuery,
        searchItemState = { searchItemState },
        typing = viewModel::typing,
        onClick = viewModel::showToast
    )
}

@Composable
private fun SearchScreen(
    searchQuery: String,
    searchItemState: () -> SearchItemState,
    typing: (String) -> Unit,
    onClick: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .addFocusClear(focusManager)
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        SearchTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            searchQuery = searchQuery,
            onValueChange = typing
        )

        Spacer(modifier = Modifier.height(8.dp))

        when (val itemState = searchItemState()) {
            is SearchItemState.Loading -> {
                LoadingProgress(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 20.dp),
                    progressType = ProgressType.Large
                )
            }
            is SearchItemState.Empty -> {
                SearchEmptyView()
            }
            is SearchItemState.Error -> {
                SearchErrorView()
                Toast.makeText(LocalContext.current, itemState.throwable.message, Toast.LENGTH_SHORT).show()
            }
            is SearchItemState.Content -> {
                var isLinear by rememberSaveable { mutableStateOf(true) }
                SearchItemToggleRow(
                    isLinear = isLinear,
                    onClickLinear = {
                        isLinear = true
                    },
                    onClickGrid = {
                        isLinear = false
                    }
                )

                if (isLinear) {
                    SearchRepositoryLinearColumn(
                        searchItems = itemState.items,
                        onClickItem = onClick
                    )
                } else {
                    SearchRepositoryGridColumn(
                        searchItems = itemState.items,
                        onClickItem = onClick
                    )
                }
            }
        }
    }
}