package com.sopt.at.uber.core.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sopt.at.uber.R

enum class CustomCarType(
    @StringRes val title: Int,
    @StringRes val subTitle: Int,
    @DrawableRes val iconResId: Int
) {
    AIRPORT(
        R.string.custom_car_title_airport,
        R.string.custom_car_sub_title_airport,
        R.drawable.ic_airplane),
    CHILD(
        R.string.custom_car_title_child,
        R.string.custom_car_sub_title_child,
        R.drawable.ic_baby),
    LONG_WAY(
        R.string.custom_car_title_long_way,
        R.string.custom_car_sub_title_long_way,
        R.drawable.ic_long_way),
    FOREIGNER(
        R.string.custom_car_title_foreigner,
        R.string.custom_car_sub_title_foreigner,
        R.drawable.ic_foreigner)
}