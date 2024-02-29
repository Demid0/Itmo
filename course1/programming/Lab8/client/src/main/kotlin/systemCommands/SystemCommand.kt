package systemCommands

import utils.ParseCommandAndAskArguments
import commandArgumentsAndTheirsComponents.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.*
import java.io.*
import java.util.concurrent.ArrayBlockingQueue

open class SystemCommand<R>(
    val commandName: String,
    val type: (ArrayList<CommandArgument>) -> R,
    val execution: SystemCommand<R>.(R) -> Unit
): KoinComponent {
    val app: App by inject()
    val scriptStack: ArrayBlockingQueue<String> by inject()
    val readerStack: HashMap<String, BufferedReader> by inject()
    internal val parseCommandAndAskArguments : ParseCommandAndAskArguments by inject()
    val writerManager : WriterManager by inject()
    val readerManager : ReaderManager by inject()
    internal val condition : Condition by inject()
    open fun execute(arguments: ArrayList<CommandArgument>) {
        execution.invoke(this, type.invoke(arguments))
    }
}

