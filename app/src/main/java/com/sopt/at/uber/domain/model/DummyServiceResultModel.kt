package com.sopt.at.uber.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DummyServiceResultModel(
    @SerialName("info")
    val info: List<String>
)