package systemCommands

import kotlin.system.exitProcess

val endClientSession = SystemCommand("end_client_session", {} ) {
    exitProcess(0)
}