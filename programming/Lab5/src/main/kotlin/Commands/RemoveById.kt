package Commands

import java.lang.Exception

class RemoveById: Command() {
    override fun execute(args: List<String>) {
        try {
            val id: Long = args[1].toLong()
            var bool = false
            for (element in data.collection) {
                if (element.getId() == id) {
                    data.collection.remove(element)
                    bool = true
                    break
                }
            }
            if (bool) writer.println("Done!")
            else writer.println("No element with this id.")
        } catch (e: Exception) {
            System.err.println("Wrong id format.")
        }
    }

}
