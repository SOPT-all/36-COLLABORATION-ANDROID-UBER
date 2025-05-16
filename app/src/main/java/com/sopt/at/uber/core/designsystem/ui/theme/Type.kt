package com.sopt.at.uber.core.designsystem.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sopt.at.uber.R

val SuitBold = FontFamily(Font(R.font.suit_bold))
val SuitExtraBold = FontFamily(Font(R.font.suit_extrabold))
val SuitSemiBold = FontFamily(Font(R.font.suit_semibold))
val SuitMedium = FontFamily(Font(R.font.suit_medium))
val SuitRegular = FontFamily(Font(R.font.suit_regular))
val SuitLight = FontFamily(Font(R.font.suit_light))
val SuitThin = FontFamily(Font(R.font.suit_thin))

@Immutable
data class AppTypography(
    val header1Sb52: TextStyle,
    val header2B46: TextStyle,
    val title1Eb32: TextStyle,
    val title2Sb30: TextStyle,
    val title3Eb28: TextStyle,
    val title4B18: TextStyle,
    val body1SB16: TextStyle,
    val body1M16: TextStyle,
    val body2M14: TextStyle,
    val caption1M12: TextStyle,
    val caption2Sb10: TextStyle,
)

val defaultAppTypography = AppTypography(
    header1Sb52 = TextStyle(
        fontFamily = SuitSemiBold,
        fontWeight = FontWeight.SemiBold,
        fontSize = 52.sp,
        lineHeight = 78.sp
    ),
    header2B46 = TextStyle(
        fontFamily = SuitBold,
        fontWeight = FontWeight.Bold,
        fontSize = 46.sp,
        lineHeight = 69.sp
    ),
    title1Eb32 = TextStyle(
        fontFamily = SuitExtraBold,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp,
        lineHeight = 48.sp
    ),
    title2Sb30 = TextStyle(
        fontFamily = SuitSemiBold,
        fontWeight = FontWeight.SemiBold,
        fontSize = 30.sp,
        lineHeight = 45.sp
    ),
    title3Eb28 = TextStyle(
        fontFamily = SuitExtraBold,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 28.sp,
        lineHeight = 42.sp
    ),
    title4B18 = TextStyle(
        fontFamily = SuitBold,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 27.sp
    ),
    body1SB16 = TextStyle(
        fontFamily = SuitSemiBold,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    body1M16 = TextStyle(
        fontFamily = SuitMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    body2M14 = TextStyle(
        fontFamily = SuitMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 18.sp
    ),
    caption1M12 = TextStyle(
        fontFamily = SuitMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 18.sp
    ),
    caption2Sb10 = TextStyle(
        fontFamily = SuitSemiBold,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
        lineHeight = 15.sp
    ),
)

val LocalAppTypography = staticCompositionLocalOf { defaultAppTypography }
