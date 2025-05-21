package com.sopt.at.uber.data.mapper

import com.sopt.at.uber.data.dto.response.SearchKeywordListResponse
import com.sopt.at.uber.data.dto.response.SearchKeywordResponse
import com.sopt.at.uber.domain.model.SearchKeywordListModel
import com.sopt.at.uber.domain.model.SearchKeywordModel

fun SearchKeywordResponse.toSearchKeywordModel() = SearchKeywordModel(
    id = id,
    location = location,
    address = address,
    date = date
)
fun SearchKeywordListResponse.toSearchKeywordListModel() = SearchKeywordListModel(
    searchKeywords = searchKeywords.map { it.toSearchKeywordModel() }
)