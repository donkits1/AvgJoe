package com.example.avgjoe.BikeRack.BikeNav

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import androidx.navigation.NavHostController
import com.example.avgjoe.BikeRack.Bike
import com.example.avgjoe.BikeRack.BikeRequest
import com.example.avgjoe.navigation.MyNavHost
import com.example.avgjoe.ui.theme.AvgJoeTheme
import com.google.gson.Gson




@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun BikeScreen(navController: NavHostController) {
    val req = BikeRequest()
    val navigator = navController
    var data by remember { mutableStateOf(arrayOf<Bike>()) }
    var cartTotal by remember { mutableStateOf(0) }
    var populated by remember { mutableStateOf(false) }
    var selection by remember { mutableStateOf(false) }
    var makeTRX by remember { mutableStateOf(false) }
    var alertCustomer by remember { mutableStateOf(false) }
    var customerID by remember { mutableStateOf("") }
    val bikeMap = mutableMapOf<String?, Int>()
    var customerName by remember { mutableStateOf("") }

    @Composable
    fun SelectionBox(): Int {

        var quantity by remember { mutableStateOf(0) }

        Box {
            Row {
                Button(onClick = {
                    if (quantity > 0) {
                        quantity--
                    }
                    selection = true
                }) { Text(text = "-") }

                Text(text = quantity.toString())

                Button(onClick = {
                    quantity++
                    selection = true
                }) { Text(text = "+") }
            }
        }

        return quantity

    }

    LaunchedEffect(Unit) {
        val rawData = req.getBikes()
        data = Gson().fromJson(rawData, Array<Bike>::class.java)
    }


    AvgJoeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {

                if (data.isNotEmpty()) {
                    if (!populated) {
                        for (i in 0..data.size - 1) {
                            bikeMap.plus(Pair(data[i].bikeName, 0))
                        }
                    }
                    data.forEach {
                        Column {
                            Row {
                                Text(text = it.bikeName + " " + it.cost)
                                bikeMap[it.bikeName] = SelectionBox()
                            }
                        }
                    }

                }

                if (selection) {
                    selection = false
                    cartTotal = 0
                    for (i in 0..data.size - 1) {
                        cartTotal += bikeMap[data[i].bikeName]!! * data[i].cost!!
                    }
                }

                Text(text = "Total: $cartTotal")

                OutlinedTextField(value = customerName, onValueChange = { customerName = it }, label = { Text("Full Name") })

                Row {
                    Button(onClick = {
                        if (customerName != "") {
                            makeTRX = true
                        } else {
                            alertCustomer = true
                        }
                    }) {
                        Text(text = "Make TRX")
                    }
                }
                
                if (alertCustomer) {
                    Text(text = "Please Enter Name!")
                }

                if (makeTRX) {
                    makeTRX = false
                    var receipt = ""

                    for (i in 0..data.size - 1) {
                        if (bikeMap[data[i].bikeName]!! != 0) {
                            if (i != 0) {
                                receipt += "-"
                            }
                            receipt += bikeMap[data[i].bikeName]!!.toString()
                            receipt += data[i].bikeName
                        }
                    }

//                    LaunchedEffect(Unit) {
//                        customerID = req.checkCustomer(customerName)
//                    }

                    LaunchedEffect(Unit) {
                        customerID = req.getid("Sonic The Hedgehog")
                    }

                    LaunchedEffect(Unit) {
                        req.addTRX(receipt, cartTotal, customerID)
                    }

                    navController.navigate("BikeScreen")

                }

            }
        }
    }
}
