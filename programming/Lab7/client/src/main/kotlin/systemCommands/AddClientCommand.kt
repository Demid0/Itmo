package systemCommands

import exceptions.SystemCommandInvocationException
import commandArgumentsAndTheirsComponents.CommandArgument
import commandArgumentsAndTheirsComponents.CommandType

class AddClientCommand : SystemCommand(CommandType.COMMAND_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>) {
        try {
            val singleArg = caster.toString(arguments[0])
            val commandType = caster.toCommandType(arguments[1])
            commandParser.addCommand(singleArg, commandType)
        } catch (_: Exception) {
            throw SystemCommandInvocationException()
        }
    }

}
