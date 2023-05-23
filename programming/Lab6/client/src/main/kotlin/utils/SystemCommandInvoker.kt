package utils

import systemCommands.*

class SystemCommandInvoker {
    private val commands = HashMap<String, SystemCommand>()

    init {
        addCommand("print_to_client", PrintToClient())
        addCommand("add_client_command", AddClientCommand())
        addCommand("clear_client_commands", ClearClientCommands())
        addCommand("read_from_file", ReadFromFile())
        addCommand("end_client_session", EndClientSession())
    }

    fun invoke(listOfPacket: ArrayList<Packet>) {
        for(packet in listOfPacket) {
            val command = commands[packet.commandName]!!
            command.execute(packet.arguments)
        }
    }
    fun addCommand (commandName: String, systemCommand: SystemCommand) = commands.put(commandName, systemCommand)
    fun getCommands() = commands
}
