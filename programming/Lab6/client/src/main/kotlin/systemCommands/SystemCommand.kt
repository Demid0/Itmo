package systemCommands

import clientCommands.utils.CommandParser
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.CommandType
import utils.ReaderManager
import utils.WriterManager
import java.io.BufferedReader
import java.util.Stack

abstract class SystemCommand: KoinComponent {
    internal val scriptStack: ArrayDeque<String> by inject()
    internal val readerStack: HashMap<String, BufferedReader> by inject()
    internal val commandParser : CommandParser by inject()
    internal val writerManager : WriterManager by inject()
    internal val readerManager : ReaderManager by inject()
    abstract fun execute(singleArg: String?, commandType: CommandType?): Boolean
}
