package Commands

import Asker
import Data

class PrintFieldDescendingDistance: Command {
    override fun execute(data: Data, asker: Asker, args: List<String>) {
        val collection = data.collection.sortedByDescending { it.getDistance() }
        for (element in collection) {
            print("${element.getDistance()} ")
        }
    }
}
