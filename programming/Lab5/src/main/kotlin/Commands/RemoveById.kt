package Commands

import Utils.Tank
import java.lang.Exception

class RemoveById: Command {
    override fun execute(tank: Tank, args: List<String>) {
        try {
            val id: Long = args[1].toLong()
            var bool = false
            for (element in tank.data.collection) {
                if (element.getId() == id) {
                    tank.data.collection.remove(element)
                    bool = true
                    break
                }
            }
            if (bool) tank.writer.println("Done!")
            else tank.writer.println("No element with this id.")
        } catch (e: Exception) {
            System.err.println("Wrong id format.")
        }
    }

}
