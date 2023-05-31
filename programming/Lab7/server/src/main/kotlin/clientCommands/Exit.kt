package clientCommands

import builders.packet
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Visibility

/***
 * exit : завершить программу (без сохранения в файл)
 * @author Demid0
 * @since 1.0
 */
class Exit: ClientCommand(CommandType.NO_ARG, Visibility.ALL_USERS) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        return packet {
            commandName = "end_client_session"
        }.wrapIntoArray()
    }
}