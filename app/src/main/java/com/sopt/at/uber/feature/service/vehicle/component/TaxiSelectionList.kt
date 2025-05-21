package com.sopt.at.uber.feature.service.vehicle.component

import androidx.compose.ui.graphics.Color
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sopt.at.uber.R
import com.sopt.at.uber.core.util.noRippleClickable
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.typography
import com.sopt.at.uber.domain.model.TaxiInfoModel


@Composable
fun TaxiSelectionList(
    taxi: List<TaxiInfoModel>,
    selectedId: Int?,
    onTaxiSelect: (TaxiInfoModel) -> Unit
) {
    Column {
        taxi.forEach { taxi ->
            TaxiOptionItem(
                taxi = taxi,
                selected = taxi.id == selectedId,
                onTaxiClick = { onTaxiSelect(taxi) }
            )
        }
    }
}

@Composable
fun TaxiOptionItem(
    taxi: TaxiInfoModel,
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
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(taxi.image)
                .crossfade(true)
                .placeholder(R.drawable.img_taxi_basic)
                .error(R.drawable.img_taxi_basic)
                .build(),
            contentDescription = taxi.type,
            modifier = Modifier.size(54.dp)
        )



        Spacer(modifier = Modifier.width(2.dp))

        Column(Modifier.weight(1f)) {
            val priceText = "₩%,d-%,d".format(taxi.min, taxi.max)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(taxi.type, style = typography.title4B18)
                Spacer(Modifier.width(8.dp))
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_uber_user),
                    contentDescription = "maxCount",
                )
                Spacer(Modifier.width(2.dp))
                Text("${taxi.guests}", style = typography.caption1M12)
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    taxi.comment,
                    style = typography.caption1M12,
                    color = colors.textSub3
                )
            }
            Text(
                text = priceText,
                style = typography.body1M16,
                color = colors.textSub2
            )
        }
    }
}

@Composable
fun TaxiSelectedItem(
    taxi: TaxiInfoModel,
    onTaxiClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colors.bgWhite)
            .border(width = 2.dp, color = colors.bgBlack, shape = RoundedCornerShape(12.dp))
            .padding(vertical = 7.dp, horizontal = 6.dp)
            .noRippleClickable(onTaxiClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(taxi.image)
                .crossfade(true)
                .placeholder(R.drawable.img_taxi_basic)
                .error(R.drawable.img_taxi_basic)
                .build(),
            contentDescription = taxi.type,
            modifier = Modifier.size(54.dp)
        )

        Spacer(Modifier.width(14.dp))

        Text(
            text = "공항갈 때 / ${taxi.type}",
            style = typography.title4B18,
            color = colors.textPrimary
        )

        Spacer(Modifier.width(5.dp))

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_uber_user),
            contentDescription = "maxCount"
        )

        Spacer(Modifier.width(2.dp))

        Text("${taxi.guests}", style = typography.caption1M12)

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_next_arrow),
            contentDescription = "arrow",
            modifier = Modifier.padding(end = 14.25.dp)
        )
    }

}
