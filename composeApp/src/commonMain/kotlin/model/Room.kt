package model

import kotlinx.serialization.Serializable

@Serializable
data class Room(
    val id: String? = "",
    val isOccupied: Boolean? = false,
    val maxOccupancy: Int? = 0
)
