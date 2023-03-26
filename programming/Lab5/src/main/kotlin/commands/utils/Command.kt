package commands.utils

import utils.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import serializationStrategies.utils.Serializator
import java.util.*
/***
 * Абстрактный класс команды
 * @author Demid0
 * @since 1.0
 */
abstract class Command(val type: CommandType) : KoinComponent {
    val app: App by inject()
    val data: Data by inject()
    val serializator: Serializator by inject()
    val scriptStack: Stack<String> by inject()
    val commandParser: CommandParser by inject()
    abstract fun execute(args: Any?) : String
}
