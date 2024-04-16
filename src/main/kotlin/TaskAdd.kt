import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class TaskAdd {


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun addTask(backBtn : () -> Unit, onNavigateClick : () -> Unit) {

        val priorityList = listOf("High", "Medium", "Low")

        val tName = remember { mutableStateOf(TextFieldValue()) }
        val tDes = remember { mutableStateOf(TextFieldValue()) }
        val tPr = remember { mutableStateOf(priorityList[0]) }

        val datePickerState = rememberDatePickerState()
        var showDatePickerState by remember { mutableStateOf(false) }

        val timePickerState = rememberTimePickerState()
        var showTimePickerState by remember { mutableStateOf(false) }


        val data = Data()


        Box (modifier = Modifier.fillMaxSize()){
            IconButton(
                onClick = {
                    backBtn()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back Button",
                    modifier = Modifier.size(40.dp)
                )
            }

            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Add A New Task",
                    style = TextStyle(
                        fontSize = 30.sp, color = Color.Black, fontWeight =
                        FontWeight.Bold, fontFamily = FontFamily(Font("fonts/roboto/Roboto-Bold.ttf")),
                    )
                )

                OutlinedTextField(
                    modifier = Modifier.padding(10.dp),
                    value = tName.value,
                    onValueChange = {
                        tName.value = it
                    },
                    label = { Text("Enter Task Name") },
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(123,125,156),
                        unfocusedBorderColor = Color.Gray,
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Task,
                            contentDescription = "Task name"
                        )
                    },
                )

                OutlinedTextField(
                    modifier = Modifier.padding(10.dp),
                    value = tDes.value,
                    onValueChange = {
                        tDes.value = it
                    },
                    label = { Text("Enter Task Description") },
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(123,125,156),
                        unfocusedBorderColor = Color.Gray,
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Description,
                            contentDescription = "Description"
                        )
                    },
                    minLines = 2,
                    maxLines = 10,

                )

                Button(
                    onClick = {
                        showDatePickerState = true
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,

                    )

                ) {
                    Text(text = "Pick a Date For Task",
                        color = Color.White)
                }


                Button(
                    onClick = {
                       showTimePickerState = true
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Cyan,
                        )
                ) {
                    Text(text = "Pick a Time For Task",
                        color = Color.White)
                }

                if (showDatePickerState) {
                    DatePickerDialog(
                        onDismissRequest = { /*TODO*/ },
                        confirmButton = {
                            Button(
                                onClick = {
                                    val selectedDate = datePickerState.selectedDateMillis?.let { it1 -> LocalDate.ofEpochDay(it1 / (24*60*60*1000)) }
                                    if (selectedDate != null && selectedDate.isBefore(LocalDate.now())) {

                                    } else {
                                        showDatePickerState = false
                                    }
                                },
                            ) { Text("OK") }
                        },
                        dismissButton = {
                            Button(
                                onClick = {
                                    showDatePickerState = false
                                }
                            ) { Text("Cancel") }
                        }
                    )
                    {
                        DatePicker(state = datePickerState)
                    }
                }

                if (showTimePickerState) {
                    TimePickerDialog(
                        onDismissRequest = { /*TODO*/ },
                        confirmButton = {
                            Button(
                                modifier = Modifier.absolutePadding(left = 12.dp),
                                onClick = {
                                    showTimePickerState = false
                                }
                            ) { Text("OK") }
                        },
                        dismissButton = {
                            Button(

                                onClick = {
                                    showTimePickerState = false
                                }
                            ) { Text("Cancel") }
                        }
                    )
                    {
                        TimePicker(state = timePickerState)
                    }
                }

                Text(
                    text = "Task Priority",
                    style = TextStyle(
                        fontSize = 20.sp, color = Color.Black, fontWeight =
                        FontWeight.Bold, fontFamily = FontFamily(Font("fonts/roboto/Roboto-Bold.ttf")),
                    )
                )
                Row (
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    priorityList.forEach {
                        RadioButton(
                            selected = tPr.value == it,
                            onClick = { tPr.value = it },
                            enabled = true,
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Green,
                                unselectedColor = Color.Red,
                            ),
                            modifier = Modifier.padding(10.dp),
                        )
                        Text(text = it)
                    }
                }
                Button(
                    onClick = {
                        val taskDate = datePickerState.selectedDateMillis?.convertMillisToDate()
                        val taskTime = timePickerState.hour * 3600000L + timePickerState.minute * 60000L
                        val formattedTime = taskTime.convertMillisToTime()

                        data.taskName.add(tName.value.text)
                        data.taskDesc.add(tDes.value.text)
                        if (taskDate != null) {
                            data.taskDate.add(taskDate)
                        }

                           data.taskTime.add(formattedTime)
                        data.taskPriority.add(tPr.value)

                        data.taskData()
                        onNavigateClick()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(152, 3, 252),
                    )
                ) {
                    Text(text = "Add Task",
                        color = Color.White)
                }
            }
        }
    }
}

@Composable
fun TimePickerDialog(
    title: String = "Select Time",
    onDismissRequest: () -> Unit,
    confirmButton: @Composable (() -> Unit),
    dismissButton: @Composable (() -> Unit)? = null,
    containerColor: Color = MaterialTheme.colors.surface,
    content: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
    ) {
        Surface(
            shape = MaterialTheme.shapes.large,
            tonalElevation = 6.dp,
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min)
                .background(
                    shape = MaterialTheme.shapes.large,
                    color = containerColor
                ),
            color = containerColor
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    text = title,
                    style = MaterialTheme.typography.h5
                )
                content()
                Row(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    dismissButton?.invoke()
                    confirmButton()
                }
            }
        }
    }
}


fun Long.convertMillisToDate(): String {
    val calendar = Calendar.getInstance().apply {
        timeInMillis = this@convertMillisToDate
    }
    val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.US)
    return sdf.format(calendar.time)
}

fun Long.convertMillisToTime(): String {
    val calendar = Calendar.getInstance().apply {
        timeInMillis = this@convertMillisToTime - 5 * 60 * 60 * 1000 // Adjust for 5-hour difference
    }
    val hour = calendar.get(Calendar.HOUR)
    val minute = calendar.get(Calendar.MINUTE)
    val amPm = if (calendar.get(Calendar.AM_PM) == Calendar.AM) "AM" else "PM"
    return String.format("%02d:%02d %s", hour, minute, amPm)
}
