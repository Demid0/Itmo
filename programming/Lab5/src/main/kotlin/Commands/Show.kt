package Commands

import Asker
import Data

class Show: Command {
    override fun execute(data: Data, asker: Asker, args: List<String>) {
        val collection = data.collection
        println("Collection:")
        for (element in collection) {
            println(element.toString())
        }
    }
}
