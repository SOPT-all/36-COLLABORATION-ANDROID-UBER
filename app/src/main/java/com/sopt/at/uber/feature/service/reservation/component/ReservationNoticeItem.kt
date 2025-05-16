package com.sopt.at.uber.feature.service.reservation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.typography
import com.sopt.at.uber.core.type.ReservationNoticeType

@Composable
fun ReservationNoticeItem(
    type: ReservationNoticeType,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(type.iconResId),
            contentDescription = "",
            tint = colors.iconActive,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = stringResource(type.description),
            style = typography.body2M14,
            color = colors.textSub2
        )
    }
}

@Preview
@Composable
private fun ReservationNoticeItemPreview() {
    ReservationNoticeItem(
        type = ReservationNoticeType.CANCEL
    )
}