package com.example.avgjoe

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
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlin.reflect.typeOf

class Request(navController: NavHostController) {

    val navigator = navController

    suspend fun getPosts(): String {
        val client = HttpClient()
        var data: String = ""

        try {
            coroutineScope {
                var read: HttpResponse = client.request("http://10.0.2.2:8080/") {

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

    suspend fun addClient(name: String, pin: Int) {
        val client = HttpClient()
        var data: String = ""

        try {
            coroutineScope {
                var read: HttpResponse =
                    client.request("http://10.0.2.2:8080/add-client/name=$name/pin=$pin") {
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

    suspend fun deleteClient() {
        TODO()
    }

    suspend fun updatePin() {
        TODO()
    }

    fun checkIn(id: String, pin: String) = runBlocking {

        val client = HttpClient()
        var data = ""
        var list: List<String> = listOf("")

        try {
            coroutineScope {
                var read: HttpResponse =
                    client.request("http://10.0.2.2:8080/verify/$id/$pin") {
                        method = HttpMethod.Get

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

        if (!data.equals("[]", false)) {
            navigator.navigate("CustomerScreen")
        }

            //return false}


        suspend fun checkOut() {
            TODO()
        }


    }
}