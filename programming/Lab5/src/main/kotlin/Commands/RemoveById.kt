package Commands

import java.lang.Exception
/***
 * remove_by_id id : удалить элемент из коллекции по его id
 * @author Demid0
 * @since 1.0
 */
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
