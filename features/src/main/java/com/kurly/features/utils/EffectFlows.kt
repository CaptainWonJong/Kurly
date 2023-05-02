package com.kurly.features.utils

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableSharedFlow
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
interface EffectFlow<out T> : Flow<T> {
    companion object {
        const val DEFAULT_REPLAY: Int = 3
    }
}

interface MutableEffectFlow<T> : EffectFlow<T>, FlowCollector<T>

@Suppress("FunctionName")
fun <T> MutableEffectFlow(
    replay: Int = EffectFlow.DEFAULT_REPLAY
): MutableEffectFlow<T> = EffectFlowImpl(replay)

fun <T> MutableEffectFlow<T>.asEffectFlow(): EffectFlow<T> = ReadOnlyEffectFlow(this)

private class ReadOnlyEffectFlow<T>(flow: EffectFlow<T>) : EffectFlow<T> by flow

private class EffectFlowImpl<T>(
    replay: Int
) : MutableEffectFlow<T> {

    private val flow: MutableSharedFlow<EffectFlowSlot<T>> = MutableSharedFlow(replay = replay)

    @InternalCoroutinesApi
    override suspend fun collect(collector: FlowCollector<T>) = flow.collect { slot ->
        if (!slot.markConsumed()) {
            collector.emit(slot.value)
        }
    }

    override suspend fun emit(value: T) {
        flow.emit(EffectFlowSlot(value))
    }
}

private class EffectFlowSlot<T>(val value: T) {

    private val consumed: AtomicBoolean = AtomicBoolean(false)

    fun markConsumed(): Boolean = consumed.getAndSet(true)
}