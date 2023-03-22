package Commands

import java.io.File
import java.io.PrintWriter
/***
 *     save : сохранить коллекцию в файл
 */
class Save: Command() {
    override fun execute(args: List<String>) {
        try {
            val collection = data.collection
            val file = File(data.getFileName())
            val fileWriter = PrintWriter(file.outputStream(), true)
            fileWriter.println(serializator.serialize(collection))
            writer.println("Done!")
        } catch (e: Exception) {
            e.printStackTrace()
            System.err.println("Cannot open file")
        }
    }

}
