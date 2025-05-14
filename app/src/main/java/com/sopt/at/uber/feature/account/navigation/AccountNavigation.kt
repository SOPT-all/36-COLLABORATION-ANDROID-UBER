package com.sopt.at.uber.feature.account.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.at.uber.core.navigation.MainTabRoute
import com.sopt.at.uber.feature.account.AccountScreen
import kotlinx.serialization.Serializable

fun NavController.navigateToAccount(navOptions: NavOptions? = null) {
    navigate(Account, navOptions)
}

fun NavGraphBuilder.accountGraph() {
    composable<Account> {
        AccountScreen()
    }
}

@Serializable
data object Account : MainTabRoute