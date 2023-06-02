package clientCommands

import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Visibility

/***
 * print_field_descending_distance : вывести значения поля distance всех элементов в порядке убывания
 * @author Demid0
 * @since 1.0
 */
class PrintFieldDescendingDistance: ClientCommand(CommandType.NO_ARG, Visibility.LOGGED_USER) {
    override fun execute(arguments: ArrayList<CommandArgument>, user_id: Long): ArrayList<Packet> {
        val collection = collectionManager.collection.sortedByDescending { it.getDistance() }
        return printToClientPacket(
            if (collection.isEmpty()) "Collection is empty."
            else {
                var out = "Collection:\n"
                collection.forEach { out += "${it.getDistance()} " }
                out
            }
        )
    }
}
