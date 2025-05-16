package com.sopt.at.uber.feature.service.reservation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.sopt.at.uber.core.util.noRippleClickable

@Composable
fun ReservationTopBar(
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_left_arrow),
            contentDescription = "",
            tint = colors.btnActive,
            modifier = Modifier.size(36.dp)
                .noRippleClickable(onBackButtonClick)
        )
        Text(
            text = stringResource(R.string.reservation_top_bar_title),
            style = typography.title1Eb32,
            color = colors.textPrimary
        )
    }
}

@Preview
@Composable
private fun ReservationTopBarPreview() {
    ReservationTopBar(
        onBackButtonClick = {}
    )
}