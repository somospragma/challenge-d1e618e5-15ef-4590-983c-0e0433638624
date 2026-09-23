import com.pragma.transferapp.util.Error;
import com.pragma.transferapp.util.Success;
package com.pragma.transferapp.domain.model

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

/**
 * Representa una transferencia bancaria entre cuentas.
 * Incluye validaciones de negocio para asegurar que el monto sea positivo
 * y que las cuentas de origen y destino sean válidas.
 */
data class Transfer(
    val id: UUID = UUID.randomUUID(),
    val amount: BigDecimal,
    val sourceAccount: String,
    val destinationAccount: String,
    val description: String?,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val transferReference: String = generateReference()
) {
    init {
        require(amount > BigDecimal.ZERO) { "El monto debe ser positivo" }
        require(sourceAccount.isNotBlank()) { "La cuenta de origen no puede estar vacía" }
        require(destinationAccount.isNotBlank()) { "La cuenta de destino no puede estar vacía" }
        require(sourceAccount != destinationAccount) { "Las cuentas de origen y destino deben ser diferentes" }
    }

    companion object {
        private fun generateReference(): String {
            return "TRF-${UUID.randomUUID().toString().substring(0, 8).uppercase()}"
        }

        fun createPendingTransfer(
            amount: BigDecimal,
            sourceAccount: String,
            destinationAccount: String,
            description: String?
        ): Transfer {
            return Transfer(
                amount = amount,
                sourceAccount = sourceAccount,
                destinationAccount = destinationAccount,
                description = description?.takeIf { it.isNotBlank() }
            )
        }
    }

    fun toSuccessResult(transactionId: String): TransferResult {
        return TransferResult.Success(
            transferId = this.id,
            transactionId = transactionId,
            amount = this.amount,
            reference = this.transferReference,
            timestamp = this.createdAt
        )
    }

    fun toErrorResult(errorMessage: String): TransferResult {
        return TransferResult.Error(
            transferId = this.id,
            errorMessage = errorMessage,
            timestamp = LocalDateTime.now()
        )
    }
}