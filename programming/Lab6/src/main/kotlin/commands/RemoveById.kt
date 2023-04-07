package commands

import commands.utils.Command
import commands.utils.CommandType
import java.lang.Exception
/***
 * remove_by_id id : удалить элемент из коллекции по его id
 * @author Demid0
 * @since 1.0
 */
class RemoveById: Command(CommandType.SINGLE_ARG) {
    override fun execute(args: Any?): String {
        return try {
            val id: Long = ((args as List<*>)[0] as String).toLong()
            var bool = false
            for (element in data.collection) {
                if (element.getId() == id) {
                    data.collection.remove(element)
                    bool = true
                    break
                }
            }
            if (bool) "Done!"
            else "No element with this id."
        } catch (e: Exception) {
            "Wrong id format."
        }
    }

}
