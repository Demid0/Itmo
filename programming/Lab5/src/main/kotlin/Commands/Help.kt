package Commands

import Invoker

class Help : Command {
    override fun execute(args: List<String>) {
        var commands = Data.getCommands()
        println("You can use this commands:")
        for (command in commands) {
            println(command.key)
        }
    }
}
