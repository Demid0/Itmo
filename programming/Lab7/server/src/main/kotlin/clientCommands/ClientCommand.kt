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
    var collectionManager = CollectionManager("default")
    internal val serializator: Serializator by inject()
    internal val clientCommandInvoker: ClientCommandInvoker by inject()
    private val caster: Caster by inject()

    private val noArg: (a: ArrayList<CommandArgument>) -> Unit = {}
    private val singleArg: (a: ArrayList<CommandArgument>) -> String = { a -> caster.toString(a[0]) }
    private val objectsArg: (a: ArrayList<CommandArgument>) -> Route = { a -> caster.toRoute(a[0]) }
    private val mixedArg: (a: ArrayList<CommandArgument>) -> Pair<String, Route> = { a -> caster.toString(a[0]) to caster.toRoute(a[1])}
    abstract fun execute(arguments: ArrayList<CommandArgument>) : ArrayList<Packet>
    fun <T> cast(args: ArrayList<CommandArgument>) : T = when(commandType) {
        CommandType.SINGLE_ARG -> singleArg
        CommandType.OBJECT_ARG -> objectsArg
        CommandType.MIXED_ARG -> mixedArg
        else -> noArg
    }.invoke(args) as T
}
