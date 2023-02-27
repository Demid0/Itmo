package Commands

import Data
import java.lang.Exception

class RemoveById : Command {
    override fun execute(args: List<String>) {
        try {
            var id: Long = args[1].toLong()
            for (element in Data.collection) {
                if (element.getId() == id) {
                    Data.collection.remove(element)
                    break
                }
            }
        } catch (e: Exception) {
            println("Wrong id format.")
        }
    }

}
