package Commands

import Utils.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.*
/***
 * Абстрактный класс команды
 * @author Demid0
 * @since 1.0
 */
abstract class Command : KoinComponent {
    private val printWriterManager: PrintWriterManager by inject()
    private val bufferedReaderManager: BufferedReaderManager by inject()

    val data: Data by inject()
    val asker: Asker by inject()
    val invoker: Invoker by inject()
    val serializator: Serializator by inject()
    val scriptStack: Stack<String> by inject()
    var reader = bufferedReaderManager.get()
    var writer = printWriterManager.get()

    abstract fun execute(args: List<String>)
}