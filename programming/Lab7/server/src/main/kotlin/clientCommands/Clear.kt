package clientCommands

import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType

/***
 * clear : очистить коллекцию
 * @author Demid0
 * @since 1.0
 */
class Clear: ClientCommand(CommandType.NO_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        collectionManager.collection.clear()
        return printToClientPacket("Done!")
    }
}
