package utils

import systemCommands.*

class SystemCommandInvoker {
    private val commands = HashMap<String, SystemCommand>()

    init {
        addCommand("print_to_client", PrintToClient())
        addCommand("add_client_command", AddClientCommand())
        addCommand("remove_client_command", RemoveClientCommand())
        addCommand("read_from_file", ReadFromFile())
        addCommand("end_client_session", EndClientSession())
    }

    fun invoke(answerPacket: AnswerPacket) : Boolean {
        val command = commands[answerPacket.commandName]!!
        return command.execute(answerPacket.singleArg, answerPacket.commandType)
    }
    fun addCommand (commandName: String, systemCommand: SystemCommand) = commands.put(commandName, systemCommand)
    fun getCommands() = commands
}