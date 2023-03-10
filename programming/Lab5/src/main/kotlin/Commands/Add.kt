package Commands

import Utils.Tank

class Add: Command {
    override fun execute(tank: Tank, args: List<String>) {
        tank.data.collection.add(tank.asker.askRoute())
    }
}