package Commands

import Utils.Tank

interface Command {
    fun execute(tank: Tank, args: List<String>)
}