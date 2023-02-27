package Commands

import Data
import java.lang.Exception

class UpdateId : Command {
    override fun execute(args: List<String>) {
        try {
            var id: Long = args[1].toLong()
            var route = Asker.askRoute()
            for (element in Data.collection) {
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
