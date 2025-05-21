package com.sopt.at.uber.feature.service.vehicle.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.at.uber.R
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.typography
import com.sopt.at.uber.core.util.noRippleClickable

@Composable
fun UberDiscountCoupon(
    price: Int,
    onCouponSelect: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(95.dp)
            .background(colors.bgWhite)
            .border(width = 3.dp, color = colors.bgBlack, shape = RoundedCornerShape(15.dp))
            .padding(vertical = 5.dp, horizontal = 4.dp)
            .noRippleClickable(onCouponSelect),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 20.dp)
        ) {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.ic_tag),
                    contentDescription = "tag",
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${price}원",
                    style = typography.title4B18,
                    color = colors.textPrimary
                )
            }

            Text(
                text = "첫 결제 할인 혜택 쿠폰",
                style = typography.caption1M12,
                color = colors.textSub2
            )
            Text(
                text = "운행 금액과 무관하게 적용 가능 ",
                style = typography.caption1M12,
                color = colors.textSub3
            )
            Text(
                text = "*Uber Black Taxi에는 사용 불가",
                style = typography.caption1M12,
                color = colors.textSub3
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_current_delete),
            contentDescription = "arrow",
            tint = colors.iconActive,
            modifier = Modifier.padding(end = 16.5.dp)
        )
    }
}

@Preview
@Composable
fun TestCoupon() {
    AppTheme {
        UberDiscountCoupon(price = 5000, onCouponSelect = {})
    }
}

