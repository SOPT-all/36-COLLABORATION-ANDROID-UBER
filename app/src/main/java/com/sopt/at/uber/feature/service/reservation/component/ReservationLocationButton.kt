package com.sopt.at.uber.feature.service.reservation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.at.uber.R
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.typography

@Composable
fun ReservationLocationButton(
    hint: String,
    leadingContent: @Composable (BoxScope.() -> Unit),
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = colors.bgGray,
                shape = RoundedCornerShape(30.dp)
            )
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            leadingContent()
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        ) {
            Text(
                text = hint,
                style = typography.body1SB16.merge(color = colors.textSub3),
            )
        }
    }
}

@Preview
@Composable
private fun ReservationLocationButtonPreview() {
    ReservationLocationButton(
        leadingContent = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_departures),
                contentDescription = "",
                tint = colors.textSub3
            )
        },
        hint = stringResource(R.string.location_hint_departure)
    )
}