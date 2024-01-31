package com.salinas.gamermvvm.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salinas.gamermvvm.presentation.ui.theme.Red700

@Composable
fun DefaultButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    //color: Color = Darkaray500,
    icon: ImageVector = Icons.Default.ArrowForward
) {
    Column {
        Button(
            modifier = Modifier.run {
                fillMaxWidth()
                .padding(end = 40.dp, start = 40.dp,top = 2.dp)
            },
            //.background(color),  // Establecer el color de fondo directamente con el modificador background
            onClick = { onClick() },
            enabled = enabled
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = Color.White
            )
            Spacer(
                modifier = Modifier.width(5.dp)
            )
            Text(
                text = text,
                color = Color.White
            )
        }
        Text(
            modifier = Modifier.padding(top = 0.dp),
            text = "",
            fontSize = 11.sp,
            color = Red700
        )
    }
}
