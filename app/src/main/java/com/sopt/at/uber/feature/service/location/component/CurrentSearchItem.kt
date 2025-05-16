package com.sopt.at.uber.feature.service.location.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
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
fun CurrentSearchItem(
    locationName: String,
    locationAddress: String,
    dateString: String,
    onDeleteClick: () -> Unit,
    onSectionClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val dividerColor = colors.bgGraySub
    Row(
        modifier = modifier
            .padding(horizontal = 20.dp)
            .drawBehind {
                drawLine(
                    color = dividerColor,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 1.dp.toPx()
                )
            }
            .padding(vertical = 12.dp)
            .noRippleClickable { onSectionClick(locationName) },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
        ) {
            Text(
                text = locationName,
                style = typography.title4B18.merge(color = colors.textPrimary)
            )
            Text(
                text = locationAddress,
                style = typography.caption1M12.merge(color = colors.textSub3)
            )
        }
        Text(
            text = dateString,
            style = typography.body2M14.merge(color = colors.textSub3)
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_current_delete),
            contentDescription = stringResource(R.string.location_description_delete),
            tint = colors.iconInactive,
            modifier = Modifier.noRippleClickable(onDeleteClick)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CurrentSearchItemPreview() {
    CurrentSearchItem(
        locationName = "더좋은세상",
        locationAddress = "서울특별시 송파구 올림픽로35가길 10",
        dateString = "05.06",
        onDeleteClick = {},
        onSectionClick = {}
    )
}