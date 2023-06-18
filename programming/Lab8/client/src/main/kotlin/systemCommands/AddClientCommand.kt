package systemCommands

import exceptions.SystemCommandInvocationException
import exceptions.UIException
import tornado.MyApp
import tornado.commandButton
import tornadofx.getChildList
import utils.argToCommand

val addClientCommand = SystemCommand("add_client_command", argToCommand) {
        (singleArg, commandType) ->
    try {
        parseCommandAndAskArguments.addCommand(singleArg, commandType)
        //UI module
        try {
            MyApp.currentPage.getChildList()?.add(
                commandButton {
                    this.commandName = singleArg
                    setType(commandType)
                }
            )

        } catch (e: Exception) {
            throw UIException(e.message ?: "")
        }
    } catch (e: Exception) {
        throw SystemCommandInvocationException("${e::class} : ${e.message}")
    }
}


