package com.sopt.at.uber.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TaxiInfoResponse(
    @SerialName("id") val id: Int,
    @SerialName("type") val type: String,
    @SerialName("min") val min: Int,
    @SerialName("max") val max: Int,
    @SerialName("guests") val guests: Int,
    @SerialName("comment") val comment: String,
    @SerialName("image") val image: String
)
