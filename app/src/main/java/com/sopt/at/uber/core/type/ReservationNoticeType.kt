package com.sopt.at.uber.core.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sopt.at.uber.R

enum class ReservationNoticeType(
    @StringRes val description: Int,
    @DrawableRes val iconResId: Int
) {
    DAYS(
        R.string.reservation_notice_days,
        R.drawable.ic_calendar
    ),
    TIME(
        R.string.reservation_notice_time,
        R.drawable.ic_sandclock
    ),
    CANCEL(
        R.string.reservation_notice_cancel,
        R.drawable.ic_wallet
    )
}