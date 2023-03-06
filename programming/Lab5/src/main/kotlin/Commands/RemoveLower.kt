package Commands

import Asker
import Data

class RemoveLower: Command {
    override fun execute(data: Data, asker: Asker, args: List<String>) {
        val route = asker.askRoute()
        for (element in data.collection) {
            if (element.getDistance() < route.getDistance()) {
                data.collection.remove(element)
            }
        }
    }
}
