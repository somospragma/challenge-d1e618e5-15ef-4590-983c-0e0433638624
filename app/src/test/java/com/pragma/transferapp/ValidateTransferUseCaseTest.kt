import com.pragma.transferapp.domain.model.Error;
import com.pragma.transferapp.domain.model.Success;
import com.pragma.transferapp.domain.model.TransferResult;
package com.pragma.transferapp.test

import com.pragma.transferapp.domain.model.Transfer
import com.pragma.transferapp.domain.usecase.ValidateTransferUseCase
import com.pragma.transferapp.util.ValidationUtils
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ValidateTransferUseCaseTest {

    private val validationUtils: ValidationUtils = mockk()
    private val validateTransferUseCase = ValidateTransferUseCase(validationUtils)

    @Test
    fun `validate transfer returns success when amount is positive and accounts are valid`() = runTest {
        val transfer = Transfer(amount = 100.0, sourceAccount = "123456789", destinationAccount = "987654321", description = "Test Transfer")

        coEvery { validationUtils.validateAmount(any()) } returns true
        coEvery { validationUtils.validateAccount(any()) } returns true

        val result = validateTransferUseCase.execute(transfer)

        assertEquals(Transfer.TransferResult.Success, result)
    }

    @Test
    fun `validate transfer returns error when amount is negative`() = runTest {
        val transfer = Transfer(amount = -100.0, sourceAccount = "123456789", destinationAccount = "987654321", description = "Test Transfer")

        coEvery { validationUtils.validateAmount(any()) } returns false
        coEvery { validationUtils.validateAccount(any()) } returns true

        val result = validateTransferUseCase.execute(transfer)

        assertEquals(Transfer.TransferResult.Error("Invalid amount"), result)
    }

    @Test
    fun `validate transfer returns error when source account is invalid`() = runTest {
        val transfer = Transfer(amount = 100.0, sourceAccount = "invalid", destinationAccount = "987654321", description = "Test Transfer")

        coEvery { validationUtils.validateAmount(any()) } returns true
        coEvery { validationUtils.validateAccount(any()) } returns false

        val result = validateTransferUseCase.execute(transfer)

        assertEquals(Transfer.TransferResult.Error("Invalid source account"), result)
    }

    @Test
    fun `validate transfer returns error when destination account is invalid`() = runTest {
        val transfer = Transfer(amount = 100.0, sourceAccount = "123456789", destinationAccount = "invalid", description = "Test Transfer")

        coEvery { validationUtils.validateAmount(any()) } returns true
        coEvery { validationUtils.validateAccount(any()) } returns false

        val result = validateTransferUseCase.execute(transfer)

        assertEquals(Transfer.TransferResult.Error("Invalid destination account"), result)
    }
}