package com.sopt.at.uber.data.mapper

import com.sopt.at.uber.data.dto.response.VehicleResponse
import com.sopt.at.uber.domain.model.VehicleModel

fun VehicleResponse.toVehicleModel(): VehicleModel {
    return VehicleModel(
        taxiList = taxiList.map { it.toTaxiInfoModel() },
        caseTaxiList = caseTaxiList.map { it.toTaxiInfoModel() }
    )
}