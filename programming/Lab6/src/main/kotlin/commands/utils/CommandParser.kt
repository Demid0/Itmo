package commands.utils

import commands.*

class CommandParser {
    private var commands: HashMap<String, Command> = HashMap()
    init {
        addCommand("exit", Exit())
        addCommand("help", Help())
        addCommand("info", Info())
        addCommand("show", Show())
        addCommand("add", Add())
        addCommand("update", UpdateId())
        addCommand("remove_by_id", RemoveById())
        addCommand("clear", Clear())
        addCommand("save", Save())
        addCommand("execute_script", ExecuteScript())
        addCommand("remove_first", RemoveFirst())
        addCommand("add_if_max", AddIfMax())
        addCommand("remove_lower", RemoveLower())
        addCommand("count_by_distance", CountDistance { a: Double, b: Double -> a == b })
        addCommand("count_less_than_distance", CountDistance { a: Double, b: Double -> a < b })
        addCommand("print_field_descending_distance", PrintFieldDescendingDistance())
        addCommand("change_collection_type", ChangeCollectionType())
        addCommand("change_serialization_strategy", ChangeSerializationStrategy())
    }
    fun getCommands() = commands

    fun addCommand(name: String, command: Command) {
        commands.put(name, command)
    }

    fun parse(args: MutableList<String>): Pair<Command, Any?>? {
        if (args.isEmpty()) return null
        else {
            val commandName = args[0]
            val command = commands[commandName]
            return if (command == null) null
            else {
                when (command.type) {
                    CommandType.NO_ARG -> Pair(command, null)
                    CommandType.SINGLE_ARG -> {
                        args.removeFirst()
                        Pair(command, args)
                    }
                    CommandType.OBJECT_ARG -> Pair(command, 0)
                    CommandType.MIXED_ARG -> {
                        args.removeFirst()
                        Pair(command, listOf(args, 0))
                    }
                }
            }
        }
    }
}