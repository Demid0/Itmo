package clientCommands

import builders.packet
import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Visibility
import commandArgumentsAndTheirsComponents.VisibilityArgument
import utils.Packet

class Checkout : ClientCommand(CommandType.VISIBILITY_ARG, Visibility.ALL_USERS) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        val currentVisibilityLevel: Visibility = cast(arguments)
        val ans = packet { commandName = "clear_client_commands" }.wrapIntoArray()
        val existingCommands = clientCommandInvoker.getCommands()
        existingCommands.filter { it.value.visibility == Visibility.ALL_USERS || it.value.visibility == currentVisibilityLevel }.forEach { command ->
            ans.add(
                packet {
                    commandName = "add_client_command"
                    argsArray {
                        string (command.key)
                        commandType(command.value.commandType)
                    }
                }
            )
        }
        return ans
    }
}
