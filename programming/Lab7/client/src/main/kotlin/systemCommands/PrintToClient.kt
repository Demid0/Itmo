package systemCommands

import exceptions.SystemCommandInvocationException
import commandArgumentsAndTheirsComponents.CommandArgument
import commandArgumentsAndTheirsComponents.CommandType

class PrintToClient : SystemCommand(CommandType.SINGLE_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>) {
        try {
            val singleArg = caster.toString(arguments[0])
            val writer = writerManager.get()
            writer.println(singleArg)
            writer.flush()
        } catch (_: Exception) {
            throw SystemCommandInvocationException()
        }
    }

}
