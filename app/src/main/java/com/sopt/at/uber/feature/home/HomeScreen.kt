package com.sopt.at.uber.feature.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sopt.at.uber.R
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToReservation: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.bgWhite)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Image(
                painter = painterResource(id = R.drawable.header),
                contentDescription = "헤더",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.card_content),
                contentDescription = "차량 서비스 및 예약 카드",
                modifier = Modifier.fillMaxWidth()
                    .padding(top=20.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.coupon),
                contentDescription = "우버 5000원 할인 쿠폰",
                modifier = Modifier.fillMaxWidth()
                    .padding(top=20.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(328.dp)
                    .height(153.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {

                Image(
                    painter = painterResource(id = R.drawable.reserve_content),
                    contentDescription = "예약 전체 이미지",
                    modifier = Modifier
                        .fillMaxSize()
                )

                Button(
                    onClick = {  navigateToReservation() },
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colors.bgWhite),
                            border = BorderStroke(1.dp, colors.iconInactive),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 19.dp, bottom = 19.dp)
                ) {
                    Text(
                        text = "Reserve 이용해보기",
                        color = colors.bgBlack
                    )
                }
            }
        }
    }
}