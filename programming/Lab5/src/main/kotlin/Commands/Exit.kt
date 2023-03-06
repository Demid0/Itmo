package Commands

import Asker
import Data
import kotlin.system.exitProcess

class Exit: Command {
    override fun execute(data: Data, asker: Asker, args: List<String>) {
        println("Bye!")
        exitProcess(0)
    }
}