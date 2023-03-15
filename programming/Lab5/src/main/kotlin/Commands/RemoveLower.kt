package Commands

import Utils.Tank

class RemoveLower: Command {
    override fun execute(tank: Tank, args: List<String>) {
        try {
            val route = tank.asker.askRoute()
            for (element in tank.data.collection) {
                if (element.getDistance() < route.getDistance()) {
                    tank.data.collection.remove(element)
                }
            }
        } catch (e: Exception) {
            System.err.println("Something went wrong.")
        }
    }
}
