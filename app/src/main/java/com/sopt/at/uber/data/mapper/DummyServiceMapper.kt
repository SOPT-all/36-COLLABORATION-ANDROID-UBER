package com.sopt.at.uber.data.mapper

import com.sopt.at.uber.data.dto.request.DummyServiceRequest
import com.sopt.at.uber.data.dto.response.DummyServiceResponse
import com.sopt.at.uber.domain.model.DummyServiceModel
import com.sopt.at.uber.domain.model.DummyServiceResultModel

fun DummyServiceResponse.toDummyServiceModel() = DummyServiceResultModel(
    info = info
)

fun DummyServiceModel.toDummyServiceRequest() = DummyServiceRequest(
    id = id
)