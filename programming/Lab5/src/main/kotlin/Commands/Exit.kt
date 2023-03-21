package Commands

import java.io.File
import java.io.PrintWriter
import kotlin.system.exitProcess

class Exit: Command() {
    override fun execute(args: List<String>) {
        val file = File(data.getInfoFileName())
        val writer = PrintWriter(file)
        writer.println(data.collection.javaClass.simpleName.lowercase())
        writer.flush()
        writer.println(serializator.getChosenStrategy().javaClass.simpleName.lowercase())
        writer.flush()
        writer.println("Bye!")
        exitProcess(0)
    }
}