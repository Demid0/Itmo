package systemCommands

import utils.CommandType

class RemoveClientCommand : SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?) {
        commandParser.removeCommand(singleArg!!)
    }

}
