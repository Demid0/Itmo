package clientCommands

import builders.*
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Route
import commandArgumentsAndTheirsComponents.Visibility

/***
 * add {element} : добавить новый элемент в коллекцию
 * @author Demid0
 * @since 1.0
 */
class Add: ClientCommand(CommandType.OBJECT_ARG, Visibility.LOGGED_USER) {
    override fun execute(arguments: ArrayList<CommandArgument>, user_id: Long): ArrayList<Packet> {
        val objectArg: Route = cast(arguments)
        val route_id = dbHandler.addElement(objectArg, user_id)
        return if (route_id > -1) {
            objectArg.setId(route_id)
            collectionManager.collection.add(objectArg)
            printToClientPacket("Done")
        } else {
            printToClientPacket("Something went wrong")
        }
    }
}