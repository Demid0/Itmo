package Commands

import Utils.Tank

class AddIfMax: Command {
    override fun execute(tank: Tank, args: List<String>) {
        try {
            val route = tank.asker.askRoute(tank.reader, tank.writer)
            var bool = true
            for (element in tank.data.collection) {
                if (element.getDistance() >= route.getDistance()) {
                    tank.writer.println("I didn't add it")
                    bool = false
                    break
                }
            }
            if (bool) {
                tank.data.collection.add(route)
                tank.writer.println("Done!")
            }
        } catch (e: Exception) {
            System.err.println("Something went wrong.")
        }
    }

}
