package com.sopt.at.uber.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class SearchKeywordResponse (
    val id: Long,
    val location: String,
    val address: String,
    val date: String
)