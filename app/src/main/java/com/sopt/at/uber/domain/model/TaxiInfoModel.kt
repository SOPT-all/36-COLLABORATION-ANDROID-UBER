package com.sopt.at.uber.domain.model

data class TaxiInfoModel(
    val id: Int,
    val type: String,
    val min: Int,
    val max: Int,
    val guests: Int,
    val comment: String,
    val image: String
)
