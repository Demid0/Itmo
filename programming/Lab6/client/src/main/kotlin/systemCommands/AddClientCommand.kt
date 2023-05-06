package systemCommands

import utils.CommandType

class AddClientCommand : SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?): Boolean {
        return try {
            commandParser.addCommand(singleArg!!, commandType!!)
            true
        } catch (_: Exception) {
            false
        }
    }

}
