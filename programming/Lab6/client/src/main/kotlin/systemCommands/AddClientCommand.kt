package systemCommands

import utils.CommandType

class AddClientCommand : SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?) {
        commandParser.addCommand(singleArg!!, commandType!!)
    }

}
