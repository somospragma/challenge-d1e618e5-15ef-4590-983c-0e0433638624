package com.pragma.transferapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TransferResponseDto(
    @SerializedName("transactionId") val transactionId: String,
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String
) {
    init {
        require(transactionId.isNotBlank()) { "Transaction ID must not be blank" }
        require(status.isNotBlank()) { "Status must not be blank" }
        require(message.isNotBlank()) { "Message must not be blank" }
    }
}