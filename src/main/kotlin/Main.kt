import EditTask
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

enum class Screen {
    SPLASH,
    LOGIN,
    REGISTER,
    MainScreen,
    AddTask,
    DeleteTask,
    UpdateTask,
    ViewTask,
    SearchTask,
    EditTask
}

@Composable
fun App() {
    var currentScreen by remember { mutableStateOf(Screen.MainScreen) }

    val s = Splash()
    val l = Login()
    val r = Register()
    val m = mainScreen()
    val a = TaskAdd()
    val d = DeleteTask()
    val u = UpdateTask()
    val v = ViewTask()
    val se = TaskSearch()
    val e = EditTask()

    when(currentScreen) {
        Screen.LOGIN -> l.lg(onNavigateClick = { currentScreen = Screen.REGISTER}, onNavigateClick1 = { currentScreen = Screen.MainScreen })
        Screen.REGISTER -> r.Reg( onNavigateClick = { currentScreen = Screen.LOGIN })
        Screen.SPLASH -> s.splash(onNavigateClick = { currentScreen = Screen.LOGIN })
        Screen.MainScreen -> m.mainScreen(menuClick = { currentScreen = Screen.LOGIN }, addTaskClick = { currentScreen = Screen.AddTask }, deleteTaskClick = { currentScreen = Screen.DeleteTask }, updateTaskClick = { currentScreen = Screen.UpdateTask }, viewTaskClick = { currentScreen = Screen.ViewTask }, searchTaskClick = { currentScreen = Screen.SearchTask }, editTaskClick = { currentScreen = Screen.EditTask })
        Screen.AddTask -> a.addTask(backBtn = {currentScreen = Screen.MainScreen},onNavigateClick = { currentScreen = Screen.MainScreen })
        Screen.DeleteTask -> d.deleteTask(onNavigateClick = { currentScreen = Screen.MainScreen } , backBtn = {currentScreen = Screen.MainScreen})
        Screen.UpdateTask -> u.updateTask(onNavigateClick = { currentScreen = Screen.MainScreen })
        Screen.ViewTask -> v.viewTask(onNavigateClick = { currentScreen = Screen.MainScreen })
        Screen.SearchTask -> se.searchTask(onNavigateClick = { currentScreen = Screen.MainScreen })
        Screen.EditTask -> e.editTask(onNavigateClick = { currentScreen = Screen.MainScreen })
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication,
        resizable = false,
        title = "Task Manager",
        icon = painterResource("images/taskmanager.png")
    ){
        App()
    }
}
