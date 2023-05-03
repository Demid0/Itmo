package clientCommands.utils

import collectionObjectsClasses.Coordinates
import collectionObjectsClasses.Location
import collectionObjectsClasses.Route
import utils.ArgumentPacket
import utils.CommandType

class CommandParser {
    private var commands: HashMap<String, CommandType> = HashMap()
    fun getCommands() = commands

    fun addCommand(name: String, command: CommandType) {
        commands.put(name, command)
    }
    fun removeCommand(name: String) {
        commands.remove(name)
    }

    fun parse(args: MutableList<String>): ArgumentPacket {
        return if (args.isEmpty()) ArgumentPacket()
        else {
            val commandName = args[0]
            val commandType = commands[commandName]
            if (commandType == null) ArgumentPacket()
            else {
                when(commandType) {
                    CommandType.NO_ARG -> {
                        if (args.size != 1) ArgumentPacket()
                        else ArgumentPacket(commandName, null, null, null)
                    }
                    CommandType.SINGLE_ARG -> {
                        if (args.size != 2) ArgumentPacket()
                        else ArgumentPacket(commandName, args[1], null, null)
                    }
                    CommandType.OBJECT_ARG -> {
                        if (args.size != 1) ArgumentPacket()
                        else ArgumentPacket(commandName, null, Route("", Coordinates(null, null), null, Location(1, 1f, 1, ""), 4.0), null)
                    }
                    CommandType.MIXED_ARG -> {
                        if (args.size != 2) ArgumentPacket()
                        else ArgumentPacket(commandName, args[1], Route("", Coordinates(null, null), null, Location(1, 1f, 1, ""), 4.0), null)
                    }
                }
            }
        }
    }
}