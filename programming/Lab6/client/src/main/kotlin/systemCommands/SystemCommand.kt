package systemCommands

import clientCommands.utils.CommandParser
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.CommandType
import utils.ReaderManager
import utils.WriterManager
import java.io.BufferedReader
import java.io.PrintWriter

abstract class SystemCommand: KoinComponent {
    internal val commandParser : CommandParser by inject()
    internal val printWriterManager : WriterManager<PrintWriter> by inject()
    internal val bufferedReaderManager : ReaderManager<BufferedReader> by inject()
    internal var writer : PrintWriter = printWriterManager.get()
    internal var reader : BufferedReader = bufferedReaderManager.get()
    abstract fun execute(singleArg: String?, commandType: CommandType?)
}
