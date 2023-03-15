package Commands

import Utils.Tank
import java.io.File
import java.io.PrintWriter
import kotlin.system.exitProcess

class Exit: Command {
    override fun execute(tank: Tank, args: List<String>) {
        val file = File(tank.data.getInfoFileName())
        val writer = PrintWriter(file)
        writer.println(tank.data.collection.javaClass.simpleName.lowercase())
        writer.flush()
        writer.println(tank.serializator.getChosenStrategy().javaClass.simpleName.lowercase())
        writer.flush()
        tank.writer.println("Bye!")
        exitProcess(0)
    }
}