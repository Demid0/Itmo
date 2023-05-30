package clientCommands

import builders.*
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Route

/***
 * add {element} : добавить новый элемент в коллекцию
 * @author Demid0
 * @since 1.0
 */
class Add: ClientCommand(CommandType.OBJECT_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        val objectArg: Route = cast(arguments)
        collectionManager.collection.add(objectArg)
        return printToClientPacket("Done")
    }
}