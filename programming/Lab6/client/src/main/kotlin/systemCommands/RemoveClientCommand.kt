package systemCommands

import utils.CommandType

class RemoveClientCommand : SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?): Boolean {
        return try {
            commandParser.removeCommand(singleArg!!)
            true
        } catch (_: Exception) {
            false
        }
    }

}
