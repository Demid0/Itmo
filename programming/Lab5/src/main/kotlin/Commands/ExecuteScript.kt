package Commands

import Utils.Tank
import java.io.File
import java.io.InputStreamReader

class ExecuteScript: Command {
    override fun execute(tank: Tank, args: List<String>) {
        try {
            val file_name = args[1]
            val file = File(file_name)
            val reader = InputStreamReader(file.inputStream())
            val file_text = reader.readLines()
            for (string in file_text) {
                val input = string.split(" ").toMutableList()
                input.removeAll(setOf("", { input.size }))
                tank.invoker.invoke(tank, input)
            }
        } catch (e: Exception) {
            println("No such file.")
        }
    }
}
