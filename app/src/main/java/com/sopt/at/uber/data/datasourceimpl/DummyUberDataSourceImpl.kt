package com.sopt.at.uber.data.datasourceimpl

import com.sopt.at.uber.data.datasource.DummyUberDataSource
import com.sopt.at.uber.data.dto.base.DummyBaseResponse
import com.sopt.at.uber.data.dto.request.DummyServiceRequest
import com.sopt.at.uber.data.dto.response.DummyServiceResponse
import com.sopt.at.uber.data.service.DummyUberService
import javax.inject.Inject

class DummyUberDataSourceImpl @Inject constructor(
    private val dummyUberService: DummyUberService
) : DummyUberDataSource {
    override suspend fun getService(request: DummyServiceRequest): DummyBaseResponse<DummyServiceResponse> =
        dummyUberService.getServiceData(request)
}