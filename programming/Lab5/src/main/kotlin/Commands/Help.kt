package Commands

class Help: Command() {
    override fun execute(args: List<String>) {
        val commands = invoker.getCommands()
        if (commands.isEmpty()) writer.println("No commands")
        else writer.println("You can use this commands:")
        for (command in commands.toSortedMap()) {
            writer.println(command.key)
        }
    }
}
