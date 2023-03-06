package Commands

import Asker
import Data

class Save: Command {
    override fun execute(data: Data, asker: Asker, args: List<String>) {
        println("Saving..")
    }

}
