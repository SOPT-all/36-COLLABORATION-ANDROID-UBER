package com.sopt.at.uber.feature.service.location.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

@Composable
fun CurrentSearchHeader(
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
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_current),
            contentDescription = stringResource(R.string.location_current_search_title),
            tint = colors.iconInactive,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = stringResource(R.string.location_current_search_title),
            style = typography.body2M14.merge(color = colors.textSub2),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = stringResource(R.string.location_current_search_delete_all),
            style = typography.caption1M12.merge(color = colors.point2),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CurrentSearchHeaderPreview() {
    CurrentSearchHeader()
}