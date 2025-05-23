package com.sopt.at.uber.feature.service.information

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sopt.at.uber.R
import com.sopt.at.uber.core.component.UberPrimaryButton
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.typography
import com.sopt.at.uber.feature.service.ServiceSharedViewModel
import com.sopt.at.uber.feature.service.information.component.*
import com.sopt.at.uber.core.util.TimeInfoFormatter
import com.sopt.at.uber.feature.service.vehicle.component.TaxiSelectedItem
import com.sopt.at.uber.feature.service.vehicle.component.UberDiscountCoupon

@Composable
fun InformationScreen(
    modifier: Modifier = Modifier,
    navigateToVehicle: () -> Unit,
    navigateToHistory: () -> Unit,
    navigateUp: () -> Unit,
    sharedViewModel: ServiceSharedViewModel = hiltViewModel(),
) {
    val selectedTaxi by sharedViewModel.selectedTaxi.collectAsState()
    val selectedDeparture by sharedViewModel.selectedDeparture.collectAsState()
    val selectedDestination by sharedViewModel.selectedDestination.collectAsState()
    val selectedDate by sharedViewModel.selectedDate.collectAsState()
    val selectedTime by sharedViewModel.selectedTime.collectAsState()

    val couponPrice = 5000
    val minPrice = selectedTaxi?.let { it.min - couponPrice } ?: 15000
    val maxPrice = selectedTaxi?.let { it.max - couponPrice } ?: 19000
    val pickup = TimeInfoFormatter.getPickupDisplayData(selectedDate, selectedTime)
    val arrival = TimeInfoFormatter.getArrivalDisplayData(selectedTime)

    Scaffold(
        containerColor = colors.bgWhite
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
                style = typography.title4B18,
                color = colors.bgBlack,
            )
            CustomInfoTextField(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                value = selectedDeparture.text
            )
            CustomInfoTextField(
                modifier = Modifier.padding(horizontal = 16.dp),
                value = selectedDestination.text
            )
            Spacer(modifier = Modifier.height(10.dp))

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
                color = colors.bgGray
            )

            CustomTimeInfo(
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp),
                type = TimeInfoType.PICKUP,
                date = pickup.date,
                day = pickup.day,
                weekday = pickup.weekday,
                meridiem = pickup.meridiem,
                hour = pickup.hour,
                minute = pickup.minute
            )

            CustomTimeInfo(
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp),
                type = TimeInfoType.ARRIVAL,
                date = arrival.date,
                day = arrival.day,
                weekday = arrival.weekday,
                meridiem = arrival.meridiem,
                hour = arrival.hour,
                minute = arrival.minute,
                duration = "25"
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 10.dp),
                thickness = 6.dp,
                color = colors.bgGray
            )

            CustomInfoContent(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                title = "차량 선택",
                description = stringResource(R.string.information_select_car_desc)
            ) {
                selectedTaxi?.let { taxi ->
                    TaxiSelectedItem(
                        taxi = taxi,
                        onTaxiClick = navigateToVehicle
                    )
                } ?: TaxiReservationButton(
                    onClick = navigateToVehicle,
                    text = "차량 서비스 예약"
                )
            }


            HorizontalDivider(
                modifier = Modifier.padding(vertical = 10.dp),
                thickness = 6.dp,
                color = colors.bgGray
            )

            CustomPriceInfo(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                description =
                    if (selectedTaxi != null)
                        stringResource(R.string.information_select_coupon_desc)
                    else
                        stringResource(R.string.information_unselect_coupon_desc),
                minPrice = minPrice,
                maxPrice = maxPrice
            ) {
                if (selectedTaxi != null) {
                    UberDiscountCoupon(
                        price = couponPrice,
                        onCouponSelect = {}
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 10.dp),
                thickness = 6.dp,
                color = colors.bgGray
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
                    style = typography.body1SB16,
                    color = colors.textPrimary
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    modifier = Modifier.padding(end = 13.5.dp),
                    painter = painterResource(R.drawable.ic_next_arrow),
                    contentDescription = "payment",
                    tint = Color.Unspecified
                )
            }
            UberPrimaryButton(
                onClick = navigateToHistory,
                text = selectedTaxi?.type?.let { "$it 예약하기" } ?: "차량 서비스 예약",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            )
        }
    }
}

@Preview
@Composable
fun TestInformationScreen() {
    AppTheme {
        InformationScreen(
            navigateUp = {},
            navigateToHistory = {},
            navigateToVehicle = {}
        )
    }
}
