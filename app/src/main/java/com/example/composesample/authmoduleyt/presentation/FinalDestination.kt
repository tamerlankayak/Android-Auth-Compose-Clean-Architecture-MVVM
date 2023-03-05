package com.example.composesample.authmoduleyt.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

//final destination representation example of home page after authentication
@Composable
fun FinalDestination() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            style = MaterialTheme.typography.body1,
            text = "You logged in )"
        )
    }
}
