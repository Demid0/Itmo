package utils

import builders.PacketBuilder
import builders.packet
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Route

class parseCommandAndAskArguments: KoinComponent {
    private val asker: Asker by inject()
    private var commands: HashMap<String, CommandType> = HashMap()
    private val condition: Condition by inject()
    private val tokenizer: Tokenizer by inject()
    private val systemCommandInvoker: SystemCommandInvoker by inject()

    init {
        addCommand("help", CommandType.VISIBILITY_ARG)
        addCommand("exit", CommandType.EXECUTE_LOCALLY)
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
                try {
                    when (commandType) {
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
                            string(tokenizer.md5(asker.askLogin()))
                            string(tokenizer.md5(asker.askPassword()))
                        }

                        CommandType.EXECUTE_LOCALLY -> {
                            val packet = packet {
                                this.commandName = commandName
                            }
                            systemCommandInvoker.invoke(packet.wrapIntoArray())
                            packet
                        }

                        else -> Packet()
                    }
                } catch (e: Exception) {
                    Packet()
                }
            }
        }
    }

    fun UIparse(args: MutableList<String>) : Packet {
        fun PacketBuilder.route(init: MutableList<String>) : Route {
            return route {
                name = init[0]
                coordinates = coordinates {
                    x = init[1].toFloat()
                    y = init[2].toInt()
                }
                from = location {
                    x = init[3].toInt()
                    y = init[4].toFloat()
                    z = init[5].toLong()
                    name = init[6]
                }
                to = location {
                    x = init[7].toInt()
                    y = init[8].toFloat()
                    z = init[9].toLong()
                    name = init[10]
                }
                distance = init[11].toDouble()
            }
        }

        val commandName = args[0]
        val commandType = commands[commandName]
        args.removeFirst()
        return when(commandType) {
            CommandType.NO_ARG -> packet{ this.commandName = commandName }
            CommandType.SINGLE_ARG -> packet{
                this.commandName = commandName
                string(args[0])
            }
            CommandType.OBJECT_ARG -> packet {
                this.commandName = commandName
                route(args)
            }
            CommandType.MIXED_ARG -> packet {
                this.commandName = commandName
                string(args[0])
                args.removeFirst()
                route(args)
            }
            CommandType.VISIBILITY_ARG -> packet {
                this.commandName = commandName
                visibility(condition.get())
            }
            CommandType.TWO_STRINGS_ARG -> packet {
                this.commandName = commandName
                string(tokenizer.md5(args[0]))
                string(tokenizer.md5(args[1]))
            }
            CommandType.EXECUTE_LOCALLY -> {
                val packet = packet {
                    this.commandName = commandName
                }
                systemCommandInvoker.invoke(packet.wrapIntoArray())
                packet
            }
            else -> packet{}
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