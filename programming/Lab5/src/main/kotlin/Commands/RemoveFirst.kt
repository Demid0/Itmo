package Commands

import Utils.Tank
import java.util.NoSuchElementException

class RemoveFirst: Command {
    override fun execute(tank: Tank, args: List<String>) {
        try {
            tank.data.collection.remove(tank.data.collection.first())
            tank.writer.println("Done!")
        }
        catch (e: NoSuchElementException) { System.err.println("Collection is empty") }
        catch (e: Exception) { System.err.println("Something went wrong") }
    }
}
