package Commands

import Asker
import Data

class Info: Command {
    override fun execute(data: Data, asker: Asker, args: List<String>) {
        println("Information about collection:")
        println("Type: ${data.collection.javaClass.simpleName}")
        println("Size: ${data.collection.size}")
    }
}
