package com.pragma.transferapp.domain.model

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

/**
 * Resultado de una transferencia bancaria.
 * Puede ser exitoso con detalles de la transacción o fallido con información del error.
 */
sealed class TransferResult {
    data class Success(
        val transferId: UUID,
        val transactionId: String,
        val amount: BigDecimal,
        val reference: String,
        val timestamp: LocalDateTime
    ) : TransferResult() {
        fun formattedAmount(): String = "$${amount.setScale(2, BigDecimal.ROUND_HALF_EVEN)}"

        fun confirmationMessage(): String {
            return "Transferencia exitosa de $${amount.setScale(2)} a la cuenta $reference. " +
                   "ID de transacción: $transactionId"
        }
    }

    data class Error(
        val transferId: UUID,
        val errorMessage: String,
        val timestamp: LocalDateTime = LocalDateTime.now(),
        val errorCode: String? = null,
        val retryable: Boolean = true
    ) : TransferResult() {
        fun userFriendlyMessage(): String {
            return when {
                errorMessage.contains("insufficient funds") ->
                    "Fondos insuficientes en la cuenta de origen"
                errorMessage.contains("account not found") ->
                    "Cuenta de destino no encontrada"
                errorMessage.contains("timeout") ->
                    "Tiempo de espera agotado. Por favor, reintente"
                else -> "Error al procesar la transferencia: $errorMessage"
            }
        }

        fun shouldAllowRetry(): Boolean = retryable

        companion object {
            fun fromException(exception: Exception, transferId: UUID): Error {
                return Error(
                    transferId = transferId,
                    errorMessage = exception.message ?: "Error desconocido",
                    errorCode = exception::class.simpleName,
                    retryable = when (exception) {
                        is java.net.SocketTimeoutException -> true
                        is java.io.IOException -> true
                        else -> false
                    }
                )
            }
        }
    }

    fun isSuccess(): Boolean = this is Success
    fun isError(): Boolean = this is Error

    /**
     * Convierte el resultado a un formato adecuado para persistencia local.
     */
    fun toPersistenceModel(): PersistenceTransferResult {
        return when (this) {
            is Success -> PersistenceTransferResult.Success(
                transferId = this.transferId.toString(),
                transactionId = this.transactionId,
                amount = this.amount.toPlainString(),
                reference = this.reference,
                timestamp = this.timestamp.toString()
            )
            is Error -> PersistenceTransferResult.Error(
                transferId = this.transferId.toString(),
                errorMessage = this.errorMessage,
                timestamp = this.timestamp.toString(),
                errorCode = this.errorCode,
                retryable = this.retryable
            )
        }
    }
}

/**
 * Modelo interno para persistencia local que evita problemas con tipos complejos.
 */
sealed class PersistenceTransferResult {
    data class Success(
        val transferId: String,
        val transactionId: String,
        val amount: String,
        val reference: String,
        val timestamp: String
    ) : PersistenceTransferResult()

    data class Error(
        val transferId: String,
        val errorMessage: String,
        val timestamp: String,
        val errorCode: String?,
        val retryable: Boolean
    ) : PersistenceTransferResult()
}