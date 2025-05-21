package com.sopt.at.uber.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VehicleResponse(
    @SerialName("taxiList")
    val taxiList: List<TaxiInfoResponse>,
    @SerialName("caseTaxiList")
    val caseTaxiList: List<TaxiInfoResponse>
)
