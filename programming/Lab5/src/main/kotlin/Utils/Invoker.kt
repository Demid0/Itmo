package Utils

import Commands.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class Invoker: KoinComponent {
    private var commands: HashMap<String, Command> = HashMap()
    init {
        addCommand("exit", Exit()) // done
        addCommand("help", Help()) // done
        addCommand("info", Info()) // done
        addCommand("show", Show()) // done
        addCommand("add", Add()) // optimize validator
        addCommand("update", UpdateId()) // done
        addCommand("remove_by_id", RemoveById()) // done
        addCommand("clear", Clear()) // done
        addCommand("save", Save()) // done
        addCommand("execute_script", ExecuteScript()) // change with writer and printer, StackOverflowError, executes path
        addCommand("remove_first", RemoveFirst()) // done
        addCommand("add_if_max", AddIfMax()) // done
        addCommand("remove_lower", RemoveLower()) // done
        addCommand("count_by_distance", CountDistance { a: Double, b: Double -> a == b }) // done
        addCommand("count_less_than_distance", CountDistance { a: Double, b: Double -> a < b }) // done
        addCommand("print_field_descending_distance", PrintFieldDescendingDistance()) // done
        addCommand("change_collection_type", ChangeCollectionType()) // done
        addCommand("change_serialization_strategy", ChangeSerializationStrategy()) // done
    }
    fun invoke(args: List<String>) {
        val printWriterManager: PrintWriterManager by inject()
        val writer = printWriterManager.get()
        if (args.isEmpty()) writer.println("Error! Empty input.")
        else {
            val commandName = args[0]
            val command = commands[commandName]
            if (command == null) writer.println("Error! Command not found.")
            else command.execute(args)
        }
    }
    fun getCommands() = commands

    fun addCommand(name: String, command: Command) {
        commands.put(name, command)
    }
}