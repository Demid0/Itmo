package systemCommands

import utils.CommandType

class PrintToClient : SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?) {
        writer.println(singleArg)
        writer.flush()
    }

}
