package com.sopt.at.uber.data.dto.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DummyBaseResponse<T>(
    @SerialName("success")
    val success: Boolean,
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: T? = null,
)