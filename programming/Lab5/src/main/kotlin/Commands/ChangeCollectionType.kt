package Commands

import Utils.Tank
import kotlin.Exception

class ChangeCollectionType: Command {

    override fun execute(tank: Tank, args: List<String>) {
        try {
            val newType = args[1]
            tank.data.changeType(newType)
        } catch (e: Exception) {
            println("Unsupported collection type")
        }
    }

}