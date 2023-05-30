package clientCommands

import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Route

/***
 * remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный
 * @author Demid0
 * @since 1.0
 */
class RemoveLower: ClientCommand(CommandType.OBJECT_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        val route: Route = cast(arguments)
        collectionManager.collection.removeAll { it.getDistance() < route.getDistance() }
        return printToClientPacket("Done!")
    }
}
