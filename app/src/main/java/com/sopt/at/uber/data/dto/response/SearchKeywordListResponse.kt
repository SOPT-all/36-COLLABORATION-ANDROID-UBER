package com.sopt.at.uber.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class SearchKeywordListResponse(
    val searchKeywords : List<SearchKeywordResponse>
)