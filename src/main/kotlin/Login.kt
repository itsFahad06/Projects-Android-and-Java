import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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

class Login {

    @Preview
    @Composable
    fun lg(onNavigateClick: () -> Unit, onNavigateClick1: () -> Unit) {
        val emailText = remember { mutableStateOf(TextFieldValue()) }
        val passwordText = remember { mutableStateOf(TextFieldValue()) }
        val data = Data()

        var isValidEmail by remember { mutableStateOf(false) }

        val emailRegex = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$")

        Box(modifier = Modifier.background(Color.White).fillMaxSize())
        {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Login Into Your Account",
                    style = TextStyle(
                        fontSize = 30.sp, color = Color.Black,
                        fontWeight =
                        FontWeight.Bold,
                        fontFamily = FontFamily(Font("fonts/roboto/Roboto-Bold.ttf")),
                    )
                )
                OutlinedTextField(
                    modifier = Modifier.padding(10.dp),
                    value = emailText.value,
                    onValueChange = { emailText.value = it
                        isValidEmail = emailRegex.matches(it.text)},
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
                    onValueChange = { passwordText.value = it },
                    label = { Text("Enter Your Password") },
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Password,
                            contentDescription = "password"
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Blue,
                        unfocusedBorderColor = Color.Magenta,

                        ),
                    visualTransformation = PasswordVisualTransformation()
                )
                Button(
                    onClick = {
                        isValidEmail = emailRegex.matches(emailText.value.text)

                        if (isValidEmail) {
                            data.readData(emailText.value.text, passwordText.value.text, onNavigateClick1)

                        }
                    },
                    modifier = Modifier.padding(10.dp),
                    shape = RoundedCornerShape(20),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Green,

                        ), elevation = ButtonDefaults.elevation(
                        defaultElevation = 10.dp,
                        pressedElevation = 10.dp
                    )
                ) {
                    Text(
                        "Login", style = TextStyle(
                            fontSize = 20.sp, color = Color.White, fontFamily = FontFamily(
                                Font("fonts/roboto/Roboto-Regular.ttf")
                            )
                        ),
                        textAlign = TextAlign.Center
                    )
                }
                IconButton(
                    onClick = {
                              onNavigateClick()
                    },
                    modifier = Modifier.padding(10.dp),
                    content = {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .background(Color.Red, RoundedCornerShape(24.dp))
                                .padding(8.dp),
                            contentAlignment = Alignment.Center,
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
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
