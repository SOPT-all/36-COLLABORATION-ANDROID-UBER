package com.sopt.at.uber.data.repositoryimpl

import com.sopt.at.uber.data.datasource.VehicleDataSource
import com.sopt.at.uber.data.mapper.toVehicleModel
import com.sopt.at.uber.domain.model.VehicleModel
import com.sopt.at.uber.domain.repository.VehicleRepository
import javax.inject.Inject

class VehicleRepositoryImpl @Inject constructor(
    private val vehicleDataSource: VehicleDataSource
) : VehicleRepository {
    override suspend fun getTaxiLists(): Result<VehicleModel> =
        runCatching {
            val response = vehicleDataSource.getTaxiLists()
            response.data?.toVehicleModel() ?: throw Exception("null")
        }
}