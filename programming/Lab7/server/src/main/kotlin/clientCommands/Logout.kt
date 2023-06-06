package clientCommands

import builders.packet
import commandArgumentsAndTheirsComponents.CommandArgument
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Visibility
import commandArgumentsAndTheirsComponents.VisibilityArgument
import utils.Packet

class Logout: ClientCommand(CommandType.NO_ARG, Visibility.LOGGED_USER) {
    override fun execute(arguments: ArrayList<CommandArgument>, user_id: Long): ArrayList<Packet> {
        clients.remove(tokens[user_id])
        val ans = packet {
            commandName = "set_user"
            visibility(Visibility.UNLOGGED_USER)
            string("unlogged_user")
        }.wrapIntoArray()
        ans.addAll(Checkout().execute(arrayListOf(VisibilityArgument(Visibility.UNLOGGED_USER)), user_id))
        return ans
    }

}