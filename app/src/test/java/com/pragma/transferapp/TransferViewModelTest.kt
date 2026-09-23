import com.pragma.transferapp.domain.model.Error;
import com.pragma.transferapp.domain.model.Transfer;
import com.pragma.transferapp.domain.model.Success;
import com.pragma.transferapp.domain.model.TransferResult;
import com.pragma.transferapp.domain.model.Loading;
import com.pragma.transferapp.domain.model.TransferState;
import com.pragma.transferapp.domain.model.Idle;
import com.pragma.transferapp.domain.usecase.TransferFundsUseCase;
import com.pragma.transferapp.presentation.viewmodel.TransferViewModel;
package com.pragma.transferapp

import androidx.arch.core.executor.testing.CountingTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@ExperimentalCoroutinesApi
class TransferViewModelTest {

    @get:Rule
    val countingTaskExecutorRule = CountingTaskExecutorRule()

    private lateinit var viewModel: TransferViewModel
    private val mockTransferUseCase = mock(TransferFundsUseCase::class.java)

    @Before
    fun setup() {
        viewModel = TransferViewModel(mockTransferUseCase)
    }

    @Test
    fun `test initial state is Idle`() = runTest {
        assertThat(viewModel.state.value).isEqualTo(TransferState.Idle)
    }

    @Test
    fun `test transferFunds updates state correctly`() = runTest {
        viewModel.transferFunds("100", "account1", "account2", "Description")
        verify(mockTransferUseCase).invoke("100", "account1", "account2", "Description")
        assertThat(viewModel.state.value).isInstanceOf(TransferState.Loading::class.java)
    }

    @Test
    fun `test transferFunds handles success`() = runTest {
        val mockResult = TransferResult.Success(Transfer(id = "1", amount = "100", from = "account1", to = "account2", description = "Description"))
        mockTransferUseCase.invoke("100", "account1", "account2", "Description").thenReturn(mockResult)
        viewModel.transferFunds("100", "account1", "account2", "Description")
        assertThat(viewModel.state.value).isInstanceOf(TransferState.Success::class.java)
    }

    @Test
    fun `test transferFunds handles error`() = runTest {
        val mockResult = TransferResult.Error("Error message")
        mockTransferUseCase.invoke("100", "account1", "account2", "Description").thenReturn(mockResult)
        viewModel.transferFunds("100", "account1", "account2", "Description")
        assertThat(viewModel.state.value).isInstanceOf(TransferState.Error::class.java)
    }
}