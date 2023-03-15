package Commands

import Utils.Tank

class Help: Command {
    override fun execute(tank: Tank, args: List<String>) {
        val commands = tank.invoker.getCommands()
        if (commands.isEmpty()) tank.writer.println("No commands")
        else tank.writer.println("You can use this commands:")
        for (command in commands.toSortedMap()) {
            tank.writer.println(command.key)
        }
    }
}
