package com.salinas.gamermvvm.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DialogCapturePicture(
    status: MutableState<Boolean>,
    takePhoto: () -> Unit,
    pickImage: () -> Unit,
) {

    if (status.value) {
        AlertDialog(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp), // Adjust the height
            onDismissRequest = { status.value = false },
            title = {
                Text(
                    text = "Selecciona una opcion",
                    fontSize = 20.sp,
                    color = Color.White
                )
            },
            text = {
                // Add any additional text content here if needed
            },
            confirmButton = {
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(vertical = 16.dp), // Adjust the padding
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        modifier = Modifier.width(130.dp),
                        onClick = {
                            status.value = false
                            // Handle confirm button click
                            takePhoto()
                        },
                        colors = ButtonDefaults.buttonColors(contentColor = Color.White)
                    ) {
                        Text("Camara")
                    }
                    Button(
                        modifier = Modifier.width(130.dp),
                        onClick = {
                            status.value = false
                            // Handle confirm button click
                            pickImage()
                        },
                        colors = ButtonDefaults.buttonColors(contentColor = Color.White)
                    ) {
                        Text("Galeria")
                    }
                }
            }
        )
    }
}