package com.sopt.at.uber.domain.repository

import com.sopt.at.uber.domain.model.DummyServiceModel
import com.sopt.at.uber.domain.model.DummyServiceResultModel

interface DummyUberRepository {
    suspend fun getService(request: DummyServiceModel): Result<DummyServiceResultModel>
}