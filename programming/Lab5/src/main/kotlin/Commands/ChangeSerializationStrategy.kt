package Commands

import Utils.Tank

class ChangeSerializationStrategy: Command {
    override fun execute(tank: Tank, args: List<String>) {
        try {
            val newType = args[1]
            tank.serializator.changeStrategy(tank.serializator.getStrategies()[newType]!!)
        } catch (e: Exception) {
            println("Unknown serialization strategy.")
        }
    }
}