package commands.utils

import collectionObjectsClasses.Coordinates
import collectionObjectsClasses.Location
import collectionObjectsClasses.Route
import commands.*

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

    fun parse(args: MutableList<String>): CommandPacket {
        return if (args.isEmpty()) CommandPacket(null, null, null)
        else {
            val commandName = args[0]
            val commandType = commands[commandName]
            if (commandType == null) CommandPacket(null, null, null)
            else {
                when(commandType) {
                    CommandType.NO_ARG -> CommandPacket(commandName, null, null)
                    CommandType.SINGLE_ARG -> CommandPacket(commandName, args[1], null)
                    CommandType.OBJECT_ARG -> CommandPacket(commandName, null, Route("", Coordinates(null, null), null, Location(1, 1f, 1, ""), 4.0))
                    CommandType.MIXED_ARG -> CommandPacket(commandName, args[1], Route("", Coordinates(null, null), null, Location(1, 1f, 1, ""), 4.0))
                }
            }
        }
    }
}