package clientCommands.utils

import builders.packet
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.Asker
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import utils.Condition

class CommandParser: KoinComponent {
    private val asker: Asker by inject()
    private var commands: HashMap<String, CommandType> = HashMap()
    private val condition: Condition by inject()

    init {
        addCommand("help", CommandType.NO_ARG)
        addCommand("checkout", CommandType.NO_ARG)
        addCommand("exit", CommandType.NO_ARG)
        addCommand("login", CommandType.TWO_STRINGS_ARG)
        addCommand("sign_up", CommandType.TWO_STRINGS_ARG)
    }
    fun getCommands() = commands

    fun addCommand(name: String, command: CommandType) {
        commands.put(name, command)
    }
    fun clear() {
        commands.clear()
    }

    fun parse(args: MutableList<String>): Packet {
        return if (args.isEmpty()) Packet()
        else {
            val commandName = args[0]
            val commandType = commands[commandName]
            if (commandType == null) Packet()
            else {
                when(commandType) {
                    CommandType.NO_ARG -> checkAndSet(args, 1, commandName)
                    CommandType.SINGLE_ARG -> checkAndSet(args, 2, commandName, args[1])
                    CommandType.OBJECT_ARG -> checkAndSet(args, 1, commandName, withRoute = true)
                    CommandType.MIXED_ARG -> checkAndSet(args, 2, commandName, args[1], true)
                    CommandType.VISIBILITY_ARG -> packet {
                        this.commandName = commandName
                        visibility(condition.get())
                    }
                    CommandType.TWO_STRINGS_ARG -> packet {
                        this.commandName = commandName
                        string(asker.askLogin())
                        string(asker.askPassword())
                    }
                    else -> Packet()
                }
            }
        }
    }
    private fun checkAndSet(args: MutableList<String>, size: Int, commandName: String, withString: String? = null, withRoute: Boolean = false): Packet {
        return if (args.size != size) Packet()
        else packet {
            this.commandName = commandName
            if (withString != null) string(withString)
            if (withRoute) route(asker.askRoute())
        }
    }
}