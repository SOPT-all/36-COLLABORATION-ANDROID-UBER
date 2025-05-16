package com.sopt.at.uber.feature.service.information.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
fun TaxiReservationButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, AppTheme.colors.bgBlack),
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colors.bgWhite,
            contentColor = AppTheme.colors.textPrimary
        ),
        contentPadding = PaddingValues(vertical = 14.dp)

    ) {
        Text(
            text = text,
            style = AppTheme.typography.title5Sb16
        )
    }
}

@Preview
@Composable
fun TestTaxiButton() {
    AppTheme() {
        TaxiReservationButton(
            onClick = {},
            text = "차량 서비스 예약"
        )
    }
}