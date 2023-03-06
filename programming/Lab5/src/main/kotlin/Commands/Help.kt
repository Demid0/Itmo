package Commands

import Asker
import Data

class Help: Command {
    override fun execute(data: Data, asker: Asker, args: List<String>) {
        val commands = data.getCommands()
        println("You can use this commands:")
        for (command in commands) {
            println(command.key)
        }
    }
}
