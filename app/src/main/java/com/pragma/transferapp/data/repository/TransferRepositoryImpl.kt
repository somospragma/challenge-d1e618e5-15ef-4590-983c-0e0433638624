import com.pragma.transferapp.domain.model.Error;
import com.pragma.transferapp.domain.repository.TransferRepository;
package com.pragma.transferapp.data.repository

import com.pragma.transferapp.data.remote.api.TransferApiService
import com.pragma.transferapp.domain.model.Transfer
import com.pragma.transferapp.domain.model.TransferResult
import javax.inject.Inject

class TransferRepositoryImpl @Inject constructor(
    private val apiService: TransferApiService
) : TransferRepository {
    override suspend fun transferFunds(transfer: Transfer): TransferResult {
        // Implementación pendiente
        return TransferResult.Error("Pendiente de implementar")
    }
}