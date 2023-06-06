package clientCommands

import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Route
import commandArgumentsAndTheirsComponents.Visibility

/***
 * remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный
 * @author Demid0
 * @since 1.0
 */
class RemoveLower: ClientCommand(CommandType.OBJECT_ARG, Visibility.LOGGED_USER) {
    override fun execute(arguments: ArrayList<CommandArgument>, user_id: Long): ArrayList<Packet> {
        val route: Route = cast(arguments)
        val temp: ArrayList<Route> = arrayListOf()
        collectionManager.collection.forEach { if (it.getDistance() < route.getDistance()) temp.add(it) }
        temp.forEach { if(dbHandler.removeElement(it.getId(), user_id)) collectionManager.collection.remove(it) }
        return printToClientPacket("Done!")
    }
}
