package com.sopt.at.uber.core.util

import com.sopt.at.uber.data.dto.base.BaseResponse
import kotlinx.serialization.json.Json.Default.decodeFromString

fun Throwable.parseErrorMessage(): String = when (this) {
    is retrofit2.HttpException -> {
        response()?.errorBody()?.string()?.let { errorBody ->
            runCatching {
                decodeFromString<BaseResponse<Unit>>(errorBody).msg
            }.getOrElse { e ->
                "에러 응답 파싱 실패: ${e.message}"
            }
        } ?: "에러 응답이 없습니다."
    }
    else -> "알 수 없는 에러가 발생했습니다: $message"
}