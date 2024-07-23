package com.example.avgjoe.BikeRack

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.example.avgjoe.ui.theme.Data
import com.example.avgjoe.ui.theme.GlobalData
import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.headers
import io.ktor.client.request.request
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import io.ktor.client.statement.request
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlin.reflect.typeOf


class BikeRequest() {
     var customer = ""
    suspend fun getBikes(): String {
        val client = HttpClient()
        var data: String = ""

        try {
            coroutineScope {
                var read: HttpResponse = client.request("http://10.0.2.2:8080/allbikes") {

                    method = HttpMethod.Get

                    headers {
//                        contentType(ContentType.Application.Json)
                        append(HttpHeaders.Accept, "application/json")
                        append(HttpHeaders.Accept, "text/html")
                    }
                }
                data = read.readText()
            }
        } catch (e: Exception) {
            Log.e("Error", e.toString())
        } finally {
            client.close()
        }
        return data
    }

    suspend fun getTRXHistory(): String {
        val client = HttpClient()
        var data: String = ""

        try {
            coroutineScope {
                var read: HttpResponse = client.request("http://10.0.2.2:8080/trxhistory") {

                    method = HttpMethod.Get

                    headers {
//                        contentType(ContentType.Application.Json)
                        append(HttpHeaders.Accept, "application/json")
                        append(HttpHeaders.Accept, "text/html")
                    }
                }
                data = read.readText()
            }
        } catch (e: Exception) {
            Log.e("Error", e.toString())
        } finally {
            client.close()
        }

        return data
    }

    //addTRX

    suspend fun getid(name: String):String {

        val client = HttpClient()
        var data : String = ""
        var info = listOf<Customer>()

        if (customer == "") {
            customer = name.replace(' ', '_')
        }

        try {
            coroutineScope {
                var read: HttpResponse = client.request("http://10.0.2.2:8080/checkcustomer/customerName=$customer") {

                    method = HttpMethod.Get

                    headers {
//                        contentType(ContentType.Application.Json)
                        append(HttpHeaders.Accept, "application/json")
                        append(HttpHeaders.Accept, "text/html")
                    }
                }
                data = read.readText()
                if (data == null)
                    Log.e("asdf", "null")
                else
                    Log.e("asdf", data.toString() + "Q")
            }
        } catch (e: Exception) {
            Log.e("asdf", "crashed")
            Log.e("Error", e.toString())
        } finally {
            client.close()
        }
        if (data == null || data == "")
            return ""


        val gson = Gson()
       // Log.e("asdf", data)


        info = gson.fromJson(data, listOf<Customer>()::class.java)

        Log.e("asdf", info.toString())
        val user = Customer(info[0].userid, info[0].name)
        Log.e("asdf", user.toString())
//        Log.e("asdf", "asdf" + info.userid)
        return user.userid!!
    }


    suspend fun addTRX(order: String,total: Int, userid: String) {
        //var id = getid(userid)
        val client = HttpClient()

        if (userid == "" || userid == null) {
            //add customer, make trx w id
        } else {
            //make trx with id
            try {
                coroutineScope {
                    Log.e("asdf", "making transaction with user id $userid...")
                    var link = "http://10.0.2.2:8080/addtrx/order=$order/total=$total/userid=$userid"
                    var read: HttpResponse =
                        client.request(link.replace(" ", "")) {
                            method = HttpMethod.Post

                            headers {
                                append(HttpHeaders.Accept, "application/json")
                                append(HttpHeaders.Accept, "text/html")
                            }
                        }
                    //data = read.readText()
                }
            } catch (e: Exception) {
                Log.e("Error", e.toString())
            } finally {
                client.close()
            }
        }

    }

    suspend fun getGBPConversion() : String { //https://api.currencyapi.com/v3/latest?apikey=cur_live_iDekR5YCvXwQw1vKOQj0NnthOXNddNRq8r6eo3ue&currencies=GBP
        val client = HttpClient()
        var data = ""

        try {
            coroutineScope {
                var read: HttpResponse =
                    client.request("https://api.currencyapi.com/v3/latest?apikey=cur_live_iDekR5YCvXwQw1vKOQj0NnthOXNddNRq8r6eo3ue&currencies=GBP") {
                        method = HttpMethod.Post

                        headers {
                            append(HttpHeaders.Accept, "application/json")
                            append(HttpHeaders.Accept, "text/html")
                        }
                    }
                data = read.readText()
            }
        } catch (e: Exception) {
            Log.e("Error", e.toString())
        } finally {
            client.close()
        }

        return data
    }

}