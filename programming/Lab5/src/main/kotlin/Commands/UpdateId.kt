package Commands

import Utils.Tank
import java.lang.Exception

class UpdateId: Command {
    override fun execute(tank: Tank, args: List<String>) {
        try {
            var bool = false
            val id: Long = args[1].toLong()
            val route = tank.asker.askRoute(tank.reader, tank.writer)
            for (element in tank.data.collection) {
                if (element.getId() == id) {
                    element.update(
                        name = route.getName(),
                        coordinates = route.getCoordinates(),
                        from = route.getFrom(),
                        to = route.getTo(),
                        distance = route.getDistance()
                    )
                    bool = true
                    break
                }
            }
            if (bool) tank.writer.println("Done!")
            else tank.writer.println("No element with this id")
        } catch (e: Exception) {
            System.err.println("Wrong id format.")
        }
    }

}
