package com.sopt.at.uber.feature.main.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.at.uber.core.designsystem.ui.theme.UberTheme
import com.sopt.at.uber.core.util.noRippleClickable
import com.sopt.at.uber.feature.main.MainNavTab
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun MainBottomBar(
    visible: Boolean,
    tabs: ImmutableList<MainNavTab>,
    currentTab: MainNavTab?,
    onTabSelected: (MainNavTab) -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = EnterTransition.None,
        exit = ExitTransition.None,
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
        ) {
            HorizontalDivider(
                color = Color.LightGray,
                thickness = 1.dp
            )
            Row(
                modifier = Modifier
                    .navigationBarsPadding()
                    .fillMaxWidth()
                    .padding(vertical = 13.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            )
            {
                tabs.forEach { tab ->
                    key(tab.route) {
                        val selected = currentTab == tab
                        MainBottomBarItem(
                            tab = tab,
                            selected = selected,
                            onClick = { onTabSelected(tab) }
                        )
                    }
                }
            }
        }
    }

}

@Composable
fun RowScope.MainBottomBarItem(
    modifier: Modifier = Modifier,
    tab: MainNavTab,
    selected: Boolean,
    onClick: () -> Unit
) {
    val bottomItemColor = if (selected) Color.Black else Color.Gray
    Column(
        modifier = modifier
            .noRippleClickable(onClick = onClick)
            .weight(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(tab.icon),
            contentDescription = stringResource(tab.contentDescription),
            tint = bottomItemColor,
        )
        Text(
            text = stringResource(tab.contentDescription),
            fontSize = 11.sp,
            color = bottomItemColor
        )
    }

}

@Preview
@Composable
private fun MainBottomBarPreview() {
    UberTheme {
        var currentTab by remember { mutableStateOf(MainNavTab.HOME) }
        MainBottomBar(
            visible = true,
            tabs = MainNavTab.entries.toImmutableList(),
            currentTab = currentTab,
            onTabSelected = { currentTab = it }
        )
    }
}