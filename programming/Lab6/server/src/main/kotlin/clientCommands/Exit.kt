package clientCommands

import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import java.io.File
import java.io.PrintWriter

/***
 * exit : завершить программу (без сохранения в файл)
 * @author Demid0
 * @since 1.0
 */
class Exit: ClientCommand(CommandType.NO_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>): Packet {
        val file = File(collectionManager.getInfoFileName())
        val fileWriter = PrintWriter(file)
        fileWriter.println(collectionManager.collection.javaClass.simpleName.lowercase())
        fileWriter.flush()
        fileWriter.println(serializator.getChosenStrategy().javaClass.simpleName.lowercase())
        fileWriter.flush()
        //exitProcess(0)
        return Packet("end_client_session", arrayListOf())
    }
}