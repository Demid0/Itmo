package systemCommands

import exceptions.SystemCommandInvocationException
import exceptions.UIException
import tornado.MyApp
import tornadofx.getChildList

val clearClientCommands = SystemCommand("clear_client_commands", {} ) {
    try {
        parseCommandAndAskArguments.clear()
        try {
            MyApp.currentPage.getChildList()?.clear()
        } catch (e: Exception) {
            throw UIException(e.message ?: "")
        }
    } catch (_: Exception) {
        throw SystemCommandInvocationException()
    }
}