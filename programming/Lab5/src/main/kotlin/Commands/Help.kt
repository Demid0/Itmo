package Commands

import Utils.Tank

class Help: Command {
    override fun execute(tank: Tank, args: List<String>) {
        val commands = tank.invoker.getCommands()
        println("You can use this commands:")
        for (command in commands) {
            println(command.key)
        }
    }
}
