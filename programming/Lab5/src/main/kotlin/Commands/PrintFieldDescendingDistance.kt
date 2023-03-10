package Commands

import Utils.Tank

class PrintFieldDescendingDistance: Command {
    override fun execute(tank: Tank, args: List<String>) {
        val collection = tank.data.collection.sortedByDescending { it.getDistance() }
        for (element in collection) {
            print("${element.getDistance()} ")
        }
    }
}
