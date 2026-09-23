import com.pragma.transferapp.domain.model.Error;
import com.pragma.transferapp.domain.model.Success;
import com.pragma.transferapp.domain.model.Loading;
import com.pragma.transferapp.domain.model.Idle;
package com.pragma.transferapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pragma.transferapp.domain.model.Transfer
import com.pragma.transferapp.domain.model.TransferResult
import com.pragma.transferapp.domain.model.TransferState
import com.pragma.transferapp.domain.usecase.TransferFundsUseCase
import com.pragma.transferapp.domain.usecase.ValidateTransferUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class TransferViewModel @Inject constructor(
    private val validateTransferUseCase: ValidateTransferUseCase,
    private val transferFundsUseCase: TransferFundsUseCase
) : ViewModel() {

    private val _transferState = MutableStateFlow<TransferState>(TransferState.Idle)
    val transferState: StateFlow<TransferState> = _transferState

    fun transferFunds(transfer: Transfer) {
        viewModelScope.launch {
            val validationResult = validateTransferUseCase.execute(transfer)
            if (validationResult.isSuccess()) {
                _transferState.value = TransferState.Loading
                val transferResult = transferFundsUseCase.execute(transfer)
                if (transferResult.isSuccess()) {
                    _transferState.value = TransferState.Success(transferResult.toSuccessResult())
                } else {
                    _transferState.value = TransferState.Error(transferResult.toErrorResult())
                }
            } else {
                _transferState.value = TransferState.Error(validationResult.toErrorResult())
            }
        }
    }
}