package Commands

import Utils.Tank
import java.io.File
import java.io.PrintWriter

class Save: Command {
    override fun execute(tank: Tank, args: List<String>) {
        try {
            val collection = tank.data.collection
            val file = File(tank.data.getFileName())
            val writer = PrintWriter(file)
            for (element in collection) {
                writer.println(tank.serializator.serialize(element))
                writer.flush()
            }
        } catch (e: Exception) {
            System.err.println("Cannot open file")
        }
    }

}
