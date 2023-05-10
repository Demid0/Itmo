package systemCommands

import exceptions.SystemCommandInvocationException
import utils.CommandType

class RemoveClientCommand : SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?) {
        try {
            commandParser.removeCommand(singleArg!!)
        } catch (_: Exception) {
            throw SystemCommandInvocationException()
        }
    }

}
