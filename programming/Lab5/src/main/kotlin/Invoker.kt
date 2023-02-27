class Invoker {
    companion object {
        private var commands = Data.getCommands()
        fun invoke(args: List<String>) {
            if (args.isEmpty()) println("Error! Empty input.")
            else {
                val commandName = args[0]
                val command = commands[commandName]
                if (command == null) println("Error! Commands.Command not found.")
                else command.execute(args)
            }
        }
    }
}