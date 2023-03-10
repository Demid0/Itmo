package Commands

import Utils.Tank

class Clear: Command {
    override fun execute(tank: Tank, args: List<String>) {
        tank.data.collection.clear()
    }
}
