package com.sopt.at.uber.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.sopt.at.uber.feature.account.navigation.navigateToAccount
import com.sopt.at.uber.feature.activity.navigation.navigateToActivity
import com.sopt.at.uber.feature.home.navigation.Home
import com.sopt.at.uber.feature.home.navigation.navigateToHome
import com.sopt.at.uber.feature.house.navigation.navigateToHouse


class MainNavigator(
    val navController: NavHostController
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val startDestination = Home

    val currentTab: MainNavTab?
        @Composable get() = MainNavTab.find { tab ->
            currentDestination?.hasRoute(tab::class) == true
        }

    fun navigate(tab: MainNavTab) {
        val navOptions = navOptions {
            navController.currentDestination?.route?.let {
                popUpTo(it) {
                    inclusive = true
                    saveState = true
                }
            }
            launchSingleTop = true
            restoreState = true
        }
        when (tab) {
            MainNavTab.HOUSE -> navController.navigateToHouse(navOptions)
            MainNavTab.HOME -> navController.navigateToHome(navOptions)
            MainNavTab.ACTIVITY -> navController.navigateToActivity(navOptions)
            MainNavTab.ACCOUNT -> navController.navigateToAccount(navOptions)
        }
    }


    @Composable
    fun showBottomBar() = MainNavTab.contains {
        currentDestination?.hasRoute(it::class) == true
    }

    fun navigateUp() {
        navController.navigateUp()
    }

}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController()
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}