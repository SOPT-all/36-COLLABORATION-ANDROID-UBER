package com.sopt.at.uber.feature.service.information.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sopt.at.uber.R
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme
import com.sopt.at.uber.core.util.noRippleClickable

@Composable
fun TopBar(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    title: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_topbar_back_arrow),
            contentDescription = "back",
            tint = Color.Unspecified,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .noRippleClickable(onClick = onBackClick)
                .padding(6.dp)
        )
        Text(
            text = title,
            style = AppTheme.typography.title4B18,
            color = AppTheme.colors.bgBlack,
            modifier = Modifier.align(Alignment.Center)
        )

    }
}