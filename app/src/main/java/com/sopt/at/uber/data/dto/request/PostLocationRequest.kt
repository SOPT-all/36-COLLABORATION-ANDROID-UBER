package com.sopt.at.uber.data.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class PostLocationRequest (
    val departures: String,
    val destination: String
)