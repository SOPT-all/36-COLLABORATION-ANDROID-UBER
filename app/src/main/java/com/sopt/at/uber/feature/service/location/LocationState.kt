package com.sopt.at.uber.feature.service.location

import com.sopt.at.uber.core.type.LocationFieldType
import com.sopt.at.uber.domain.model.SearchKeywordModel

data class LocationState(
    val currentSearchList: List<SearchKeywordModel> = emptyList(),
    val activeField: LocationFieldType = LocationFieldType.DEPARTURE,
    val errorMessage: String? = null
)