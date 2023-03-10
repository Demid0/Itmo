package Utils

import Commands.Command

class Invoker {
    private var commands: HashMap<String, Command> = HashMap()
    fun invoke(tank: Tank, args: List<String>) {
        if (args.isEmpty()) println("Error! Empty input.")
        else {
            val commandName = args[0]
            val command = commands[commandName]
            if (command == null) println("Error! Command not found.")
            else command.execute(tank, args)
        }
    }
    fun getCommands(): HashMap<String, Command> {
        return commands
    }
    fun addCommand(name: String, command: Command) {
        commands.put(name, command)
    }
}