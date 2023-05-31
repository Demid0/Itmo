package clientCommands

import utils.*
import commandArgumentsAndTheirsComponents.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/***
 * Абстрактный класс команды
 * @author Demid0
 * @since 1.0
 */
//@Serializable
abstract class ClientCommand(commandType: CommandType, val visibility: Visibility): Command(commandType), KoinComponent {
    val collectionManager: CollectionManager by inject()
    internal val serializator: Serializator by inject()
    internal val clientCommandInvoker: ClientCommandInvoker by inject()
    internal val clients: HashMap<String, ClientAssistant> by inject()

    abstract fun execute(arguments: ArrayList<CommandArgument>) : ArrayList<Packet>
}