package commands

import commands.utils.Command
import commands.utils.CommandType

/***
 * help : вывести справку по доступным командам
 * @author Demid0
 * @since 1.0
 */
class Help: Command(CommandType.NO_ARG) {
    override fun execute(args: Any?): String {
        val commands = commandParser.getCommands()
        if (commands.isEmpty()) return "No commands\n"
        else {
            var out = "You can use this commands:\n"
            for (command in commands.toSortedMap()) {
                out += command.key + "\n"
            }
            return out
        }
    }
}
