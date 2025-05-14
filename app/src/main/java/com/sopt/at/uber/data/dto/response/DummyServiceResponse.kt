package com.sopt.at.uber.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DummyServiceResponse(
    @SerialName("info")
    val info: List<String>
)