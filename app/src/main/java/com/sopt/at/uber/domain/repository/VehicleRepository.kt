package com.sopt.at.uber.domain.repository

import com.sopt.at.uber.domain.model.VehicleModel

interface VehicleRepository {
    suspend fun getTaxiLists() : Result<VehicleModel>
}