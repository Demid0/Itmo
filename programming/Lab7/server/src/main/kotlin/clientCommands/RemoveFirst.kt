package clientCommands

import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import java.util.NoSuchElementException
/***
 * remove_first : удалить первый элемент из коллекции
 * @author Demid0
 * @since 1.0
 */
class RemoveFirst: ClientCommand(CommandType.NO_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        return printToClientPacket (
            try {
                collectionManager.collection.remove(collectionManager.collection.first())
                "Done!"
            }
            catch (e: NoSuchElementException) { "Collection is empty" }
        )
    }
}
