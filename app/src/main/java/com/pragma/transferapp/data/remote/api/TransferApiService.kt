package com.pragma.transferapp.data.remote.api

import retrofit2.http.Body
import retrofit2.http.POST
import com.pragma.transferapp.data.remote.dto.TransferRequestDto
import com.pragma.transferapp.data.remote.dto.TransferResponseDto

interface TransferApiService {
    @POST("transfers")
    suspend fun transferFunds(@Body transferRequest: TransferRequestDto): TransferResponseDto
}