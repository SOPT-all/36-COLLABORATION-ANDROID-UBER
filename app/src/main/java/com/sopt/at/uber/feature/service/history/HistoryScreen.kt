package com.sopt.at.uber.feature.service.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.at.uber.R
import com.sopt.at.uber.core.component.UberPrimaryButton
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.typography
import com.sopt.at.uber.feature.service.information.component.TopBar

@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit
) {
    Scaffold(
        bottomBar = {
            UberPrimaryButton(
                onClick = {},
                text = "예약 내역 보러가기",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            )
        },
        containerColor = colors.bgWhite
    ) { innerPadding ->
        Box(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            TopBar(
                onBackClick = navigateUp,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                title = "예약 정보"
            )
            Column(
                modifier = Modifier
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.history_success_desc),
                    style = typography.title4B18,
                    color = colors.textPrimary
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = stringResource(R.string.history_check_desc),
                    style = typography.body2M14,
                    color = colors.textSub2
                )

                Image(
                    painter = painterResource(R.drawable.img_history_taxi),
                    contentDescription = "taxiImage",
                    modifier = Modifier.size(259.dp)
                )
            }
        }
    }
}



@Preview
@Composable
fun TestHistoryScreen() {
    AppTheme {
        HistoryScreen(
            navigateUp = {},
        )
    }
}