package com.pragma.transferapp.domain.model

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Representa los diferentes estados por los que pasa una transferencia durante su ciclo de vida.
 * Incluye manejo de transiciones entre estados y validaciones para evitar estados inválidos.
 */
sealed class TransferState {
    object Idle : TransferState()
    object Loading : TransferState()
    data class Success(val result: TransferResult.Success) : TransferState()
    data class Error(val error: TransferResult.Error) : TransferState()

    /**
     * Clase que gestiona el estado de la transferencia con corrutinas.
     * Proporciona métodos para actualizar el estado de manera segura desde ViewModel.
     */
    class TransferStateManager {
        private val _state = MutableStateFlow<TransferState>(Idle)
        val state: StateFlow<TransferState> = _state.asStateFlow()

        fun transitionToLoading() {
            _state.update { Loading }
        }

        fun transitionToSuccess(result: TransferResult.Success) {
            require(_state.value is Loading) {
                "No se puede transicionar a Success desde ${_state.value::class.simpleName}"
            }
            _state.update { Success(result) }
        }

        fun transitionToError(error: TransferResult.Error) {
            _state.update { Error(error) }
        }

        fun resetToIdle() {
            _state.update { Idle }
        }

        fun isLoading(): Boolean = _state.value is Loading
    }

    /**
     * Extensión para ViewModel que facilita la gestión del estado.
     */
    fun interface StateTransitionHandler {
        suspend fun handleStateTransition(
            onLoading: suspend () -> Unit,
            onSuccess: suspend (TransferResult.Success) -> Unit,
            onError: suspend (TransferResult.Error) -> Unit
        )
    }

    companion object {
        fun createTransitionHandler(stateFlow: StateFlow<TransferState>): StateTransitionHandler {
            return StateTransitionHandler { onLoading, onSuccess, onError ->
                stateFlow.collect { currentState ->
                    when (currentState) {
                        is Loading -> onLoading()
                        is Success -> onSuccess(currentState.result)
                        is Error -> onError(currentState.error)
                        Idle -> { /* No action needed */ }
                    }
                }
            }
        }

        fun validateTransition(current: TransferState, next: TransferState): Boolean {
            return when (current) {
                Idle -> next is Loading
                Loading -> next is Success || next is Error
                is Success -> next == Idle
                is Error -> next == Idle
            }
        }
    }
}