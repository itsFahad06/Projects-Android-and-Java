import androidx.compose.animation.*
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.ui.res.painterResource
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Task

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class Splash {

    @Preview
    @Composable
    fun splash(onNavigateClick: () -> Unit) {
        Box (
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

                LaunchedEffect(Unit) {
                    delay(2000)
                    onNavigateClick()
                }
                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn(animationSpec = tween(durationMillis = 1000, easing = LinearEasing)),
                    exit = fadeOut(animationSpec = tween(durationMillis = 1000, easing = LinearEasing)),
                ) {
                    Column (
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ){
                        Text(
                            text = "Welcome To Task Manager",
                            style = TextStyle(fontSize = 30.sp, color = Color.Black, fontWeight =
                            FontWeight.Bold, fontFamily = FontFamily(Font("fonts/roboto/Roboto-Bold.ttf")),
                            )
                        )
                        Icon(
                            imageVector = Icons.Default.Task,
                            contentDescription = "Person",
                            modifier = Modifier.size(100.dp)
                        )
                    }

                }
            }
        }
    }