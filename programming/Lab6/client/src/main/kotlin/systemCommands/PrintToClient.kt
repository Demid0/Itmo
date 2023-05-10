package systemCommands

import exceptions.SystemCommandInvocationException
import utils.CommandType

class PrintToClient : SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?) {
        try {
            val writer = writerManager.get()
            writer.println(singleArg)
            writer.flush()
        } catch (_: Exception) {
            throw SystemCommandInvocationException()
        }
    }

}
