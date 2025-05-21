package com.sopt.at.uber.data.service

import com.sopt.at.uber.data.dto.base.BaseResponse
import com.sopt.at.uber.data.dto.base.DummyBaseResponse
import com.sopt.at.uber.data.dto.request.PostLocationRequest
import com.sopt.at.uber.data.dto.response.SearchKeywordListResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LocationService {
    @GET("/uber/v1/search")
    suspend fun getSearchList(): BaseResponse<SearchKeywordListResponse>

    @POST("/uber/v1/location")
    suspend fun postLocation(
        @Body request: PostLocationRequest
    ): BaseResponse<Unit>

    @DELETE("/uber/v1/search/{id}")
    suspend fun deleteLocation(
        @Path("id") id: Long
    ): BaseResponse<Unit>

}