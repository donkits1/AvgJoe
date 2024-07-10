package com.example.avgjoe.ui.theme

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("name") val name : String,
    @SerialName("id") val id : Int,
    @SerialName("pin") val pin : Int,
    @SerialName("checkin") val checkin : Boolean
) {
}