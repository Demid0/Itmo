package clientCommands

import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Visibility

/***
 * show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
 * @author Demid0
 * @since 1.0
 */
class Show: ClientCommand(CommandType.NO_ARG, Visibility.LOGGED_USER) {
    override fun execute(arguments: ArrayList<CommandArgument>, user_id: Long): ArrayList<Packet> {
        val collection = collectionManager.collection
        return printToClientPacket (
            if (collection.isEmpty()) "Collection is empty :("
            else {
                var out = "Collection:\n"
                collection.sortedBy { it.getName() }.forEach { out += it.toString() + "\n" }
                out.dropLast(1)
            }
        )
    }
}
