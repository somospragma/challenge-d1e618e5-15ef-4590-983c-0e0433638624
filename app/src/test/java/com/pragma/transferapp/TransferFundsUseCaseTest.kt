import com.pragma.transferapp.domain.model.Error;
import com.pragma.transferapp.domain.model.TransferResult;
import com.pragma.transferapp.domain.model.Success;
package com.pragma.transferapp.test

import com.pragma.transferapp.data.repository.TransferRepository
import com.pragma.transferapp.domain.model.Transfer
import com.pragma.transferapp.domain.usecase.TransferFundsUseCase
import com.pragma.transferapp.util.Resource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class TransferFundsUseCaseTest {

    private val transferRepository: TransferRepository = mockk()
    private val transferFundsUseCase = TransferFundsUseCase(transferRepository)

    @Test
    fun `transfer funds returns success when repository call is successful`() = runTest {
        val transfer = Transfer(amount = 100.0, sourceAccount = "123456789", destinationAccount = "987654321", description = "Test Transfer")

        coEvery { transferRepository.transferFunds(any()) } returns Resource.Success(Transfer.TransferResult.Success)

        val result = transferFundsUseCase.execute(transfer)

        assertEquals(Transfer.TransferResult.Success, result)
    }

    @Test
    fun `transfer funds returns error when repository call fails`() = runTest {
        val transfer = Transfer(amount = 100.0, sourceAccount = "123456789", destinationAccount = "987654321", description = "Test Transfer")

        coEvery { transferRepository.transferFunds(any()) } returns Resource.Error("Transfer failed")

        val result = transferFundsUseCase.execute(transfer)

        assertEquals(Transfer.TransferResult.Error("Transfer failed"), result)
    }
}