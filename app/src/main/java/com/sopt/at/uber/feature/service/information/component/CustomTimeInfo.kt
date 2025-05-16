package com.sopt.at.uber.feature.service.information.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme

enum class TimeInfoType {
    PICKUP, ARRIVAL
}

@Composable
fun CustomTimeInfo(
    modifier: Modifier = Modifier,
    type: TimeInfoType,
    date: String,
    day: String,
    weekday: String,
    meridiem: String,
    hour: String,
    minute: String,
    duration: String? = null
) {
    val title = when (type) {
        TimeInfoType.PICKUP -> "픽업 시간"
        TimeInfoType.ARRIVAL -> "예정 도착 시간"
    }

    Column(modifier = modifier){
        Text(modifier = Modifier.padding(vertical = 4.5.dp),
            text = title,
            style = AppTheme.typography.title4B18,
            color = AppTheme.colors.textPrimary
        )

        Text(buildAnnotatedString {
            if (type == TimeInfoType.PICKUP) {
                withStyle(
                    AppTheme.typography.title5Sb16.toSpanStyle()
                        .copy(color = AppTheme.colors.textPrimary)
                ) {
                    append(date)
                }
                withStyle(
                    AppTheme.typography.caption1M12.toSpanStyle()
                        .copy(color = AppTheme.colors.textSub1)
                ) {
                    append("월 ")
                }
                withStyle(
                    AppTheme.typography.title5Sb16.toSpanStyle()
                        .copy(color = AppTheme.colors.textPrimary)
                ) {
                    append(day)
                }
                withStyle(
                    AppTheme.typography.caption1M12.toSpanStyle()
                        .copy(color = AppTheme.colors.textSub1)
                ) {
                    append("일 ")
                }
                withStyle(
                    AppTheme.typography.title5Sb16.toSpanStyle()
                        .copy(color = AppTheme.colors.textPrimary)
                ) {
                    append(weekday)
                }
                withStyle(
                    AppTheme.typography.caption1M12.toSpanStyle()
                        .copy(color = AppTheme.colors.textSub1)
                ) {
                    append(" / ")
                }
            }

            withStyle(
                AppTheme.typography.caption1M12.toSpanStyle().copy(color = AppTheme.colors.textSub1)
            ) {
                append("$meridiem  ")
            }
            withStyle(
                AppTheme.typography.title5Sb16.toSpanStyle()
                    .copy(color = AppTheme.colors.textPrimary)
            ) {
                append(hour)
            }
            withStyle(
                AppTheme.typography.caption1M12.toSpanStyle().copy(color = AppTheme.colors.textSub1)
            ) {
                append(":")
            }
            withStyle(
                AppTheme.typography.title5Sb16.toSpanStyle()
                    .copy(color = AppTheme.colors.textPrimary)
            ) {
                append(minute)
            }
        })

        if (type == TimeInfoType.ARRIVAL && !duration.isNullOrBlank()) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "예상 운행 시간 약 ${duration}분 소요 예상",
                style = AppTheme.typography.caption1M12,
                color = AppTheme.colors.textSub2
            )
        }
    }
}

@Preview
@Composable
fun TestCustomTimeInfo() {
    AppTheme() {
        Column(modifier = Modifier.background(AppTheme.colors.bgWhite)) {
            CustomTimeInfo(
                type = TimeInfoType.PICKUP,
                date = "05",
                day = "05",
                weekday = "(월)",
                meridiem = "오전",
                hour = "20",
                minute = "16"
            )

            Spacer(modifier = Modifier.height(14.5.dp))

            CustomTimeInfo(
                type = TimeInfoType.ARRIVAL,
                date = "",
                day = "",
                weekday = "",
                meridiem = "오전",
                hour = "20",
                minute = "31",
                duration = "25"
            )
        }
    }

}
