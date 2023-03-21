package Commands

import java.io.File
import java.io.PrintWriter

class Save: Command() {
    override fun execute(args: List<String>) {
        try {
            val collection = data.collection
            val file = File(data.getFileName())
            val writer = PrintWriter(file)
            writer.println(serializator.serialize(collection))
            writer.flush()
            writer.println("Done!")
        } catch (e: Exception) {
            System.err.println("Cannot open file")
        }
    }

}
