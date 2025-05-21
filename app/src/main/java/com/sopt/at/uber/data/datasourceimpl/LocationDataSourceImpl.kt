package com.sopt.at.uber.data.datasourceimpl

import com.sopt.at.uber.data.datasource.LocationDataSource
import com.sopt.at.uber.data.dto.base.BaseResponse
import com.sopt.at.uber.data.dto.request.PostLocationRequest
import com.sopt.at.uber.data.dto.response.SearchKeywordListResponse
import com.sopt.at.uber.data.service.LocationService
import javax.inject.Inject

class LocationDataSourceImpl @Inject constructor(
    private val locationService: LocationService
) : LocationDataSource {
    override suspend fun getSearchList(): BaseResponse<SearchKeywordListResponse> =
        locationService.getSearchList()

    override suspend fun postLocation(
        departures: String,
        destination: String
    ): BaseResponse<Unit> =
        locationService.postLocation(
            request = PostLocationRequest(
                departures = departures,
                destination = destination
            )
        )

    override suspend fun deleteSearchHistoryWithId(id: Long): BaseResponse<Unit> =
        locationService.deleteLocation(id)
}