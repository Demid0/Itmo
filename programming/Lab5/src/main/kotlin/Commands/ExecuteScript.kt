package Commands

import Asker
import Data

class ExecuteScript: Command {
    override fun execute(data: Data, asker: Asker, args: List<String>) {
        println("Executing..")
    }

}
