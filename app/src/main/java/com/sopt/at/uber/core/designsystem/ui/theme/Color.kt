package com.sopt.at.uber.core.designsystem.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

val TextPrimary = Color(0xFF202020)
val TextSub1 = Color(0xFF4C4C4C)
val TextSub2 = Color(0xFF6E6E6E)
val TextSub3 = Color(0xFFAFAFAF)
val TextWhite = Color(0xFFFFFFFF)
val Point1 = Color(0xFF007AFF)
val Point2 = Color(0xFFFF5968)

val IconActive = Color(0xFF000000)
val IconInactive = Color(0xFF707070)
val IconInfo1 = Color(0xFFFD9E9F)
val IconInfo2 = Color(0xFF5E7CCC)
val IconInfo3 = Color(0xFFFABC5C)
val IconInfo4 = Color(0xFF927ECF)
val IconInfo5 = Color(0xFF388148)

val BtnActive = Color(0xFF000000)
val BtnInactive = Color(0xFFFFFFFF)

val BgBlack = Color(0xFF000000)
val BgGraySub = Color(0xFFE8E8E8)
val BgGray = Color(0xFFF3F3F3)
val BgWhite = Color(0xFFFFFFFF)
val BgGrayscale = Color(0x99000000)

val BorderBlack = Color(0xFF000000)

@Immutable
data class AppColors(
    val textPrimary: Color,
    val textSub1: Color,
    val textSub2: Color,
    val textSub3: Color,
    val textWhite: Color,
    val point1: Color,
    val point2: Color,

    val iconActive: Color,
    val iconInactive: Color,
    val iconInfo1: Color,
    val iconInfo2: Color,
    val iconInfo3: Color,
    val iconInfo4: Color,
    val iconInfo5: Color,

    val btnActive: Color,
    val btnInactive: Color,

    val bgBlack: Color,
    val bgGraySub: Color,
    val bgGray: Color,
    val bgWhite: Color,
    val bgGrayscale: Color,

    val borderBlack: Color,
)

val defaultAppColors = AppColors(
    textPrimary = TextPrimary,
    textSub1 = TextSub1,
    textSub2 = TextSub2,
    textSub3 = TextSub3,
    textWhite = TextWhite,
    point1 = Point1,
    point2 = Point2,

    iconActive = IconActive,
    iconInactive = IconInactive,
    iconInfo1 = IconInfo1,
    iconInfo2 = IconInfo2,
    iconInfo3 = IconInfo3,
    iconInfo4 = IconInfo4,
    iconInfo5 = IconInfo5,

    btnActive = BtnActive,
    btnInactive = BtnInactive,

    bgBlack = BgBlack,
    bgGraySub = BgGraySub,
    bgGray = BgGray,
    bgWhite = BgWhite,
    bgGrayscale = BgGrayscale,

    borderBlack = BorderBlack
)
val LocalAppColors = staticCompositionLocalOf { defaultAppColors }
