package systemCommands

import exceptions.SystemCommandInvocationException

val clearClientCommands = SystemCommand("clear_client_commands", {} ) {
    try {
        commandParser.clear()
    } catch (_: Exception) {
        throw SystemCommandInvocationException()
    }
}