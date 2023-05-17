package clientCommands

import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.MyString
import java.io.File
import java.io.PrintWriter
/***
 * save : сохранить коллекцию в файл
 * @author Demid0
 * @since 1.0
 */
class Save: ClientCommand(CommandType.NO_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>): Packet {
        return Packet("print_to_client", arrayListOf(
            MyString(try {
            val collection = collectionManager.collection
            val file = File(collectionManager.getFileName())
            val fileWriter = PrintWriter(file.outputStream(), true)
            fileWriter.println(serializator.serialize(collection))
            "Done!"
        } catch (e: Exception) {
            "Something went wrong"
        })
        ))
    }

}
