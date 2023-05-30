package clientCommands

import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import java.lang.Exception
/***
 * remove_by_id id : удалить элемент из коллекции по его id
 * @author Demid0
 * @since 1.0
 */
class RemoveById: ClientCommand(CommandType.SINGLE_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        return build.printToClientPacket (
            try {
                val id: Long = caster.toString(arguments[0]).toLong()
                collectionManager.collection.removeIf { it.getId() == id }
                "Done!"
            } catch (e: Exception) {
                "Wrong id format."
            }
        )
    }
}
