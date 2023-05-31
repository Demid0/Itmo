package clientCommands

import builders.packet
import commandArgumentsAndTheirsComponents.CommandArgument
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Visibility
import commandArgumentsAndTheirsComponents.VisibilityArgument
import utils.ClientAssistant
import utils.Packet

class Login: ClientCommand(CommandType.TWO_STRINGS_ARG, Visibility.UNLOGGED_USER) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        val pair: Pair<String, String> = cast(arguments)
        val clientName = pair.first
        val password = pair.second
        clients[clientName] = ClientAssistant(clientName, password)
        /* will add check in db */
        val ans = packet {
            this.clientName = clientName
            this.password = password
            commandName = "set_user"
            visibility(Visibility.LOGGED_USER)
        }.wrapIntoArray()
        ans.addAll(Checkout().execute(arrayListOf(VisibilityArgument(Visibility.LOGGED_USER))))
        return ans
    }
}