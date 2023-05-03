import utils.AnswerPacket

class SystemCommandInvoker {
    val commands = HashMap<String, SystemCommand>()
    fun invoke(answerPacket: AnswerPacket) {
        val command = commands[answerPacket.commandName]!!
        command.execute(answerPacket.singleArg, answerPacket.commandType)
    }
}
