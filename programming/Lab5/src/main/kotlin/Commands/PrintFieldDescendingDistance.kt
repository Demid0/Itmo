package Commands

import Utils.Tank

class PrintFieldDescendingDistance: Command {
    override fun execute(tank: Tank, args: List<String>) {
        val collection = tank.data.collection.sortedByDescending { it.getDistance() }
        if (collection.isEmpty()) tank.writer.println("Collection is empty.")
        else tank.writer.println("Collection:")
        for (element in collection) {
            tank.writer.print("${element.getDistance()} ")
        }
    }
}
