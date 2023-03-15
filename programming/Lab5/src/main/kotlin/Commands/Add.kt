package Commands

import Utils.Tank

class Add: Command {
    override fun execute(tank: Tank, args: List<String>) {
        try {
            tank.data.collection.add(tank.asker.askRoute())
        } catch (e: Exception) {
            System.err.println("Not added.")
        }
    }
}