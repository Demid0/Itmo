package systemCommands

import utils.CommandType
import kotlin.system.exitProcess

class EndClientSession: SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?): Boolean {
        exitProcess(0)
    }
}