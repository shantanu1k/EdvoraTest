package com.cowday.edvora.data

//Data class for Ride(reference taken from Json provided in Figma)
data class Ride(
    val id: Int,
    val originStationCode: Int,
    val station_path: List<Int>,
    val destinationStationCode: Int,
    val date: Long,
    val map_url: String,
    val state: String,
    val city: String
)