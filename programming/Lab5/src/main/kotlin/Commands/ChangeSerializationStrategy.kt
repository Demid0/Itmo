package Commands

import Utils.Tank

class ChangeSerializationStrategy: Command {
    override fun execute(tank: Tank, args: List<String>) {
        try {
            val newType = args[1] + "strategy"
            tank.serializator.changeStrategy(tank.serializator.getStrategy(newType)!!)
            tank.writer.println("Changed!")
        } catch (e: NullPointerException) {
            System.err.println("Unknown serialization strategy.")
        } catch (e: IndexOutOfBoundsException) {
            System.err.println("Empty input.")
        }
    }
}