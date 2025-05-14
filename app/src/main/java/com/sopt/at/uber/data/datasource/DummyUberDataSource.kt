package com.sopt.at.uber.data.datasource

import com.sopt.at.uber.data.dto.base.DummyBaseResponse
import com.sopt.at.uber.data.dto.request.DummyServiceRequest
import com.sopt.at.uber.data.dto.response.DummyServiceResponse

interface DummyUberDataSource {
    suspend fun getService(request: DummyServiceRequest): DummyBaseResponse<DummyServiceResponse>
}