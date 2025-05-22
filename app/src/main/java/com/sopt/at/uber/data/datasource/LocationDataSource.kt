package com.sopt.at.uber.data.datasource

import com.sopt.at.uber.data.dto.base.BaseResponse
import com.sopt.at.uber.data.dto.response.SearchKeywordListResponse

interface LocationDataSource {
    suspend fun getSearchList(): BaseResponse<SearchKeywordListResponse>
    suspend fun postLocation(departures: String, destination: String): BaseResponse<Unit>
    suspend fun deleteSearchHistoryWithId(id: Long): BaseResponse<Unit>

    suspend fun deleteAllSearchHistory(): BaseResponse<Unit>
}