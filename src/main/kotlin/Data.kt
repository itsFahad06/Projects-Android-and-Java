import androidx.compose.runtime.*
import java.io.File


class Data {

    val names: MutableList<String> = mutableListOf()
    val email: MutableList<String> = mutableListOf()
    val password: MutableList<String> = mutableListOf()
    var isRegister: Boolean = false
    private val isCreated : Boolean = true

    val taskName : MutableList<String> = mutableListOf()
    val taskDesc : MutableList<String> = mutableListOf()
    val taskDate : MutableList<String> = mutableListOf()
    val taskTime : MutableList<String> = mutableListOf()
    val taskPriority : MutableList<String> = mutableListOf()


    fun userData() {
        val fileName = "userRegData.txt"

        if (!isCreated)
        {
            File(fileName).createNewFile()
        }
        else{

            val file = File(fileName)
            file.appendText("Name: ${names.joinToString(", ")}\n")
            file.appendText("Email: ${email.joinToString(", ")}\n")
            file.appendText("Password: ${password.joinToString(", ")}\n")
            file.appendText("IsRegistered: $isRegister\n")
        }

    }

    fun readData(email: String, password: String,  onNavigateClick1: () -> Unit ): Boolean {
        val fileName = "userRegData.txt"
        val file = File(fileName)

        if (!file.exists()) {
            return false
        }

        var foundUser = false

        file.forEachLine { line ->
            val fields = line.split(":")
            if (fields.size == 2) {
                val key = fields[0].trim()
                val value = fields[1].trim()

                if (key == "Email") {
                    if (email == value) {
                        foundUser = true
                    }
                } else if (key == "Password") {
                    if (foundUser && password == value) {
                        onNavigateClick1()
                    }
                }
            }
        }

        return foundUser
    }

    fun taskData()
    {
        val fileName = "taskData.txt"

        if (!isCreated)
        {
            File(fileName).createNewFile()
        }
        else{

            val file = File(fileName)
            file.appendText("Task Name: ${taskName.joinToString(", ")}\n")
            file.appendText("Task Description: ${taskDesc.joinToString(", ")}\n")
            file.appendText("Task Date: ${taskDate.joinToString(", ")}\n")
            file.appendText("Task Time: ${taskTime.joinToString(", ")}\n")
            file.appendText("Task Priority: ${taskPriority.joinToString(", ")}\n")
        }
    }

}
