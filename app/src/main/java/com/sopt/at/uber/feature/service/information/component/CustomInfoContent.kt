package com.sopt.at.uber.feature.service.information.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.typography


@Composable
fun CustomInfoContent(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    content: @Composable () -> Unit = {}
) {
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.padding(vertical = 4.5.dp),
            text = title,
            style = typography.title4B18,
            color = colors.textPrimary
        )
        Text(modifier = Modifier.padding(bottom = 10.dp),
            text = description,
            style = typography.caption1M12,
            color = colors.textSub2
        )

        content()
    }
}



@Preview
@Composable
fun TestCustomInfoContent() {
    AppTheme() {
        Column(
            Modifier
                .fillMaxWidth()
                .background(colors.bgWhite)
                .padding(horizontal = 16.dp)
        ) {
            CustomInfoContent(
                title = "테스트",
                description = "테스트 내용"
            ) {
                TaxiReservationButton(
                    onClick = {},
                    text = "차량 서비스 예약"
                )
            }

        }
    }
}