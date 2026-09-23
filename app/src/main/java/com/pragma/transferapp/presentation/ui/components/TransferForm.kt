package com.pragma.transferapp.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pragma.transferapp.domain.model.Transfer

@Composable
fun TransferForm(onTransfer: (Transfer) -> Unit) {
    val amount = remember { mutableStateOf("") }
    val sourceAccount = remember { mutableStateOf("") }
    val destinationAccount = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = amount.value,
            onValueChange = { amount.value = it },
            label = { Text("Monto") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = sourceAccount.value,
            onValueChange = { sourceAccount.value = it },
            label = { Text("Cuenta de origen") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = destinationAccount.value,
            onValueChange = { destinationAccount.value = it },
            label = { Text("Cuenta de destino") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = description.value,
            onValueChange = { description.value = it },
            label = { Text("Descripción") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}