import commands.*
import org.koin.core.component.KoinComponent
import utils.AnswerPacket
import utils.ArgumentPacket

/***
 * Класс, вызывающий команды
 * @author Demid0
 * @since 1.0
 * @param commands
 * Поддерживаемые типы комманд
 */
class ClientCommandInvoker: KoinComponent {
    val commands = HashMap<String, ClientCommand>()

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

    fun invoke(argumentPacket: ArgumentPacket): AnswerPacket {
        return commands[argumentPacket.commandName]!!.execute(argumentPacket.singleArg, argumentPacket.objectArg)
    }
    fun addCommand (commandName: String, clientCommand: ClientCommand) = commands.put(commandName, clientCommand)
    fun getCommands() = commands

}