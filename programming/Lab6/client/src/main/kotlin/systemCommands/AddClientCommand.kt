package systemCommands

import exceptions.SystemCommandInvocationException
import utils.CommandType

class AddClientCommand : SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?) {
        try {
            commandParser.addCommand(singleArg!!, commandType!!)
        } catch (_: Exception) {
            throw SystemCommandInvocationException()
        }
    }

}
