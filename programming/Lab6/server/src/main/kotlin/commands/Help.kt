package commands

import ClientCommandInvoker
import collectionObjectsClasses.Route
import utils.AnswerPacket
import utils.CommandType

/***
 * help : вывести справку по доступным командам
 * @author Demid0
 * @since 1.0
 */
class Help: Command(CommandType.NO_ARG) {
    override fun execute(singleArg: String?, objectArg: Route?): AnswerPacket {
        val commands = ClientCommandInvoker().getCommands()
        return AnswerPacket(if (commands.isEmpty()) "No commands"
        else {
            var out = "You can use this commands:\n"
            for (command in commands.toSortedMap()) {
                out += command.key + "\n"
            }
            out.dropLast(1)
        })
    }
}
