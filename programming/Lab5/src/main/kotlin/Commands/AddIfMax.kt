package Commands

import Utils.Tank

class AddIfMax: Command {
    override fun execute(tank: Tank, args: List<String>) {
        val route = tank.asker.askRoute()
        var bool = true
        for (element in tank.data.collection) {
            if (element.getDistance() >= route.getDistance()) {
                println("I didn't add it")
                bool = false
                break
            }
        }
        if(bool) {
            tank.data.collection.add(route)
            println("Route added")
        }
    }

}
