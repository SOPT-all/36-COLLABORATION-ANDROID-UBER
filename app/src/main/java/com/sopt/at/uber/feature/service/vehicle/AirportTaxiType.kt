package com.sopt.at.uber.feature.service.vehicle

import androidx.annotation.DrawableRes
import com.sopt.at.uber.R

enum class AirportTaxiType(
    override val taxiName: String,
    override val capacity: Int,
    override val priceRange: String,
    override val description: String,
    @DrawableRes override val taxiIconRes: Int
) : SelectTaxi {
    STANDARD(
        taxiName = "Staria",
        capacity = 6,
        priceRange = "₩21,700–24,400",
        description = "캐리어가 넉넉하게 들어가는 실내 공간",
        taxiIconRes = R.drawable.img_taxi
    ),
    PREMIUM(
        taxiName = "Uber Taxi",
        capacity = 4,
        priceRange = "₩21,700–24,400",
        description = "널널한 여유공간, 쾌적한 운행",
        taxiIconRes = R.drawable.img_taxi
    )
}
