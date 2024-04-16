
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class DeleteTask {

    @Composable
    fun deleteTask(onNavigateClick : () -> Unit, backBtn : () -> Unit)
    {
        Box (modifier = Modifier.fillMaxSize()) {
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

            MySearchBar(
                modifier = Modifier
                    .padding(top = 50.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                text = "",
                onTextChange = {},
                placeHolder = "Search Task",
                onCloseClicked = {},
                onMicClicked = {},
            )
        }
    }
}

@Composable
fun MySearchBar(
    modifier : Modifier = Modifier,
    text : String,
    onTextChange : (String) -> Unit,
    placeHolder : String,
    onCloseClicked : () -> Unit,
    onMicClicked : () -> Unit,
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .border(
                border = BorderStroke(
                    0.1.dp,
                    SolidColor(MaterialTheme.colors.onSurface)
                ),
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            placeholder = {
                Text(
                    text = placeHolder,
                    style = TextStyle(
                        color = MaterialTheme.colors.onBackground,
                        fontSize = MaterialTheme.typography.subtitle1.fontSize,
                        fontWeight = FontWeight.Normal,

                        )
                )
            },
            leadingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = Color(255, 0, 0),
                        modifier = modifier.size(22.dp)
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    if (text.isNotBlank()) {
                        onCloseClicked()
                    } else {
                        onMicClicked()
                    }
                }) {
                    if (text.isNotBlank()) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = null,
                            tint = Color(255, 0, 0),
                            modifier = modifier.size(22.dp)
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Mic,
                            contentDescription = null,
                            tint = Color(255, 0, 0),
                            modifier = modifier.size(22.dp)
                        )
                    }
                }
            }, colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = MaterialTheme.colors.surface,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = MaterialTheme.colors.onBackground
            )
        )
        SearchBarDivider(
            modifier = modifier
                .align(Alignment.CenterEnd)
                .padding(horizontal = 50.dp)
        )
    }
}
@Composable
fun SearchBarDivider(
    modifier: Modifier = Modifier
){
    Divider(
        modifier = modifier
            .width(1.dp)
        ,
        color = MaterialTheme.colors.onSurface,
        thickness = 20.dp
    )
}
