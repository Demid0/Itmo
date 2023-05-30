package clientCommands

import builders.packet
import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import commandArgumentsAndTheirsComponents.CommandType
import utils.Packet

class Checkout : ClientCommand(CommandType.NO_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        val ans = packet { commandName = "clear_client_commands" }.wrapIntoArray()
        val existingCommands = clientCommandInvoker.getCommands()
        existingCommands.forEach { command ->
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
        ans.addAll(printToClientPacket("Done!"))
        return ans
    }
}
