package clientCommands

import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType

/***
 * show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
 * @author Demid0
 * @since 1.0
 */
class Show: ClientCommand(CommandType.NO_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        val collection = collectionManager.collection
        return build.printToClientPacket (
            if (collection.isEmpty()) "Collection is empty :("
            else {
                var out = "Collection:\n"
                collection.sortedBy { it.getName() }.forEach { out += it.toString() + "\n" }
                out.dropLast(1)
            }
        )
    }
}
