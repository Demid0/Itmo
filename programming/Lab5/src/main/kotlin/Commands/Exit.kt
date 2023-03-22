package Commands

import java.io.File
import java.io.PrintWriter
import kotlin.system.exitProcess

/***
 *     exit : завершить программу (без сохранения в файл)
 */
class Exit: Command() {
    override fun execute(args: List<String>) {
        val file = File(data.getInfoFileName())
        val fileWriter = PrintWriter(file)
        fileWriter.println(data.collection.javaClass.simpleName.lowercase())
        fileWriter.flush()
        fileWriter.println(serializator.getChosenStrategy().javaClass.simpleName.lowercase())
        fileWriter.flush()
        writer.println("Bye!")
        exitProcess(0)
    }
}