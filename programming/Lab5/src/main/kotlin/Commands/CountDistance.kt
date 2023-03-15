package Commands

import Utils.Tank
import java.lang.Exception

class CountDistance(val compare: (a: Double, b: Double) -> Boolean): Command {
    override fun execute(tank: Tank, args: List<String>) {
        try {
            var counter = 0
            val distance: Double = args[1].toDouble()
            for (element in tank.data.collection) {
                if (compare(element.getDistance(), distance)) counter++
            }
            println("$counter element(s)")
        } catch (e: Exception) {
            System.err.println("Wrong distance format")
        }
    }

}
