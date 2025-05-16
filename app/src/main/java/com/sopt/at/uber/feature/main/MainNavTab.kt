package com.sopt.at.uber.feature.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.sopt.at.uber.R.drawable.ic_house_selected
import com.sopt.at.uber.R.drawable.ic_home_selected
import com.sopt.at.uber.R.drawable.ic_activity_selected
import com.sopt.at.uber.R.drawable.ic_account_selected
import com.sopt.at.uber.R.string.ic_home_desc
import com.sopt.at.uber.R.string.ic_house_desc
import com.sopt.at.uber.R.string.ic_activity_desc
import com.sopt.at.uber.R.string.ic_account_desc
import com.sopt.at.uber.core.navigation.MainTabRoute
import com.sopt.at.uber.core.navigation.Route
import com.sopt.at.uber.feature.account.navigation.Account
import com.sopt.at.uber.feature.activity.navigation.Activity
import com.sopt.at.uber.feature.home.navigation.Home
import com.sopt.at.uber.feature.house.navigation.House

enum class MainNavTab (
    @DrawableRes val icon: Int,
    @StringRes val contentDescription: Int,
    val route: MainTabRoute
){
    HOUSE(
        icon = ic_house_selected,
        contentDescription = ic_house_desc,
        route = House
    ),
    HOME(
        icon = ic_home_selected,
        contentDescription = ic_home_desc,
        route = Home
    ),
    ACTIVITY(
        icon = ic_activity_selected,
        contentDescription = ic_activity_desc,
        route = Activity
    ),
    ACCOUNT(
        icon = ic_account_selected,
        contentDescription = ic_account_desc,
        route = Account
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean) : MainNavTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }


}