package com.sopt.at.uber.feature.house.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.at.uber.core.navigation.MainTabRoute

import com.sopt.at.uber.feature.house.HouseScreen
import kotlinx.serialization.Serializable


fun NavController.navigateToHouse(navOptions: NavOptions? = null) {
    navigate(House, navOptions)
}

fun NavGraphBuilder.houseGraph() {
    composable<House> {
        HouseScreen()

    }
}

@Serializable
data object House : MainTabRoute