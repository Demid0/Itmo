package clientCommands

import utils.CollectionManager
import collectionObjectsClasses.Route
import kotlinx.serialization.Serializable
import utils.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/***
 * Абстрактный класс команды
 * @author Demid0
 * @since 1.0
 */
@Serializable
abstract class ClientCommand(val type: CommandType) : KoinComponent {
    internal val collectionManager: CollectionManager by inject()
    internal val serializator: Serializator by inject()

    abstract fun execute(singleArg: String?, objectArg: Route?) : AnswerPacket
}
