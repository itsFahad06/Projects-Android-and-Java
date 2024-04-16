import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Register {
    @Composable
    fun Reg( onNavigateClick: () -> Unit) {

        val data = Data()
        val nameText = remember { mutableStateOf(TextFieldValue()) }
        val emailText = remember { mutableStateOf(TextFieldValue()) }
        val passwordText = remember { mutableStateOf(TextFieldValue()) }


        var isValidName by remember { mutableStateOf(false) }
        var isValidEmail by remember { mutableStateOf(false) }
        var isValidPassword by remember { mutableStateOf(false) }

        val emailRegex = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$")

        Box(modifier = Modifier.background(Color.White).fillMaxSize()) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Register Yourself",
                    style = TextStyle(
                        fontSize = 30.sp, color = Color.Black, fontWeight =
                        FontWeight.Bold, fontFamily = FontFamily(Font("fonts/roboto/Roboto-Bold.ttf")),
                    )
                )

                OutlinedTextField(
                    modifier = Modifier.padding(10.dp),
                    value = nameText.value,
                    onValueChange = {
                        nameText.value = it
                        isValidName = it.text.isNotEmpty()
                    },
                    label = { Text("Enter Your Name") },
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Blue,
                        unfocusedBorderColor = Color.Magenta,
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Person"
                        )
                    },
                    isError = !isValidName,
                )
                if (!isValidName) {
                    Text(
                        "Name is required", color = Color.Red,
                        style = TextStyle(
                            fontSize = 12.sp, fontFamily = FontFamily(Font("fonts/roboto/Roboto-Light.ttf"))
                        )
                    )
                }

                OutlinedTextField(
                    modifier = Modifier.padding(10.dp),
                    value = emailText.value,
                    onValueChange = {
                        emailText.value = it
                        isValidEmail = emailRegex.matches(it.text)
                    },
                    label = { Text("Enter Your Email") },
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Email"
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Blue,
                        unfocusedBorderColor = Color.Magenta,
                    ),
                    isError = !isValidEmail
                )

                if (!isValidEmail) {
                    Text(
                        "Invalid email format", color = Color.Red,
                        style = TextStyle(
                            fontSize = 12.sp, fontFamily = FontFamily(Font("fonts/roboto/Roboto-Light.ttf"))
                        )
                    )
                }

                OutlinedTextField(
                    modifier = Modifier.padding(10.dp),
                    value = passwordText.value,
                    onValueChange = {
                        passwordText.value = it
                        isValidPassword = it.text.isNotEmpty() && it.text.length >= 8
                    },
                    label = { Text("Enter Your Password") },
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Password,
                            contentDescription = "Password"
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Blue,
                        unfocusedBorderColor = Color.Magenta,
                    ),
                    isError = !isValidPassword,
                    visualTransformation = PasswordVisualTransformation()
                )

                if (!isValidPassword) {
                    Text(
                        "Password is required and must be at least 8 characters long", color = Color.Red,
                        style = TextStyle(
                            fontSize = 12.sp, fontFamily = FontFamily(Font("fonts/roboto/Roboto-Light.ttf"))
                        )
                    )
                }


                Button(
                    onClick = {
                        isValidName = nameText.value.text.isNotEmpty()
                        isValidEmail = emailRegex.matches(emailText.value.text)
                        isValidPassword = passwordText.value.text.isNotEmpty() && passwordText.value.text.length >= 8

                        if (isValidName && isValidEmail && isValidPassword) {

                            data.names.add(nameText.value.text)
                            data.email.add(emailText.value.text)
                            data.password.add(passwordText.value.text)
                            data.isRegister = true
                            data.userData()
                            onNavigateClick()
                        }

                    },
                    modifier = Modifier.padding(10.dp),
                    shape = RoundedCornerShape(20),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Red,
                    ),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 10.dp,
                        pressedElevation = 10.dp
                    )
                ) {
                    Text(
                        "Register",
                        style = TextStyle(fontSize = 20.sp, color = Color.White, fontFamily = FontFamily(Font("fonts/roboto/Roboto-Regular.ttf"))),
                        textAlign = TextAlign.Center
                    )
                }


                IconButton(
                    onClick = { onNavigateClick() },
                    modifier = Modifier.padding(10.dp),
                    content = {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .background(Color.Yellow, RoundedCornerShape(24.dp))
                                .padding(8.dp),
                            contentAlignment = Alignment.Center,
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.Black
                            )
                        }
                    }
                )
            }
        }
    }
}