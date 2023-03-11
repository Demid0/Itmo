package Commands

import Serialization.Serializator
import Utils.Tank
import java.io.File
import java.io.PrintWriter

class Save: Command {
    override fun execute(tank: Tank, args: List<String>) {
        val collection = tank.data.collection
        val file = File(System.getenv(tank.data.getFileName()))
        val writer = PrintWriter(file)
        val serializator = Serializator()
        for (element in collection) {
            writer.println(serializator.serialize(element))
            writer.flush()
        }
        println("Done!")
    }

}
