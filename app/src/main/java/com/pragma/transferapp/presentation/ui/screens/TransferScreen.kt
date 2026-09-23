import com.pragma.transferapp.domain.model.Transfer;
package com.pragma.transferapp.presentation.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pragma.transferapp.presentation.ui.components.TransferForm
import com.pragma.transferapp.presentation.ui.components.TransferStatus
import com.pragma.transferapp.presentation.viewmodel.TransferViewModel

@Composable
fun TransferScreen() {
    val viewModel: TransferViewModel = viewModel()
    val transferState by viewModel.transferState.collectAsState()
    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        TransferForm(onTransfer = { transfer ->
            viewModel.transferFunds(transfer)
        })
        TransferStatus(transferState) { error ->
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        }
        Button(onClick = { viewModel.transferFunds(Transfer()) }, modifier = Modifier.padding(top = 16.dp)) {
            Text("Transferir")
        }
    }
}