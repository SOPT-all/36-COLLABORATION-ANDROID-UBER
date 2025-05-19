package com.sopt.at.uber.feature.service.vehicle

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.at.uber.R
import com.sopt.at.uber.core.component.CustomCarItem
import com.sopt.at.uber.core.component.UberPrimaryButton
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme
import com.sopt.at.uber.core.type.CustomCarType
import com.sopt.at.uber.feature.service.information.component.CustomInfoContent
import com.sopt.at.uber.feature.service.information.component.TopBar
import com.sopt.at.uber.feature.service.vehicle.component.TaxiSelectionList
import kotlinx.collections.immutable.toImmutableList
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors

@Composable
fun VehicleScreen(
    modifier: Modifier = Modifier,
    navigateToHistory: () -> Unit,
    navigateUp: () -> Unit
) {
    var selectedType: SelectTaxi by remember { mutableStateOf(AirportTaxiType.STANDARD) }

    Scaffold(
        bottomBar = {
            UberPrimaryButton(
                onClick = navigateToHistory,
                text = "차량 서비스 예약",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            )
        },
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
                title = "차량 선택"
            )

            CustomInfoContent(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                title = stringResource(R.string.vehicle_basic_proposal_title),
                description = stringResource(R.string.vehicle_select_basic_car_desc)
            ) {
                TaxiSelectionList(
                    taxiTypes = BasicTaxiType.entries.toImmutableList(),
                    selectedType = selectedType,
                    onTaxiSelect = { selectedType = it }
                )
            }

            CustomInfoContent(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                title = stringResource(R.string.vehicle_situation_proposal_title) ,
                description = stringResource(R.string.vehicle_select_basic_car_desc)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colors.bgWhite)
                        .border(
                            width = 1.dp,
                            color = colors.btnActive,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(vertical = 16.dp, horizontal = 7.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    CustomCarItem(
                        type = CustomCarType.AIRPORT,
                        modifier = Modifier.fillMaxWidth()
                    )

                    TaxiSelectionList(
                        taxiTypes = AirportTaxiType.entries.toImmutableList(),
                        selectedType = selectedType,
                        onTaxiSelect = { selectedType = it }
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CustomCarType.entries
                    .filterNot { it == CustomCarType.AIRPORT }
                    .toImmutableList()
                    .forEach { type ->
                        CustomCarItem(
                            isGrayColor = true,
                            type = type
                        )
                    }
            }
        }
    }
}

@Preview
@Composable
fun TestInformationScreen() {
    AppTheme {
        VehicleScreen(
            navigateUp = {},
            navigateToHistory = {}
        )
    }
}