package clientCommands

import builders.packet
import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Visibility
import commandArgumentsAndTheirsComponents.VisibilityArgument
import utils.ClientAssistant
import utils.Packet

class Login: ClientCommand(CommandType.TWO_STRINGS_ARG, Visibility.UNLOGGED_USER) {
    override fun execute(arguments: ArrayList<CommandArgument>, user_id: Long): ArrayList<Packet> {
        val pair: Pair<String, String> = cast(arguments)
        val clientName = pair.first
        val password = pair.second
        val ans: ArrayList<Packet>
        val connected_user_id = dbHandler.checkUser(clientName, password)
        if (connected_user_id != (-1).toLong()) {
            val token = tokenizer.md5(clientName+password)
            clients[token] = ClientAssistant(connected_user_id)
            tokens[user_id] = token
            ans = packet {
                commandName = "set_user"
                visibility(Visibility.LOGGED_USER)
                string(token)
            }.wrapIntoArray()
            ans.addAll(Checkout().execute(arrayListOf(VisibilityArgument(Visibility.LOGGED_USER)), connected_user_id))
        }
        else {
            ans = printToClientPacket("Wrong username or password")
        }
        return ans
    }
}