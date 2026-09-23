import com.pragma.transferapp.domain.model.TransferResult;
package com.pragma.transferapp.domain.repository

import com.pragma.transferapp.domain.model.Transfer
import kotlinx.coroutines.flow.Flow

interface TransferRepository {
    suspend fun transferFunds(transfer: Transfer): Flow<TransferResult>
}