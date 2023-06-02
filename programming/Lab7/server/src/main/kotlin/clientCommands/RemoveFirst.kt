package clientCommands

import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Visibility
import java.util.NoSuchElementException
/***
 * remove_first : удалить первый элемент из коллекции
 * @author Demid0
 * @since 1.0
 */
class RemoveFirst: ClientCommand(CommandType.NO_ARG, Visibility.LOGGED_USER) {
    override fun execute(arguments: ArrayList<CommandArgument>, user_id: Long): ArrayList<Packet> {
        return printToClientPacket (
            try {
                val element = collectionManager.collection.first()
                if (dbHandler.removeElement(element.getId(), user_id)) {
                    collectionManager.collection.remove(element)
                    "Done!"
                }
                else "Don't removed. Probably it isn't your Route"
            }
            catch (e: NoSuchElementException) { "Collection is empty" }
        )
    }
}
