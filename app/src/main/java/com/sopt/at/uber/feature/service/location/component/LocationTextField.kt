package com.sopt.at.uber.feature.service.location.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.at.uber.R
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.typography
import com.sopt.at.uber.core.util.noRippleClickable

@Composable
fun LocationTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
    focusRequester: FocusRequester = remember { FocusRequester() },
    enabled: Boolean = true,
    textFieldBorderColor: Color? = null,
    leadingContent: @Composable (BoxScope.() -> Unit) = {},
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onFocusChange: (Boolean) -> Unit = {},
) {
    var isFocused by remember { mutableStateOf(false) }
    val borderColor =
        textFieldBorderColor
            ?: when {
                isFocused || value.isEmpty()-> Color.Transparent
                else -> colors.bgGraySub
            }
    val textColor = if (isFocused || value.isEmpty()) colors.textSub2 else colors.textPrimary
    val backgroundColor = if (isFocused || value.isEmpty()) colors.bgGray else colors.bgWhite

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        BasicTextField(
            value = value,
            enabled = enabled,
            onValueChange = { input ->
                onValueChange(input)
            },
            textStyle = typography.body1SB16.merge(color = textColor),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        leadingContent()
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp)
                    ) {
                        if (value.isEmpty()) {
                            Text(
                                text = hint,
                                style = typography.body1SB16.merge(color = colors.textSub3),
                            )
                        }
                        innerTextField()
                    }
                    Box(
                        modifier = Modifier
                            .wrapContentWidth(align = Alignment.End),
                        contentAlignment = Alignment.Center
                    ) {
                        if (value.isNotEmpty() && !isFocused)
                           Icon(
                               imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete),
                               contentDescription = "",
                               tint = colors.iconInactive,
                               modifier = Modifier
                                   .size(24.dp)
                                   .noRippleClickable {
                                       onValueChange("")
                                       focusRequester.requestFocus()
                                   }
                           )
                    }
                }
            },
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            visualTransformation = visualTransformation,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(30.dp),
                )
                .border(1.dp, borderColor, RoundedCornerShape(30.dp))
                .height(48.dp)
                .onFocusChanged {
                    isFocused = it.isFocused
                    onFocusChange(isFocused)
                }
                .focusRequester(focusRequester)
        )
    }
}

@Preview
@Composable
private fun LocationTextFieldPreview() {
    var text by remember { mutableStateOf("") }
    AppTheme{
        LocationTextField(
            value = text,
            onValueChange = { text = it },
            hint = stringResource(R.string.location_hint_departure),
            leadingContent = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_departures),
                    contentDescription = "",
                    tint = colors.textSub3
                )
            }
        )
    }
}