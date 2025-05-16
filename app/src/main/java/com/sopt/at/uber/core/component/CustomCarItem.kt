package com.sopt.at.uber.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.typography
import com.sopt.at.uber.core.type.CustomCarType

@Composable
fun CustomCarItem(
    type: CustomCarType,
    modifier: Modifier = Modifier,
    isGrayColor: Boolean = false
) {
    val iconColor = if (isGrayColor) colors.iconInactive else Color.Unspecified

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = colors.bgWhite,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(
                vertical = 12.dp,
                horizontal = 16.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(type.iconResId),
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier
                .background(
                    color = colors.bgGray,
                    shape = CircleShape
                )
                .padding(14.dp)
                .size(26.dp)
        )
        Column(
            modifier = Modifier.padding(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
        ){
            Text(
                text = stringResource(type.subTitle),
                style = typography.caption1M12.merge(color = colors.textSub1)
            )
            Text(
                text = stringResource(type.title),
                style = typography.title4B18.merge(color = colors.textPrimary)
            )
        }
    }
}

@Preview
@Composable
private fun PreviewCustomCarItem() {
    CustomCarItem(
        type = CustomCarType.CHILD,
        isGrayColor = true
    )
}