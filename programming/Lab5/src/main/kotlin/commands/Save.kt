package commands

import commands.utils.Command
import commands.utils.CommandType
import java.io.File
import java.io.PrintWriter
/***
 * save : сохранить коллекцию в файл
 * @author Demid0
 * @since 1.0
 */
class Save: Command(CommandType.NO_ARG) {
    override fun execute(args: Any?): String {
        return try {
            val collection = data.collection
            val file = File(data.getFileName())
            val fileWriter = PrintWriter(file.outputStream(), true)
            fileWriter.println(serializator.serialize(collection))
            "Done!"
        } catch (e: Exception) {
            "Something went wrong"
        }
    }

}
