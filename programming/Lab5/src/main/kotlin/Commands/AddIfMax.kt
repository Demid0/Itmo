package Commands

import Asker
import Data

class AddIfMax: Command {
    override fun execute(data: Data, asker: Asker, args: List<String>) {
        val route = asker.askRoute()
        var bool = true
        for (element in data.collection) {
            if (element.getDistance() >= route.getDistance()) {
                println("I didn't add it")
                bool = false
                break
            }
        }
        if(bool) {
            data.collection.add(route)
            println("Route added")
        }
    }

}
