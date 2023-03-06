package Commands

import Asker
import Data
import java.lang.Exception

class CountDistance(var compare: (a: Double, b: Double) -> Boolean): Command {
    override fun execute(data: Data, asker: Asker, args: List<String>) {
        try {
            var how_many = 0
            val distance: Double = args[1].toDouble()
            for (element in data.collection) {
                if (compare(element.getDistance(), distance)) how_many++
            }
            println(how_many)
        } catch (e: Exception) {
            println("Wrong distance format")
        }
    }

}
