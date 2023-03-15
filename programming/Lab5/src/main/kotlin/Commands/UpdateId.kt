package Commands

import Utils.Tank
import java.lang.Exception

class UpdateId: Command {
    override fun execute(tank: Tank, args: List<String>) {
        try {
            val id: Long = args[1].toLong()
            val route = tank.asker.askRoute()
            for (element in tank.data.collection) {
                if (element.getId() == id) {
                    element.update(
                        name = route.getName(),
                        coordinates = route.getCoordinates(),
                        from = route.getFrom(),
                        to = route.getTo(),
                        distance = route.getDistance()
                    )
                    break
                }
            }
        } catch (e: Exception) {
            System.err.println("Wrong id format.")
        }
    }

}
