package com.example.avgjoe.BikeRack
import kotlinx.serialization.Serializable

@Serializable
data class Customer(
    val userid : String?,
    val name : Int?
)