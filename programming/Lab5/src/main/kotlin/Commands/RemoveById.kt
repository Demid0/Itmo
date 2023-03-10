package Commands

import Utils.Tank
import java.lang.Exception

class RemoveById: Command {
    override fun execute(tank: Tank, args: List<String>) {
        try {
            val id: Long = args[1].toLong()
            for (element in tank.data.collection) {
                if (element.getId() == id) {
                    tank.data.collection.remove(element)
                    break
                }
            }
        } catch (e: Exception) {
            println("Wrong id format.")
        }
    }

}
