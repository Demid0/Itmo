package systemCommands

import commandArgumentsAndTheirsComponents.CommandArgument
import commandArgumentsAndTheirsComponents.CommandType
import kotlin.system.exitProcess

class EndClientSession: SystemCommand(CommandType.NO_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>) {
        exitProcess(0)
    }
}