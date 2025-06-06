package com.sopt.at.uber.feature.service.information.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.at.uber.R
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.typography
import com.sopt.at.uber.feature.service.vehicle.component.UberDiscountCoupon
import java.text.DecimalFormat

@Composable
fun CustomPriceInfo(
    modifier: Modifier = Modifier,
    description: String,
    minPrice: Int,
    maxPrice: Int,
    content: @Composable () -> Unit = {}
) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "예상 결제 금액",
                style = typography.title4B18,
                color = colors.textPrimary
            )
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_tag),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = description,
                style = typography.caption1M12,
                color = colors.textSub3
            )
        }

        Spacer(modifier = Modifier.height(4.5.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "₩",
                style = typography.caption1M12,
                color = colors.textSub1
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = formatPrice(minPrice),
                style = typography.body1SB16,
                color = colors.textPrimary
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "-",
                style = typography.caption1M12,
                color = colors.textPrimary
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = formatPrice(maxPrice),
                style = typography.body1SB16,
                color = colors.textPrimary
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        content()
    }
}

private fun formatPrice(price: Int): String {
    return DecimalFormat("#,###").format(price)
}

@Preview
@Composable
private fun TestCustomPriceInfo() {
    AppTheme() {
        CustomPriceInfo(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 10.dp)
                .background(colors.bgWhite),
            description = "적용 가능한 할인 혜택이 없습니다.",
            minPrice = 15000,
            maxPrice = 19000
        ) {
            UberDiscountCoupon(
                price = 5000,
                onCouponSelect = {}
            )
        }
    }
}
