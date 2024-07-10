package com.example.avgjoe.navigation

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.avgjoe.Request
import com.example.avgjoe.ui.theme.AvgJoeTheme
import com.example.avgjoe.ui.theme.GlobalData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    val navigator = navController
    var id by remember { mutableStateOf("") }
    var pin by remember { mutableStateOf("") }
    var checkUser by remember { mutableStateOf(false) }

    AvgJoeTheme {
        val client = Request(navController)
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                OutlinedTextField(value = id, onValueChange = { id = it }, label = { Text("Client ID") })
                OutlinedTextField(value = pin, onValueChange = { pin = it }, label = { Text("PIN") })
                }

            }
    Button(onClick = {
        if (id.equals("ADMIN", false) && pin.equals("ADMIN", false)) {
            navigator.navigate("AdminScreen") }
        else client.checkIn(id, pin) }) {
        Text(text = "Sign In")
    }
}

    }