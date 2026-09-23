package com.pragma.transferapp.domain.usecase

import com.pragma.transferapp.domain.model.Transfer
import javax.inject.Inject

class ValidateTransferUseCase @Inject constructor() {
    operator fun invoke(transfer: Transfer): Result<Transfer> {
        return if (transfer.amount > 0 && transfer.sourceAccount.isNotBlank() && transfer.destinationAccount.isNotBlank()) {
            Result.success(transfer)
        } else {
            Result.failure(Exception("Invalid transfer data"))
        }
    }
}