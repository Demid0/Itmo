package clientCommands

import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Route
import commandArgumentsAndTheirsComponents.Visibility
import java.lang.Exception
/***
 * update id {element} : обновить значение элемента коллекции, id которого равен заданному
 * @author Demid0
 * @since 1.0
 */
class UpdateId: ClientCommand(CommandType.MIXED_ARG, Visibility.ONLY_LOGGED_USER) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        val pair: Pair<String, Route> = cast(arguments)
        val id: Long = pair.first.toLong()
        val route: Route = pair.second
        return printToClientPacket (
            try {
                collectionManager.collection.first { it.getId() == id }.update(
                    name = route.getName(),
                    coordinates = route.getCoordinates(),
                    from = route.getFrom(),
                    to = route.getTo(),
                    distance = route.getDistance()
                )
                "Done"
            } catch (e: Exception) {
                "Wrong id format."
            }
        )
    }

}
