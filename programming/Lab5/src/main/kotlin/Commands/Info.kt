package Commands

import Utils.Tank

class Info: Command {
    override fun execute(tank: Tank, args: List<String>) {
        println("Information about collection:" +
                "\n\tType: ${tank.data.collection.javaClass.simpleName}" +
                "\n\tSize: ${tank.data.collection.size}" +
                "\nInfo about system:" +
                "\n\tSerialization strategy: ${tank.serializator.getChosenStrategy().toString()}")
    }
}
