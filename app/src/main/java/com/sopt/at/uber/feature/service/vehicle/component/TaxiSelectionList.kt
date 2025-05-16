package com.sopt.at.uber.feature.service.vehicle.component

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.at.uber.R
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme
import com.sopt.at.uber.core.util.noRippleClickable
import com.sopt.at.uber.feature.service.vehicle.BasicTaxiType
import com.sopt.at.uber.feature.service.vehicle.SelectTaxi
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.typography


@Composable
fun TaxiSelectionList(
    taxiTypes: ImmutableList<SelectTaxi>,
    selectedType: SelectTaxi?,
    onTaxiSelect: (SelectTaxi) -> Unit
) {
    Column {
        taxiTypes.forEach { taxi ->
            TaxiOptionItem(
                taxiType = taxi,
                selected = selectedType === taxi,
                onTaxiClick = { onTaxiSelect(taxi) }
            )
        }
    }
}

@Composable
fun TaxiOptionItem(
    taxiType: SelectTaxi,
    selected: Boolean,
    onTaxiClick: () -> Unit
) {
    val borderColor = if (selected) colors.bgBlack else Color.Transparent

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colors.bgWhite)
            .border(width = 2.dp, color = borderColor, shape = RoundedCornerShape(12.dp))
            .padding(vertical = 9.5.dp, horizontal = 6.dp)
            .noRippleClickable(onTaxiClick),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(taxiType.taxiIconRes),
            contentDescription = taxiType.taxiName,
            modifier = Modifier.size(54.dp)
        )

        Spacer(modifier = Modifier.width(2.dp))

        Column(Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(taxiType.taxiName, style = typography.title4B18)
                Spacer(Modifier.width(8.dp))
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_uber_user),
                    contentDescription = "maxCount",
                )
                Spacer(Modifier.width(2.dp))
                Text("${taxiType.capacity}", style = typography.caption1M12)
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    taxiType.description,
                    style = typography.caption1M12,
                    color = colors.textSub3
                )
            }
            Text(
                taxiType.priceRange,
                style = typography.body1M16,
                color = colors.textSub2
            )
        }
    }
}


@Preview
@Composable
fun TestSelect() {
    AppTheme {
        TaxiSelectionList(
            taxiTypes = BasicTaxiType.entries.toImmutableList(),
            selectedType = BasicTaxiType.BASICPREMIUM,
            onTaxiSelect = {}
        )
    }
}
