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
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.typography

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

    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(vertical = 4.5.dp),
            text = title,
            style = typography.title4B18,
            color = colors.textPrimary
        )

        Text(buildAnnotatedString {
            if (type == TimeInfoType.PICKUP) {
                withStyle(
                    typography.body1SB16.toSpanStyle()
                        .copy(color = colors.textPrimary)
                ) {
                    append(date)
                }
                withStyle(
                    typography.caption1M12.toSpanStyle()
                        .copy(color = colors.textSub1)
                ) {
                    append("월 ")
                }
                withStyle(
                    typography.body1SB16.toSpanStyle()
                        .copy(color = colors.textPrimary)
                ) {
                    append(day)
                }
                withStyle(
                    typography.caption1M12.toSpanStyle()
                        .copy(color = colors.textSub1)
                ) {
                    append("일 ")
                }
                withStyle(
                    typography.body1SB16.toSpanStyle()
                        .copy(color = colors.textPrimary)
                ) {
                    append(weekday)
                }
                withStyle(
                    typography.caption1M12.toSpanStyle()
                        .copy(color = colors.textSub1)
                ) {
                    append(" / ")
                }
            }

            withStyle(
                typography.caption1M12.toSpanStyle().copy(color = colors.textSub1)
            ) {
                append("$meridiem  ")
            }
            withStyle(
                typography.body1SB16.toSpanStyle()
                    .copy(color = colors.textPrimary)
            ) {
                append(hour)
            }
            withStyle(
                typography.caption1M12.toSpanStyle().copy(color = colors.textSub1)
            ) {
                append(":")
            }
            withStyle(
                typography.body1SB16.toSpanStyle()
                    .copy(color = colors.textPrimary)
            ) {
                append(minute)
            }
        })

        if (type == TimeInfoType.ARRIVAL && !duration.isNullOrBlank()) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "예상 운행 시간 약 ${duration}분 소요 예상",
                style = typography.caption1M12,
                color = colors.textSub2
            )
        }
    }
}

@Preview
@Composable
fun TestCustomTimeInfo() {
    AppTheme() {
        Column(modifier = Modifier.background(colors.bgWhite)) {
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
