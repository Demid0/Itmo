package systemCommands

import exceptions.SystemCommandInvocationException
import utils.argToCommand

val addClientCommand = SystemCommand("add_client_command", argToCommand) {
        (singleArg, commandType) ->
    try {
        commandParser.addCommand(singleArg, commandType)
    } catch (_: Exception) {
        throw SystemCommandInvocationException()
    }
}
