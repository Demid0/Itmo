package Commands

import Utils.Tank
import java.util.NoSuchElementException

class RemoveFirst: Command {
    override fun execute(tank: Tank, args: List<String>) {
        try { tank.data.collection.remove(tank.data.collection.first()) }
        catch (e: NoSuchElementException) { println("Collection is empty") }
        catch (e: Exception) { println("Something went wrong") }
    }
}
