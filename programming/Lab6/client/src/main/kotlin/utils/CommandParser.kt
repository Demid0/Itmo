package clientCommands.utils

import collectionObjectsClasses.Coordinates
import collectionObjectsClasses.Location
import collectionObjectsClasses.Route
import utils.ArgumentPacket
import utils.CommandType

class CommandParser {
    private var commands: HashMap<String, CommandType> = HashMap()

    init {
        addCommand("exit", CommandType.NO_ARG)
        addCommand("help", CommandType.NO_ARG)
        addCommand("info", CommandType.NO_ARG)
        addCommand("show", CommandType.NO_ARG)
        addCommand("add", CommandType.OBJECT_ARG)
        addCommand("update", CommandType.MIXED_ARG)
        addCommand("remove_by_id", CommandType.SINGLE_ARG)
        addCommand("clear", CommandType.NO_ARG)
        addCommand("save", CommandType.NO_ARG)
        addCommand("execute_script", CommandType.SINGLE_ARG)
        addCommand("remove_first", CommandType.NO_ARG)
        addCommand("add_if_max", CommandType.OBJECT_ARG)
        addCommand("remove_lower", CommandType.OBJECT_ARG)
        addCommand("count_by_distance", CommandType.SINGLE_ARG)
        addCommand("count_less_than_distance", CommandType.SINGLE_ARG)
        addCommand("print_field_descending_distance", CommandType.NO_ARG)
        addCommand("change_collection_type", CommandType.SINGLE_ARG)
        addCommand("change_serialization_strategy", CommandType.SINGLE_ARG)
    }
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