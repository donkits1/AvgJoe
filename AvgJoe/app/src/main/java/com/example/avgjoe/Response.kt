package com.example.avgjoe
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    val name : String?,
    val id : Int?,
    val pin : Int?,
    val checkin : Boolean?
)

@Serializable
data class ArrayResponse(
    val name : ArrayList<Response>?
)