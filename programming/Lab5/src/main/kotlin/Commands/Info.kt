package Commands

import Utils.Tank

class Info: Command {
    override fun execute(tank: Tank, args: List<String>) {
        println("Information about collection:")
        println("Type: ${tank.data.collection.javaClass.simpleName}")
        println("Size: ${tank.data.collection.size}")
    }
}
