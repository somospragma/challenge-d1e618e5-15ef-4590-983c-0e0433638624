import com.pragma.transferapp.domain.model.Error;
import com.pragma.transferapp.domain.model.Loading;
package com.pragma.transferapp.domain.usecase

import com.pragma.transferapp.domain.model.Transfer
import com.pragma.transferapp.domain.model.TransferResult
import com.pragma.transferapp.domain.repository.TransferRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TransferFundsUseCase @Inject constructor(
    private val transferRepository: TransferRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {
    operator fun invoke(transfer: Transfer): Flow<TransferResult> = flow {
        emit(TransferResult.Loading)
        try {
            val result = transferRepository.transferFunds(transfer)
            emit(result)
        } catch (e: Exception) {
            emit(TransferResult.Error(e.message?: "Unknown error"))
        }
    }.flowOn(coroutineDispatcher)
}