package com.sopt.at.uber.data.datasource

import com.sopt.at.uber.data.dto.base.BaseResponse

import com.sopt.at.uber.data.dto.response.VehicleResponse

interface VehicleDataSource {
    suspend fun getTaxiLists(): BaseResponse<VehicleResponse>
}