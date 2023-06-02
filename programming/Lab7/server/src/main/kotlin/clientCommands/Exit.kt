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
    override fun execute(arguments: ArrayList<CommandArgument>, user_id: Long): ArrayList<Packet> {
        val token = tokens[user_id]
        if (token != null) {// means authorized user
            clients.remove(token)
            tokens.remove(user_id)
        }
        return packet {
            commandName = "end_client_session"
        }.wrapIntoArray()
    }
}