package com.example.avgjoe.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.avgjoe.R
import com.example.avgjoe.Request
import com.example.avgjoe.ui.theme.AvgJoeTheme

@Composable
fun CustomerScreen(navController: NavHostController) {
    var statement by remember { mutableStateOf(false) }
    var text = ""
    val client = Request(navController)

    @Composable
    fun checkIn() {
        LaunchedEffect(Unit) {
            client.addClient("Craft", 1234)
        }
    }
    AvgJoeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                val image = painterResource(id = (R.drawable.avgjoebanner))
                Row {
                    Button(onClick = {
                    }
                    ) {
                    }
                    Text(text = text)
                    Button(onClick = { navController.navigate("LoginScreen") }) {
                        Text(text = "Sign Out")
                    }
                    Button(onClick = { /*TODO*/
                        statement = !statement }) {
                        Text(text = "Customer")
                    }
                    if (statement) {
                        checkIn()
                        //clicking button refreshes page!!
                    }
                }
                Image(painter = image, contentDescription = null)
            }
        }
    }

}