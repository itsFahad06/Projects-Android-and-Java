import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class mainScreen {
    @Composable
    @Preview
    fun mainScreen(menuClick: () -> Unit,addTaskClick: () -> Unit,
                   deleteTaskClick: () -> Unit,updateTaskClick: () -> Unit,
                   searchTaskClick: () -> Unit,viewTaskClick: () -> Unit,
                   editTaskClick: () -> Unit) {
        Scaffold {
            Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
                IconButton(
                    onClick = { menuClick() },
                    modifier = Modifier
                        .padding(10.dp)
                        .size(50.dp)
                        .align(Alignment.TopStart),
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Person",
                        modifier = Modifier.size(100.dp)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(50.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Card(
                            modifier = Modifier
                                .padding(10.dp)
                                .size(220.dp, 220.dp)
                                .clickable{addTaskClick()},
                            backgroundColor = Color.Green,
                            elevation = 5.dp,
                            shape = RoundedCornerShape(10)
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Add a Task",
                                    style = TextStyle(
                                        textAlign = TextAlign.Center,
                                        fontSize = 15.sp,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily(Font("fonts/roboto/Roboto-Bold.ttf"))
                                    )
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                Text(
                                    text = "Add a new Task in the list to remember",
                                    style = TextStyle(
                                        textAlign = TextAlign.Center,
                                        fontSize = 15.sp,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily(Font("fonts/roboto/Roboto-Bold.ttf"))
                                    )
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                Icon(
                                    painter = painterResource("images/addatask.png"),
                                    contentDescription = "Add a Task",
                                    tint = Color.White
                                )
                            }
                        }
                        Card(
                            modifier = Modifier
                                .padding(10.dp)
                                .size(220.dp, 220.dp)
                                .clickable {deleteTaskClick()},
                            backgroundColor = Color.Red,
                            elevation = 5.dp,
                            shape = RoundedCornerShape(10)
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Delete a Task",
                                    style = TextStyle(
                                        textAlign = TextAlign.Center,
                                        fontSize = 15.sp,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily(Font("fonts/roboto/Roboto-Bold.ttf"))
                                    )
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                Text(
                                    text = "Delete a Task From the list",
                                    style = TextStyle(
                                        textAlign = TextAlign.Center,
                                        fontSize = 15.sp,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily(Font("fonts/roboto/Roboto-Bold.ttf"))
                                    )
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                Icon(
                                    painter = painterResource("images/delatask.png"),
                                    contentDescription = "Delete a Task",
                                    tint = Color.White
                                )
                            }
                        }
                        Card(
                            modifier = Modifier
                                .padding(10.dp)
                                .size(220.dp, 220.dp)
                                .clickable {updateTaskClick()},
                            backgroundColor = Color(255,165,0),
                            elevation = 5.dp,
                            shape = RoundedCornerShape(10)
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Update a Task",
                                    style = TextStyle(
                                        textAlign = TextAlign.Center,
                                        fontSize = 15.sp,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily(Font("fonts/roboto/Roboto-Bold.ttf"))
                                    )
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                Text(
                                    text = "Update a Task From the list",
                                    style = TextStyle(
                                        textAlign = TextAlign.Center,
                                        fontSize = 15.sp,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily(Font("fonts/roboto/Roboto-Bold.ttf"))
                                    )
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                Icon(
                                    painter = painterResource("images/updateatask.png"),
                                    contentDescription = "Update a Task",
                                    tint = Color.White
                                )
                            }
                        }
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Card(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .size(220.dp, 220.dp)
                                    .clickable { searchTaskClick() },
                                backgroundColor = Color.Blue,
                                elevation = 5.dp,
                                shape = RoundedCornerShape(10)
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Search a Task",
                                        style = TextStyle(
                                            textAlign = TextAlign.Center,
                                            fontSize = 15.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily(Font("fonts/roboto/Roboto-Bold.ttf"))
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(20.dp))
                                    Text(
                                        text = "Search a Task From the list",
                                        style = TextStyle(
                                            textAlign = TextAlign.Center,
                                            fontSize = 15.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily(Font("fonts/roboto/Roboto-Bold.ttf"))
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(20.dp))
                                    Icon(
                                        painter = painterResource("images/searchatask.png"),
                                        contentDescription = "Search a Task",
                                        tint = Color.White
                                    )
                                }
                            }
                            Card(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .size(220.dp, 220.dp)
                                    .clickable { viewTaskClick()  },
                                backgroundColor = Color.Gray,
                                elevation = 5.dp,
                                shape = RoundedCornerShape(10)
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "View a Task",
                                        style = TextStyle(
                                            textAlign = TextAlign.Center,
                                            fontSize = 15.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily(Font("fonts/roboto/Roboto-Bold.ttf"))
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(20.dp))
                                    Text(
                                        text = "View a Task From the list",
                                        style = TextStyle(
                                            textAlign = TextAlign.Center,
                                            fontSize = 15.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily(Font("fonts/roboto/Roboto-Bold.ttf"))
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(20.dp))
                                    Icon(
                                        painter = painterResource("images/viewatask.png"),
                                        contentDescription = "View a Task",
                                        tint = Color.White
                                    )
                                }
                            }
                            Card(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .size(220.dp, 220.dp)
                                    .clickable { editTaskClick() },
                                backgroundColor =Color.Yellow,
                                elevation = 5.dp,
                                shape = RoundedCornerShape(10)
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Edit a Task",
                                        style = TextStyle(
                                            textAlign = TextAlign.Center,
                                            fontSize = 15.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily(Font("fonts/roboto/Roboto-Bold.ttf"))
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(20.dp))
                                    Text(
                                        text = "Edit a Task From the list",
                                        style = TextStyle(
                                            textAlign = TextAlign.Center,
                                            fontSize = 15.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily(Font("fonts/roboto/Roboto-Bold.ttf"))
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(20.dp))
                                    Icon(
                                        painter = painterResource("images/editatask.png"),
                                        contentDescription = "edit a Task",
                                        tint = Color.White
                                    )
                                }
                            }
                        }
                    }
                }


            }
        }
    }
}