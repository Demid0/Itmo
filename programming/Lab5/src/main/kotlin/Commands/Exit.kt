package Commands

import kotlin.system.exitProcess

class Exit : Command {
    override fun execute(args: List<String>) {
        println("Bye!")
        exitProcess(0)
    }
}