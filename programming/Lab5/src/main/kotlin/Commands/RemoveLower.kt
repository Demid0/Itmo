package Commands

import Utils.Tank

class RemoveLower: Command {
    override fun execute(tank: Tank, args: List<String>) {
        val route = tank.asker.askRoute()
        for (element in tank.data.collection) {
            if (element.getDistance() < route.getDistance()) {
                tank.data.collection.remove(element)
            }
        }
    }
}
