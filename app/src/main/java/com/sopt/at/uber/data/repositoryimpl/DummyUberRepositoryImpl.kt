package com.sopt.at.uber.data.repositoryimpl

import com.sopt.at.uber.data.mapper.toDummyServiceModel
import com.sopt.at.uber.data.mapper.toDummyServiceRequest
import com.sopt.at.uber.data.service.DummyUberService
import com.sopt.at.uber.domain.model.DummyServiceModel
import com.sopt.at.uber.domain.model.DummyServiceResultModel
import com.sopt.at.uber.domain.repository.DummyUberRepository
import javax.inject.Inject

class DummyUberRepositoryImpl @Inject constructor(
    private val dummyUberService: DummyUberService
) : DummyUberRepository {
    override suspend fun getService(request: DummyServiceModel): Result<DummyServiceResultModel> =
        runCatching {
            val response = dummyUberService.getServiceData(
                request = request.toDummyServiceRequest()
            )
            response.data?.toDummyServiceModel() ?: throw Exception("Response data is null")
        }
}