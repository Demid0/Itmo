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
    override fun execute(arguments: ArrayList<CommandArgument>, user_id: Long): ArrayList<Packet> {
        return printToClientPacket (
            try {
                val id: String = cast(arguments)
                if (dbHandler.removeElement(id.toLong(), user_id)) {
                    collectionManager.collection.removeIf { it.getId() == id.toLong() }
                    "Done!"
                } else "Can't find element or it is not your element"
            } catch (e: Exception) {
                "Wrong id format."
            }
        )
    }
}
