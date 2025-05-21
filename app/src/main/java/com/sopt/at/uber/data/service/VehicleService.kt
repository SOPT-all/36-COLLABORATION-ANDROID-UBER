package com.sopt.at.uber.data.service

import com.sopt.at.uber.data.dto.base.BaseResponse
import com.sopt.at.uber.data.dto.response.VehicleResponse
import retrofit2.http.GET

interface VehicleService {

    @GET("/uber/v1/taxi")
    suspend fun getTaxiLists(): BaseResponse<VehicleResponse>
}