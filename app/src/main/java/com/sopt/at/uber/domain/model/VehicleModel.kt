package com.sopt.at.uber.domain.model


data class VehicleModel(
    val taxiList: List<TaxiInfoModel>,
    val caseTaxiList: List<TaxiInfoModel>
)