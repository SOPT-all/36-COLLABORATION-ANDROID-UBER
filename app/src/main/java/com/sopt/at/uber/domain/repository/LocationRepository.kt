package com.sopt.at.uber.domain.repository

import com.sopt.at.uber.domain.model.SearchKeywordListModel

interface LocationRepository {
    suspend fun getSearchList() : Result<SearchKeywordListModel>
    suspend fun postLocation(departures: String, destination: String) : Result<Unit>
    suspend fun deleteSearchHistoryWithId(id: Long) : Result<Unit>
}