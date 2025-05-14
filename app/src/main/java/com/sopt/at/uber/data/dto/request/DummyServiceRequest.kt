package com.sopt.at.uber.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DummyServiceRequest(
    @SerialName("id")
    val id: Long
)