class Invoker {
    private var commands = data.getCommands()
    fun invoke(data: Data, asker: Asker, args: List<String>) {
        if (args.isEmpty()) println("Error! Empty input.")
        else {
            val commandName = args[0]
            val command = commands[commandName]
            if (command == null) println("Error! Commands.Command not found.")
            else command.execute(data, asker, args)
        }
    }
}