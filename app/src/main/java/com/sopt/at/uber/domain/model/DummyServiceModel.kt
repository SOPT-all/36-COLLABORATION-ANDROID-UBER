package com.sopt.at.uber.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DummyServiceModel(
    @SerialName("id")
    val id: Long
)