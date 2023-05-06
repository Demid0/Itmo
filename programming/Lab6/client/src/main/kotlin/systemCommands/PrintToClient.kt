package systemCommands

import utils.CommandType

class PrintToClient : SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?): Boolean {
        return try {
            val writer = writerManager.get()
            writer.println(singleArg)
            writer.flush()
            true
        } catch (_: Exception) {
            false
        }
    }

}
