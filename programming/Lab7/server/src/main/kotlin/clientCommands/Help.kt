package clientCommands

import builders.printToClientPacket
import utils.*
import commandArgumentsAndTheirsComponents.CommandArgument
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Visibility

/***
 * help : вывести справку по доступным командам
 * @author Demid0
 * @since 1.0
 */
class Help: ClientCommand(CommandType.NO_ARG, Visibility.ALL_USERS) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        val commands = ClientCommandInvoker().getCommands()
        return printToClientPacket(
            if (commands.isEmpty()) "No commands"
            else {
                var out = "You can use this commands:\n"
                commands.toSortedMap().forEach { out += it.key + "\n" }
                out.dropLast(1)
            }
        )
    }
}
