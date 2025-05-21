package com.sopt.at.uber.data.mapper

import com.sopt.at.uber.data.dto.response.TaxiInfoResponse
import com.sopt.at.uber.domain.model.TaxiInfoModel

fun TaxiInfoResponse.toTaxiInfoModel(): TaxiInfoModel = TaxiInfoModel(
    id = id,
    type = type,
    min = min,
    max = max,
    guests = guests,
    comment = comment,
    image = image
)