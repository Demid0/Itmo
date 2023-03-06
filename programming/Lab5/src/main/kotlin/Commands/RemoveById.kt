package Commands

import Asker
import Data
import java.lang.Exception

class RemoveById: Command {
    override fun execute(data: Data, asker: Asker, args: List<String>) {
        try {
            val id: Long = args[1].toLong()
            for (element in data.collection) {
                if (element.getId() == id) {
                    data.collection.remove(element)
                    break
                }
            }
        } catch (e: Exception) {
            println("Wrong id format.")
        }
    }

}
