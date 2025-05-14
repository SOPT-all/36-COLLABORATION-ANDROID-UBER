package com.sopt.at.uber.data.service

import com.sopt.at.uber.data.dto.base.DummyBaseResponse
import com.sopt.at.uber.data.dto.request.DummyServiceRequest
import com.sopt.at.uber.data.dto.response.DummyServiceResponse
import retrofit2.http.Body
import retrofit2.http.GET

interface DummyUberService {
    companion object {
        const val API = "api"
        const val V1 = "v1"
        const val SERVICE = "service"
    }

    @GET("/$API/$V1/$SERVICE")
    suspend fun getServiceData(
        @Body request: DummyServiceRequest
    ): DummyBaseResponse<DummyServiceResponse>

}