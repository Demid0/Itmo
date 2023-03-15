package Commands

import Utils.Tank

class ChangeSerializationStrategy: Command {
    override fun execute(tank: Tank, args: List<String>) {
        try {
            val newType = args[1] + "strategy"
            tank.serializator.changeStrategy(tank.serializator.getStrategy(newType)!!)
        } catch (e: Exception) {
            println("Unknown serialization strategy.")
        }
    }
}