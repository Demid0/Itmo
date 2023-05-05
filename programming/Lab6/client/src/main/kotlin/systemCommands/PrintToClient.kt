package systemCommands

import utils.CommandType

class PrintToClient : SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?): Boolean {
        try {
            commandOutputWriterManager.get().println(singleArg)
            commandOutputWriterManager.get().flush()
            return true
        } catch (_: Exception) {
            return false
        }
    }

}
