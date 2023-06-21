package GUIsystemCommands

import systemCommands.SystemCommand
import utils.argToString
import views.MainScreen

val printToClient = SystemCommand("print_to_client", argToString) {
    MainScreen.outputProperty.set(it)

}