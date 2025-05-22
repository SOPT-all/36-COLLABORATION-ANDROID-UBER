package com.sopt.at.uber.feature.service.time.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.sopt.at.uber.R
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.typography
import com.sopt.at.uber.feature.service.ServiceSharedViewModel
import com.sopt.at.uber.feature.service.information.component.TopBar
import java.time.*
import java.time.format.TextStyle
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeScreen(
    sharedViewModel: ServiceSharedViewModel = hiltViewModel(),
    navigateToInformation: () -> Unit,
    navigateUp: () -> Unit
) {
    val context = LocalContext.current
    SideEffect {
        Locale.setDefault(Locale.KOREA)
        context.resources.configuration.setLocale(Locale.KOREA)
    }

    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    var selectedTime by remember { mutableStateOf(LocalTime.now().withSecond(0).withNano(0)) }
    var showTimePicker by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }

    val timePickerState = rememberTimePickerState(selectedTime.hour, selectedTime.minute, false)
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long) =
                utcTimeMillis >= LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
        }
    )

    fun LocalTime.toUiTime(): Triple<String, String, String> {
        val meridiem = if (hour < 12) "오전" else "오후"
        val hour12 = (if (hour % 12 == 0) 12 else hour % 12).toString().padStart(2, '0')
        val minute = minute.toString().padStart(2, '0')
        return Triple(meridiem, hour12, minute)
    }

    val (pickupMeridiem, pickupHour12, pickupMinute) = selectedTime.toUiTime()
    val (arrivalMeridiem, arrivalHour12, arrivalMinute) = selectedTime.plusMinutes(25).toUiTime()
    val dayOfWeekKorean = selectedDate.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREA)

    Surface(modifier = Modifier.fillMaxSize(), color = colors.bgWhite) {
        if (showDatePicker) {
            Dialog(onDismissRequest = { showDatePicker = false }, properties = DialogProperties(usePlatformDefaultWidth = false)) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = colors.bgWhite,
                    modifier = Modifier.width(500.dp).padding(5.dp)
                ) {
                    Column(modifier = Modifier.padding(5.dp).fillMaxWidth()) {
                        DatePicker(
                            state = datePickerState,
                            colors = DatePickerDefaults.colors(
                                containerColor = colors.bgWhite,
                                weekdayContentColor = colors.textSub1,
                                dayContentColor = colors.bgBlack,
                                disabledDayContentColor = colors.textSub3,
                                selectedDayContainerColor = colors.bgBlack,
                                selectedDayContentColor = colors.bgWhite,
                                todayContentColor = colors.textSub3,
                                todayDateBorderColor = colors.textSub3,
                                dividerColor = colors.bgBlack,
                                selectedYearContainerColor = colors.bgBlack,
                                selectedYearContentColor = colors.bgWhite,
                                yearContentColor = colors.textSub1
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(Modifier.height(16.dp))
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                            TextButton(onClick = { showDatePicker = false }) {
                                Text("취소", color = colors.textPrimary)
                            }
                            Spacer(Modifier.width(8.dp))
                            TextButton(onClick = {
                                datePickerState.selectedDateMillis?.let {
                                    selectedDate = Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDate()
                                    sharedViewModel.updatePickupDate(selectedDate)
                                }
                                showDatePicker = false
                            }) {
                                Text("확인", color = colors.textPrimary)
                            }
                        }
                    }
                }
            }
        }

        if (showTimePicker) {
            AlertDialog(
                onDismissRequest = { showTimePicker = false },
                confirmButton = {
                    TextButton(onClick = {
                        selectedTime = LocalTime.of(timePickerState.hour, timePickerState.minute)
                        sharedViewModel.updatePickupTime(selectedTime)
                        showTimePicker = false
                    }) {
                        Text("확인", color = colors.textPrimary)
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showTimePicker = false }) {
                        Text("취소", color = colors.textPrimary)
                    }
                },
                title = { Text("시간 선택", color = colors.textPrimary) },
                text = {
                    TimePicker(
                        state = timePickerState,
                        colors = TimePickerDefaults.colors(
                            containerColor = colors.bgWhite,
                            clockDialColor = colors.bgGray,
                            selectorColor = colors.bgBlack,
                            periodSelectorBorderColor = colors.textSub3,
                            clockDialSelectedContentColor = colors.bgWhite,
                            clockDialUnselectedContentColor = colors.textSub1,
                            periodSelectorSelectedContainerColor = colors.bgBlack,
                            periodSelectorUnselectedContainerColor = colors.bgGray,
                            periodSelectorSelectedContentColor = colors.bgWhite,
                            periodSelectorUnselectedContentColor = colors.textSub1,
                            timeSelectorSelectedContainerColor = colors.bgBlack,
                            timeSelectorUnselectedContainerColor = colors.bgGray,
                            timeSelectorSelectedContentColor = colors.bgWhite,
                            timeSelectorUnselectedContentColor = colors.textSub1,
                        )
                    )
                },
                containerColor = colors.bgWhite
            )
        }

        Column(Modifier.fillMaxSize()) {
            TopBar(onBackClick = navigateUp, modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp), title = "")
            Text("픽업 시간", style = typography.title1Eb32, modifier = Modifier.padding(start = 14.dp, bottom = 89.dp))
            Spacer(Modifier.height(16.dp))

            Button(
                onClick = { showDatePicker = true },
                modifier = Modifier.fillMaxWidth().height(56.dp).padding(horizontal = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colors.bgWhite, contentColor = colors.textPrimary)
            ) {
                Text("${selectedDate.monthValue}월 ${selectedDate.dayOfMonth}일 ($dayOfWeekKorean)", style = typography.title4B18)
            }

            HorizontalDivider(Modifier.fillMaxWidth().padding(horizontal = 16.dp))
            Spacer(Modifier.height(12.dp))

            Button(
                onClick = { showTimePicker = true },
                modifier = Modifier.fillMaxWidth().height(56.dp).padding(horizontal = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colors.bgWhite, contentColor = colors.textPrimary)
            ) {
                Text("$pickupMeridiem $pickupHour12:$pickupMinute", style = typography.title4B18)
            }

            Spacer(Modifier.height(24.dp))

            Text("도착 시간 $arrivalMeridiem $arrivalHour12:$arrivalMinute KST", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth().padding(top = 10.dp), style = typography.body1M16, color = colors.bgBlack)
            Text("약 25분 소요 예상", style = typography.caption1M12, color = colors.textSub2, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            Text(stringResource(R.string.time_desc), style = typography.caption1M12, color = colors.textSub2, modifier = Modifier.padding(top = 198.dp, start = 16.dp, end = 16.dp))

            Button(
                onClick = navigateToInformation,
                modifier = Modifier.fillMaxWidth().height(56.dp).padding(horizontal = 16.dp, vertical = 6.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colors.btnActive, contentColor = colors.btnInactive)
            ) {
                Text("다음", style = typography.title4B18)
            }
        }
    }
}
