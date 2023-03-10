package Commands

import Utils.Tank
import kotlin.system.exitProcess

class Exit: Command {
    override fun execute(tank: Tank, args: List<String>) {
        println("Bye!")
        exitProcess(0)
    }
}