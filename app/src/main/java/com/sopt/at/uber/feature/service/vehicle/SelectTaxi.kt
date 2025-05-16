package com.sopt.at.uber.feature.service.vehicle

import androidx.annotation.DrawableRes

interface SelectTaxi {
    val taxiName: String
    val capacity: Int
    val priceRange: String
    val description: String
    @get:DrawableRes val taxiIconRes: Int
}
