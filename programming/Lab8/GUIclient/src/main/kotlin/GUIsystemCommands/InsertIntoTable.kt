package GUIsystemCommands

import exceptions.SystemCommandInvocationException
import systemCommands.SystemCommand
import utils.argToRoute
import views.MainScreen

val insertIntoTable = SystemCommand("insert_into_table", argToRoute) {
    route ->
    try {
        MainScreen.collection.add(route)
    } catch (_: Exception) {
        throw SystemCommandInvocationException()
    }
}