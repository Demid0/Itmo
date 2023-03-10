package Commands

import Utils.Tank
import java.lang.Exception

class CountDistance(val compare: (a: Double, b: Double) -> Boolean): Command {
    override fun execute(tank: Tank, args: List<String>) {
        try {
            var how_many = 0
            val distance: Double = args[1].toDouble()
            for (element in tank.data.collection) {
                if (compare(element.getDistance(), distance)) how_many++
            }
            println(how_many)
        } catch (e: Exception) {
            println("Wrong distance format")
        }
    }

}
