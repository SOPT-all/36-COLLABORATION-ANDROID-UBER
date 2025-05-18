package com.sopt.at.uber.feature.service.time.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeScreen(
    onNextClick: () -> Unit
) {
    val context = LocalContext.current

    SideEffect {
        Locale.setDefault(Locale.KOREA)
        val resources = context.resources
        val config = resources.configuration
        config.setLocale(Locale.KOREA)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    var selectedTime by remember { mutableStateOf(LocalTime.now()) }
    var showTimePicker by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }

    val todayMillis =
        LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
    val timePickerState = rememberTimePickerState(
        initialHour = selectedTime.hour,
        initialMinute = selectedTime.minute,
        is24Hour = false
    )

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant()
            .toEpochMilli(),
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return utcTimeMillis >= todayMillis
            }
        }
    )

    val amPm = if (selectedTime.hour < 12) "오전" else "오후"
    val hour12 = if (selectedTime.hour % 12 == 0) 12 else selectedTime.hour % 12
    val minuteFormatted = selectedTime.minute.toString().padStart(2, '0')

    val dayOfWeekKorean = when (selectedDate.dayOfWeek) {
        DayOfWeek.MONDAY -> "월"
        DayOfWeek.TUESDAY -> "화"
        DayOfWeek.WEDNESDAY -> "수"
        DayOfWeek.THURSDAY -> "목"
        DayOfWeek.FRIDAY -> "금"
        DayOfWeek.SATURDAY -> "토"
        DayOfWeek.SUNDAY -> "일"
    }

    val customDatePickerColors = DatePickerDefaults.colors(
        containerColor = AppTheme.colors.bgWhite,
        weekdayContentColor = AppTheme.colors.textSub1,
        dayContentColor = AppTheme.colors.bgBlack,
        disabledDayContentColor = AppTheme.colors.textSub3,
        selectedDayContainerColor = AppTheme.colors.bgBlack,
        selectedDayContentColor = AppTheme.colors.bgWhite,
        todayContentColor = AppTheme.colors.textSub3,
        todayDateBorderColor = AppTheme.colors.textSub3,
        dividerColor = AppTheme.colors.bgBlack,
        selectedYearContainerColor = AppTheme.colors.bgBlack,
        selectedYearContentColor = AppTheme.colors.bgWhite,
        yearContentColor = AppTheme.colors.textSub1
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppTheme.colors.bgWhite
    ) {
        if (showDatePicker) {
            Dialog(
                onDismissRequest = { showDatePicker = false },
                properties = DialogProperties(usePlatformDefaultWidth = false)
            ) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = AppTheme.colors.bgWhite,
                    modifier = Modifier
                        .width(500.dp)
                        .padding(5.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                    ) {
                        DatePicker(
                            state = datePickerState,
                            colors = customDatePickerColors,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            TextButton(
                                onClick = { showDatePicker = false },
                                colors = ButtonDefaults.textButtonColors(
                                    contentColor = AppTheme.colors.bgBlack,
                                    containerColor = Color.Transparent,
                                    disabledContentColor = AppTheme.colors.textSub3
                                ),
                            ) {
                                Text("취소")
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            TextButton(
                                onClick = {
                                    datePickerState.selectedDateMillis?.let {
                                        selectedDate = Instant.ofEpochMilli(it)
                                            .atZone(ZoneId.systemDefault())
                                            .toLocalDate()
                                    }
                                    showDatePicker = false
                                },
                                colors = ButtonDefaults.textButtonColors(
                                    contentColor = AppTheme.colors.bgBlack,
                                    containerColor = Color.Transparent,
                                    disabledContentColor = AppTheme.colors.textSub3
                                )
                            ) {
                                Text("확인")
                            }
                        }
                    }
                }
            }
        }

        val customTimePickerColors = TimePickerDefaults.colors(
            containerColor = AppTheme.colors.bgWhite,
            clockDialColor = AppTheme.colors.bgGray,
            selectorColor = AppTheme.colors.bgBlack,
            periodSelectorBorderColor = AppTheme.colors.textSub3,
            clockDialSelectedContentColor = AppTheme.colors.bgWhite,
            clockDialUnselectedContentColor = AppTheme.colors.textSub1,
            periodSelectorSelectedContainerColor = AppTheme.colors.bgBlack,
            periodSelectorUnselectedContainerColor = AppTheme.colors.bgGray,
            periodSelectorSelectedContentColor = AppTheme.colors.bgWhite,
            periodSelectorUnselectedContentColor = AppTheme.colors.textSub1,
            timeSelectorSelectedContainerColor = AppTheme.colors.bgBlack,
            timeSelectorUnselectedContainerColor = AppTheme.colors.bgGray,
            timeSelectorSelectedContentColor = AppTheme.colors.bgWhite,
            timeSelectorUnselectedContentColor = AppTheme.colors.textSub1,
        )

        if (showTimePicker) {
            AlertDialog(
                onDismissRequest = { showTimePicker = false },
                confirmButton = {
                    TextButton(onClick = {
                        selectedTime = LocalTime.of(timePickerState.hour, timePickerState.minute)
                        showTimePicker = false
                    }) {
                        Text("확인", color = AppTheme.colors.bgBlack)
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showTimePicker = false }) {
                        Text("취소", color = AppTheme.colors.bgBlack)
                    }
                },
                title = { Text("시간 선택", color = AppTheme.colors.bgBlack) },
                text = {
                    TimePicker(
                        state = timePickerState,
                        colors = customTimePickerColors
                    )
                },
                containerColor = AppTheme.colors.bgWhite
            )

        }

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(text = "픽업 시간", style = AppTheme.typography.title1Eb32,
                modifier = Modifier
                    .padding(top = 36.dp, start = 14.dp, bottom = 89.dp))
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    showDatePicker = true
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppTheme.colors.bgWhite,
                    contentColor = AppTheme.colors.textPrimary
                )
            ) {
                Text(
                    text = "${selectedDate.monthValue}월 ${selectedDate.dayOfMonth}일 ($dayOfWeekKorean)",
                    style = AppTheme.typography.title4B18,
                    color = AppTheme.colors.bgBlack
                )
            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                color = AppTheme.colors.bgGraySub,
                thickness = 1.dp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { showTimePicker = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(top= 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppTheme.colors.bgWhite,
                    contentColor = AppTheme.colors.textPrimary
                )
            ) {
                Text("$amPm $hour12:$minuteFormatted",
                    style = AppTheme.typography.title4B18)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "도착 시간 12:30pm KST",
                style = AppTheme.typography.body1M16,
                color = AppTheme.colors.bgBlack,
                modifier = Modifier.fillMaxWidth()
                    .padding(top=10.dp),
                textAlign = TextAlign.Center

            )
            Text(
                "약 25분 소요 예상",
                style = AppTheme.typography.caption1M12,
                color = AppTheme.colors.textSub2,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Text(
                text = "예상 교통 상황을 바탕으로 한 예상 시간입니다. 실제 교통량에 따라 도착" +
                        "시간이 변경될 수 있습니다. 픽업 1시간 전까지 또는 기사님이 배정되기" +
                        "전까지는 취소 수수료가 부과되지 않습니다.약관보기",

                style = AppTheme.typography.caption1M12,
                color = AppTheme.colors.textSub2,
                modifier = Modifier
                    .padding(top = 198.dp, start = 10.dp, end =10.dp),
            )

            Button(
                onClick = onNextClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .width(328.dp)
                    .padding(start=16.dp, end=16.dp, top=6.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppTheme.colors.btnActive,
                    contentColor = AppTheme.colors.btnInactive
                )
            ) {
                Text("다음")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun TimeScreenPreview() {
    MaterialTheme {
        TimeScreen(
            onNextClick = {}
        )
    }
}
