package com.pragma.transferapp.util

import com.pragma.transferapp.domain.model.Transfer

object ValidationUtils {

    fun validateTransfer(transfer: Transfer): ValidationResult {
        if (transfer.amount <= 0) {
            return ValidationResult.Error("El monto debe ser positivo.")
        }
        if (transfer.sourceAccount.isBlank() || transfer.destinationAccount.isBlank()) {
            return ValidationResult.Error("Las cuentas de origen y destino deben ser válidas.")
        }
        return ValidationResult.Success
    }

    sealed class ValidationResult {
        object Success : ValidationResult()
        data class Error(val message: String) : ValidationResult()
    }
}