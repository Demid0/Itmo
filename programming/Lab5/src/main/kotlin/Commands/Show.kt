package Commands

import Utils.Tank

class Show: Command {
    override fun execute(tank: Tank, args: List<String>) {
        val collection = tank.data.collection
        println("Collection:")
        for (element in collection) {
            println(element.toString())
        }
    }
}
