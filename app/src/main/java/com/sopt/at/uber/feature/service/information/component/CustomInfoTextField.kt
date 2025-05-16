package com.sopt.at.uber.feature.service.information.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sopt.at.uber.R
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.typography

@Composable
fun CustomInfoTextField(
    modifier: Modifier = Modifier,
    value: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(30.dp))
            .border(
                width = 1.dp,
                color = colors.bgGraySub,
                shape = RoundedCornerShape(30.dp)
            )
            .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_uber_place),
            contentDescription = "",
            tint = Color.Unspecified,
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = value,
            style = typography.body1SB16
        )
    }
}