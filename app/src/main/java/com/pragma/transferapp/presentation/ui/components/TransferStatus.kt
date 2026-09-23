import com.pragma.transferapp.domain.model.Error;
import com.pragma.transferapp.domain.model.Success;
import com.pragma.transferapp.domain.model.Loading;
import com.pragma.transferapp.domain.model.Transfer;
import com.pragma.transferapp.domain.model.Idle;
package com.pragma.transferapp.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pragma.transferapp.domain.model.TransferState

@Composable
fun TransferStatus(transferState: TransferState) {
    Column(modifier = Modifier.padding(16.dp)) {
        when (transferState) {
            is TransferState.Idle -> Text("Transfer is idle", style = MaterialTheme.typography.bodyMedium)
            is TransferState.Loading -> Text("Transfer is in progress", style = MaterialTheme.typography.bodyMedium)
            is TransferState.Success -> Text("Transfer completed successfully", style = MaterialTheme.typography.bodyMedium)
            is TransferState.Error -> Text("Transfer failed: ${transferState.error.message}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}