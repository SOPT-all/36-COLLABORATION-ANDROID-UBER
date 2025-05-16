package com.sopt.at.uber.feature.service.vehicle

import androidx.annotation.DrawableRes
import com.sopt.at.uber.R

enum class BasicTaxiType(
    override val taxiName: String,
    override val capacity: Int,
    override val priceRange: String,
    override val description: String,
    @DrawableRes override val taxiIconRes: Int
) : SelectTaxi {
    BASICSTANDARD(
        taxiName = "Uber Taxi",
        capacity = 4,
        priceRange = "₩21,700–24,400",
        description = "우버가 제공하는 기본 택시",
        taxiIconRes = R.drawable.img_taxi
    ),
    BASICPREMIUM(
        taxiName = "Uber Taxi",
        capacity = 4,
        priceRange = "₩21,700–24,400",
        description = "세단 프리미엄 서비스",
        taxiIconRes = R.drawable.img_taxi
    )
}
