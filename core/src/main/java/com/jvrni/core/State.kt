package com.jvrni.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

sealed class State<out T> {

    data class Error(val error: Throwable) : State<Nothing>()
    object Loading : State<Nothing>()
    data class Success<T>(val data: T) : State<T>()

    companion object {
        fun <T> request(
            dispatcher: CoroutineDispatcher = Dispatchers.IO,
            block: suspend () -> T
        ): Flow<State<T>> {
            return flow {
                emit(Loading)
                val result = block()
                emit(Success(result))
            }.catch {
                emit(Error(it))
            }.flowOn(dispatcher)
        }

        fun <T, R> Flow<State<T>>.mapper(block: (T) -> R): Flow<State<R>> = this.map { state ->
            when(state) {
                is Success -> Success(block.invoke(state.data))
                is Loading -> Loading
                is Error -> Error(state.error)
            }
        }
    }
}