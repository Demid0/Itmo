package clientCommands

import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Visibility
import java.lang.Exception
/***
 * remove_by_id id : удалить элемент из коллекции по его id
 * @author Demid0
 * @since 1.0
 */
class RemoveById: ClientCommand(CommandType.SINGLE_ARG, Visibility.LOGGED_USER) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        return printToClientPacket (
            try {
                val id: String = cast(arguments)
                collectionManager.collection.removeIf { it.getId() == id.toLong() }
                "Done!"
            } catch (e: Exception) {
                "Wrong id format."
            }
        )
    }
}
