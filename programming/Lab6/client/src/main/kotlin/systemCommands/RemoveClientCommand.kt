package systemCommands

import utils.CommandType

class RemoveClientCommand : SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?): Boolean {
        try {
            commandParser.removeCommand(singleArg!!)
            return true
        } catch (_: Exception) {
            return false
        }
    }

}
