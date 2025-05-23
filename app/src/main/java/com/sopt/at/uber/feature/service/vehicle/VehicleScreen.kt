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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
import com.sopt.at.uber.feature.service.ServiceSharedViewModel

@Composable
fun VehicleScreen(
    modifier: Modifier = Modifier,
    navigateToInformation: () -> Unit,
    navigateUp: () -> Unit,
    viewModel: VehicleViewModel = hiltViewModel(),
    sharedViewModel: ServiceSharedViewModel = hiltViewModel()

) {
    val vehicleState by viewModel.vehicleState.collectAsState()
    var selectedId by remember { mutableStateOf<Int?>(null) }
    val selectedTaxi = vehicleState?.let {
        (it.taxiList + it.caseTaxiList).find { it.id == selectedId }
    }


    LaunchedEffect(Unit) {
        viewModel.getTaxiLists()
    }
    LaunchedEffect(vehicleState?.caseTaxiList) {
        if (selectedId == null) {
            vehicleState?.caseTaxiList?.firstOrNull()?.let { taxi ->
                selectedId = taxi.id
            }
        }
    }
    Scaffold(
        bottomBar = {
            UberPrimaryButton(
                onClick = {
                    selectedTaxi?.let {
                        sharedViewModel.selectTaxi(it)
                        navigateToInformation()
                    }
                },
                text = "${selectedTaxi?.type ?: "Uber Taxi"} 예약하기",
                enabled = selectedId != null,
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

            vehicleState?.taxiList?.let { basicList ->
                CustomInfoContent(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                    title = stringResource(R.string.vehicle_basic_proposal_title),
                    description = stringResource(R.string.vehicle_select_basic_car_desc)
                ) {
                    TaxiSelectionList(
                        taxi = basicList.toImmutableList(),
                        selectedId = selectedId,
                        onTaxiSelect = { selectedId = it.id }
                    )
                }
            }


            vehicleState?.caseTaxiList?.let { caseList ->
                CustomInfoContent(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                    title = stringResource(R.string.vehicle_situation_proposal_title),
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
                            taxi = caseList.toImmutableList(),
                            selectedId = selectedId,
                            onTaxiSelect = { selectedId = it.id }
                        )
                    }
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
fun TestVehicleScreen() {
    AppTheme {
        VehicleScreen(
            navigateUp = {},
            navigateToInformation = {}
        )
    }
}