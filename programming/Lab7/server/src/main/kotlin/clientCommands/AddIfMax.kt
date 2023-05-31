package clientCommands

import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Route
import commandArgumentsAndTheirsComponents.Visibility

/***
 * add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
 * @author Demid0
 * @since 1.0
 */
class AddIfMax: ClientCommand(CommandType.OBJECT_ARG, Visibility.LOGGED_USER) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        val route: Route = cast(arguments)
        for (element in collectionManager.collection) {
            if (element.getDistance() >= route.getDistance()) {
                return printToClientPacket("I didn't add it")
            }
        }
        collectionManager.collection.add(route)
        return printToClientPacket("Done!")
    }

}
