package Commands

import Utils.Tank

class Clear: Command {
    override fun execute(tank: Tank, args: List<String>) {
        try {
            tank.data.collection.clear()
            tank.writer.println("Done!")
        } catch (e: Exception) {
            System.err.println("Not cleared. Хз как")
        }
    }
}
