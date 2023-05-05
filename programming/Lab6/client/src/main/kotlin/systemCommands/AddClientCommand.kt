package systemCommands

import utils.CommandType

class AddClientCommand : SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?): Boolean {
        try {
            commandParser.addCommand(singleArg!!, commandType!!)
            return true
        } catch (_: Exception) {
            return false
        }
    }

}
