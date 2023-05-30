package systemCommands

import exceptions.SystemCommandInvocationException
import commandArgumentsAndTheirsComponents.CommandArgument
import commandArgumentsAndTheirsComponents.CommandType

class ClearClientCommands : SystemCommand(CommandType.NO_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>) {
        try {
            commandParser.clear()
        } catch (_: Exception) {
            throw SystemCommandInvocationException()
        }
    }

}
