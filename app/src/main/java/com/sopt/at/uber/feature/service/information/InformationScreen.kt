package com.sopt.at.uber.feature.service.information

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.at.uber.R
import com.sopt.at.uber.core.component.UberPrimaryButton
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme
import com.sopt.at.uber.feature.service.information.component.*

@Composable
fun InformationScreen(
    modifier: Modifier = Modifier,
    navigateToVehicle: () -> Unit,
    navigateUp: () -> Unit
) {
    Scaffold(
        bottomBar = {
            UberPrimaryButton(
                onClick = navigateToVehicle,
                text = "차량 서비스 예약",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            )
        },
        containerColor = AppTheme.colors.bgWhite
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            TopBar(
                onBackClick = navigateUp,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                title = "차량 서비스 예약"
            )
            Text(
                modifier = Modifier.padding(horizontal = 17.5.dp, vertical = 14.5.dp),
                text = "출발/도착 장소",
                style = AppTheme.typography.title4B18,
                color = AppTheme.colors.bgBlack,
            )
            CustomInfoTextField(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                value = "서울시 마포구 동교로 19길 86"
            )
            CustomInfoTextField(
                modifier = Modifier.padding(horizontal = 16.dp),
                value = "김포공항"
            )
            Spacer(modifier = Modifier.height(10.dp))

            // TODO: 지도 수정
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 10.dp)
                    .height(150.dp),
                painter = painterResource(R.drawable.img_route),
                contentDescription = "map",
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 10.dp),
                thickness = 6.dp,
                color = AppTheme.colors.bgGray
            )

            CustomTimeInfo(
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp),
                type = TimeInfoType.PICKUP,
                date = "05",
                day = "05",
                weekday = "(월)",
                meridiem = "오전",
                hour = "20",
                minute = "16"
            )
            CustomTimeInfo(
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp),
                type = TimeInfoType.ARRIVAL,
                date = "",
                day = "",
                weekday = "",
                meridiem = "오전",
                hour = "20",
                minute = "31",
                duration = "25"
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 10.dp),
                thickness = 6.dp,
                color = AppTheme.colors.bgGray
            )

            CustomInfoContent(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                title = "차량 선택",
                description = stringResource(R.string.select_car_desc)
            ) {
                TaxiReservationButton(
                    onClick = navigateToVehicle,
                    text = "차량 서비스 예약"
                )
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 10.dp),
                thickness = 6.dp,
                color = AppTheme.colors.bgGray
            )

            CustomPriceInfo(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                description = "적용 가능한 할인 혜택이 없습니다.",
                minPrice = 15000,
                maxPrice = 19000
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 10.dp),
                thickness = 6.dp,
                color = AppTheme.colors.bgGray
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                Icon(
                    modifier = Modifier.size(36.dp),
                    painter = painterResource(R.drawable.img_visa_card),
                    contentDescription = "card",
                    tint = Color.Unspecified,
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "직접결제",
                    style = AppTheme.typography.title5Sb16,
                    color = AppTheme.colors.textPrimary
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    modifier = Modifier.padding(end = 13.5.dp),
                    painter = painterResource(R.drawable.ic_next_arrow),
                    contentDescription = "payment",
                    tint = Color.Unspecified
                )
            }
        }
    }
}

@Preview
@Composable
fun TestInformationScreen() {
    AppTheme {
        InformationScreen(
            navigateUp = {},
            navigateToVehicle = {}
        )
    }
}
