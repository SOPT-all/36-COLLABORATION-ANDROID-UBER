package com.sopt.at.uber.core.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme

@Composable
fun UberPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .size(56.dp) ,  //이부분이 헷갈려용 패딩 주는법 ㅜ
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colors.bgBlack,
            contentColor = AppTheme.colors.textWhite,
        ),
    ) {
        Text(
            text = text,
            style = AppTheme.typography.body1SB16
        )
    }
}

@Preview
@Composable
fun TestTaxiButton() {
    AppTheme() {
        UberPrimaryButton(
            onClick = {},
            text = "차량 서비스 예약"
        )
    }
}