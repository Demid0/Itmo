package Commands

import Asker
import Data
import java.lang.Exception

class UpdateId: Command {
    override fun execute(data: Data, asker: Asker, args: List<String>) {
        try {
            val id: Long = args[1].toLong()
            val route = asker.askRoute()
            for (element in data.collection) {
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
            println("Wrong id format.")
        }
    }

}
