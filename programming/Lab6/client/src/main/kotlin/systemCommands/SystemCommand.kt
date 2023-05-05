package systemCommands

import clientCommands.utils.CommandParser
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.CommandType
import utils.ReaderManager
import utils.WriterManager
import java.util.Stack

abstract class SystemCommand: KoinComponent {
    internal val commandParser : CommandParser by inject()
    internal val commandOutputWriterManager : WriterManager by inject()
    internal val readerManager : ReaderManager by inject()
    internal val scriptStack: Stack<String> by inject()
    abstract fun execute(singleArg: String?, commandType: CommandType?): Boolean
}
