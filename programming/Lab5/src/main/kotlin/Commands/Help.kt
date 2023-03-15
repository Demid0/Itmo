package Commands

import Utils.Tank

class Help: Command {
    override fun execute(tank: Tank, args: List<String>) {
        val commands = tank.invoker.getCommands()
        if (commands.isEmpty()) println("No commands")
        else println("You can use this commands:")
        for (command in commands.toSortedMap()) {
            println(command.key)
        }
    }
}
