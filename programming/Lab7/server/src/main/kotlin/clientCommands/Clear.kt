package clientCommands

import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Visibility

/***
 * clear : очистить коллекцию
 * @author Demid0
 * @since 1.0
 */
class Clear: ClientCommand(CommandType.NO_ARG, Visibility.LOGGED_USER) {
    override fun execute(arguments: ArrayList<CommandArgument>, user_id: Long): ArrayList<Packet> {
        collectionManager.collection.clear()
        return printToClientPacket("Done!")
    }
}
