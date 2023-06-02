package clientCommands

import builders.packet
import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Visibility
import commandArgumentsAndTheirsComponents.VisibilityArgument
import utils.ClientAssistant
import utils.Packet

class SignUp: ClientCommand(CommandType.TWO_STRINGS_ARG, Visibility.UNLOGGED_USER) {
    override fun execute(arguments: ArrayList<CommandArgument>, user_id: Long): ArrayList<Packet> {
        val pair: Pair<String, String> = cast(arguments)
        val clientName = pair.first
        val password = pair.second
        val new_user_id = dbHandler.setUser(clientName, password)
        if (new_user_id == (-1).toLong()) return printToClientPacket("User $clientName already exists")
        val token = tokenizer.md5(clientName + password)
        clients[token] = ClientAssistant(new_user_id)
        tokens[new_user_id] = token
        val ans = packet {
            commandName = "set_user"
            visibility(Visibility.LOGGED_USER)
            string(token)
        }.wrapIntoArray()
        ans.addAll(Checkout().execute(arrayListOf(VisibilityArgument(Visibility.LOGGED_USER)), new_user_id))
        return ans
    }
}