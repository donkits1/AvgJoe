package com.example.avgjoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.avgjoe.navigation.MyNavHost
import com.example.avgjoe.ui.theme.AvgJoeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            AvgJoeTheme {
                MyNavHost(navController = navController, starDest = "BikeScreen")
            }
        }
    }
}



//
//
//
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Greeting() {
//
//    val client = Request()
//    var text = ""
//    var loggedIn = false
//    var statement by remember { mutableStateOf(false) }
//    var name by remember { mutableStateOf("") }
//    var pin by remember { mutableStateOf("") }
////    var name = ""
////    var pin = ""
//    var user = ""
//    var checkUser = false
//
//    @Composable
//    fun checkIn() {
//        LaunchedEffect(Unit) {
//            client.addClient("Craft", 1234)
//        }
//    }
//
//    LaunchedEffect(Unit) {
//        text = client.getPosts()
//        Log.e("asdf", text)
//
//    }
//
//    Log.e("asdf",text)
//
//    if(loggedIn) {
//        AvgJoeTheme {
//            Surface(
//                modifier = Modifier.fillMaxSize(),
//                color = MaterialTheme.colorScheme.background
//            ) {
//                Column {
//                    val image = painterResource(id = (R.drawable.avgjoebanner))
//                    Row {
//                        Button(onClick = {
//                        }
//                        ) {
//                        }
//                        Text(text = text)
//                        Button(onClick = { /*TODO*/ }) {
//                            Text(text = "Sign Out")
//                        }
//                        Button(onClick = { /*TODO*/
//                            statement = !statement }) {
//                            Text(text = "Sign In")
//                        }
//                        if (statement) {
//                            checkIn()
//                            //clicking button refreshes page!!
//                        }
//                    }
//                    Image(painter = image, contentDescription = null)
//                }
//            }
//        }
//    } else {
//        AvgJoeTheme {
//            Surface(
//                modifier = Modifier.fillMaxSize(),
//                color = MaterialTheme.colorScheme.background
//            ) {
//                Column {
//                    OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Full Name") })
//                    OutlinedTextField(value = pin, onValueChange = { pin = it }, label = { Text("PIN")})
//                    Button(onClick = { /*TODO*/
//                        //verify, loggedIn = true
//                        checkUser = true
//                    }) {
//                        Text(text = "Sign In")
//                    }
//                }
//            }
//            if(checkUser) {
//                LaunchedEffect(Unit) {
//                    if (client.checkIn(name, pin)) {
//                        loggedIn = true
//                        user = name
//                    }
//                }
//            } else {
//                checkUser = false
//            }
//        }
//    }











//@Composable
//fun Greeting() {
//
//    val gson: Gson = Gson()
//    val client = Request()
//    var text : String = ""
//    var responseList by remember { mutableStateOf(arrayListOf<Response?>()) }
//    val listType = object : TypeToken<ArrayList<Response>>() {}.type
//
//    var statement by remember { mutableStateOf(false) }
//
//    @Composable
//    fun checkIn() {
//        LaunchedEffect(Unit) {
//            client.addClient("Craft", 1234)
//        }
//    }
//
//    //val tokentype : Type = TypeToken<List<Response>>(){}.type
//
//
//    LaunchedEffect(Unit) {
//       //Log.e("asdf", "pre request")
//        text = client.getPosts()
//        //Log.e("asdf", "post request")
//        Log.e("asdf", text)
////        val responseList: List<Response> = gson.fromJson(text, Array<Response>::class.java).toList()
//
//        //responseList = gson.fromJson<ArrayList<Response?>>(text, listType::class.java)
////        Log.e("asdf",responseList.toString())
//
//    }
//
//    Log.e("asdf",text)
//
//
//
//    //text = Gson.toJson(text)
//
//    AvgJoeTheme {
//        var signedIn : Boolean = false
//        // A surface container using the 'background' color from the theme
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
////                    initUI()
//            Column {
//                val image = painterResource(id = (R.drawable.avgjoebanner))
//                Row {
//                    Button(onClick = {
//                    }
//                    ) {
//                    }
//                    Text(text = text)
//                    //Spacer(modifier = )
//                    Button(onClick = { /*TODO*/ }) {
//                        Text(text = "Sign Out")
//                    }
//                    Button(onClick = { /*TODO*/
//                        statement = !statement
//                    }) {
//                        Text(text = "Sign In")
//                    }
//                    if (statement) {
//                        checkIn()
//                        //clicking button refreshes page!!
//                    }
//                }
//                Image(painter = image, contentDescription = null)
//
//            }
//}
//
//
//
////    private fun initUI() {
////        binding.
////    }
//
//}
//
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    AvgJoeTheme {
//        //Greeting("Android")
//    }
//}}