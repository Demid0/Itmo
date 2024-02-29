package systemCommands

import exceptions.SystemCommandInvocationException
import utils.argToRoute

val insertIntoTable = SystemCommand("insert_into_table", argToRoute) {
    route ->
    try {
        val writer = writerManager.get()
        writer.print(route.toString())
        writer.flush()
    } catch (_: Exception) {
        throw SystemCommandInvocationException()
    }
}