package Commands

import Utils.Tank

class Show: Command {
    override fun execute(tank: Tank, args: List<String>) {
        val collection = tank.data.collection
        if (collection.isEmpty()) println("Collection is empty :(")
        else println("Collection:")
        for (element in collection) {
            println(element.toString())
        }
    }
}
