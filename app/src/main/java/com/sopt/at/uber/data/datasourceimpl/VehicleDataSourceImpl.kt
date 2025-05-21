package com.sopt.at.uber.data.datasourceimpl

import com.sopt.at.uber.data.datasource.VehicleDataSource
import com.sopt.at.uber.data.dto.base.BaseResponse
import com.sopt.at.uber.data.dto.response.VehicleResponse
import com.sopt.at.uber.data.service.VehicleService
import javax.inject.Inject

class VehicleDataSourceImpl @Inject constructor(
    private val  vehicleService: VehicleService): VehicleDataSource {
    override suspend fun getTaxiLists(): BaseResponse<VehicleResponse> =
        vehicleService.getTaxiLists()
}