package Commands

import Utils.Tank

class Show: Command {
    override fun execute(tank: Tank, args: List<String>) {
        val collection = tank.data.collection
        if (collection.isEmpty()) tank.writer.println("Collection is empty :(")
        else tank.writer.println("Collection:")
        for (element in collection) {
            println(element.toString())
        }
    }
}
