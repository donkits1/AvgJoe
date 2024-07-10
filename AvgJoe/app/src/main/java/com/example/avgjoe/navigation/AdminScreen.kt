package com.example.avgjoe.navigation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.avgjoe.R
import com.example.avgjoe.Request
import com.example.avgjoe.ui.theme.AvgJoeTheme
import com.example.avgjoe.ui.theme.Data
import com.example.avgjoe.ui.theme.GlobalData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AdminScreen(navController: NavHostController) {
    val req = Request(navController)
//    val dataTypeTok = object : TypeToken<Array<Data>>() {}.type
//    var text by remember {
//        mutableStateOf( "")
//    }

    //var data : Array<Data> = arrayOf()

    var data by remember { mutableStateOf(arrayOf<Data>()) }
    var add by remember { mutableStateOf(false) }
    var remove by remember { mutableStateOf(false) }
    var deleteID by remember { mutableStateOf(Int) }
    var deletePIN by remember { mutableStateOf(Int) }

    LaunchedEffect(Unit) {
        val rawData = req.getPosts()
        data = Gson().fromJson(rawData, Array<Data>::class.java)
    }

    //var clients = data

    AvgJoeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Row {
                    Button(onClick = { add = true }) {
                        Text(text = "ADD USER")
                    }
                    Button(onClick = { navController.navigate("LoginScreen") }) {
                        Text(text = "Sign Out")
                    }
                }

                if (data.isNotEmpty()) {
                    data.forEach {
                        Column {
                            Row {
                                Text(text = it.name + " " + it.id)
                                Button(
                                    onClick = {
                                        remove = true
//                                        deleteID = it.id
//                                        deletePIN = it.pin
                                    }
                                ) {
                                    Text(text = "REMOVE")
                                }
                            }
                        }
                    }
                }

                if(add) {
                    LaunchedEffect(Unit) {

                    }
                }

                if(remove) {
                    LaunchedEffect(Unit) {

                    }
                }


            }
        }
    }
}