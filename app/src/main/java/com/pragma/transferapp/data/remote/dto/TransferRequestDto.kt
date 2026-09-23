package com.pragma.transferapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TransferRequestDto(
    @SerializedName("amount") val amount: Double,
    @SerializedName("sourceAccount") val sourceAccount: String,
    @SerializedName("destinationAccount") val destinationAccount: String,
    @SerializedName("description") val description: String
) {
    init {
        require(amount > 0) { "Amount must be positive" }
        require(sourceAccount.isNotBlank()) { "Source account must not be blank" }
        require(destinationAccount.isNotBlank()) { "Destination account must not be blank" }
    }
}