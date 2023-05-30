package clientCommands

import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType

/***
 * print_field_descending_distance : вывести значения поля distance всех элементов в порядке убывания
 * @author Demid0
 * @since 1.0
 */
class PrintFieldDescendingDistance: ClientCommand(CommandType.NO_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        val collection = collectionManager.collection.sortedByDescending { it.getDistance() }
        return build.printToClientPacket(
            if (collection.isEmpty()) "Collection is empty."
            else {
                var out = "Collection:\n"
                collection.forEach { out += "${it.getDistance()} " }
                out
            }
        )
    }
}
