package commands.utils

import collectionObjectsClasses.Route
import kotlinx.serialization.Serializable
import utils.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import serializationStrategies.utils.Serializator
import java.io.PrintWriter
import java.util.*
/***
 * Абстрактный класс команды
 * @author Demid0
 * @since 1.0
 */
@Serializable
abstract class Command(val type: CommandType) : KoinComponent {
    internal val app: App by inject()
    internal val data: Data by inject()
    internal val serializator: Serializator by inject()
    internal val scriptStack: Stack<String> by inject()
    internal val commandParser: CommandParser by inject()
    internal val printWriterManager: WriterManager<PrintWriter> by inject()

    abstract fun execute(singleArg: String?, objectArg: Route?) : String
}
