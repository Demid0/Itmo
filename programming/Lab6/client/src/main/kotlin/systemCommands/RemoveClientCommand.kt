package systemCommands

import exceptions.SystemCommandInvocationException
import commandArgumentsAndTheirsComponents.CommandArgument

class RemoveClientCommand : SystemCommand() {
    override fun execute(arguments: ArrayList<CommandArgument>) {
        try {
            val singleArg = caster.toString(arguments[0])
            commandParser.removeCommand(singleArg)
        } catch (_: Exception) {
            throw SystemCommandInvocationException()
        }
    }

}
