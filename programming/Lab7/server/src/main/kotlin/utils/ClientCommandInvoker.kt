package utils

import clientCommands.*
import org.koin.core.component.KoinComponent

/***
 * Класс, вызывающий команды
 * @author Demid0
 * @since 1.0
 * @param commands
 * Поддерживаемые типы комманд
 */
class ClientCommandInvoker: KoinComponent {
    private val commands = HashMap<String, ClientCommand>()

    init {
        addCommand("add", Add())
        addCommand("add_if_max", AddIfMax())
        addCommand("change_collection_type", ChangeCollectionType())
        addCommand("change_serialization_strategy", ChangeSerializationStrategy())
        addCommand("checkout", Checkout())
        addCommand("clear", Clear())
        addCommand("count_by_distance", CountDistance { a: Double, b: Double -> a == b })
        addCommand("count_less_than_distance", CountDistance { a: Double, b: Double -> a < b })
        addCommand("execute_script", ExecuteScript())
        addCommand("exit", Exit())
        addCommand("help", Help())
        addCommand("info", Info())
        addCommand("login", Login())
        addCommand("print_field_descending_distance", PrintFieldDescendingDistance())
        addCommand("remove_by_id", RemoveById())
        addCommand("remove_first", RemoveFirst())
        addCommand("remove_lower", RemoveLower())
        addCommand("show", Show())
        addCommand("sign_up", SignUp())
        addCommand("update", UpdateId())
    }

    fun invoke(listOfPackets: ArrayList<Packet>): ArrayList<Packet> {
        val ans = ArrayList<Packet>()
        listOfPackets.forEach { packet ->
            val command = commands[packet.commandName]!!
            ans.addAll(command.execute(packet.arguments))
        }
        return ans
    }
    fun addCommand (commandName: String, clientCommand: ClientCommand) = commands.put(commandName, clientCommand)
    fun getCommands() = commands

}