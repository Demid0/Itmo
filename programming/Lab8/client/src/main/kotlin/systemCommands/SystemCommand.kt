package systemCommands

import utils.ParseCommandAndAskArguments
import commandArgumentsAndTheirsComponents.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.*
import java.io.*

open class SystemCommand<R>(
    val commandName: String,
    val type: (ArrayList<CommandArgument>) -> R,
    val execution: SystemCommand<R>.(R) -> Unit
): KoinComponent {
    internal val scriptStack: ArrayDeque<String> by inject()
    internal val readerStack: HashMap<String, BufferedReader> by inject()
    internal val parseCommandAndAskArguments : ParseCommandAndAskArguments by inject()
    internal val writerManager : WriterManager by inject()
    internal val readerManager : ReaderManager by inject()
    internal val condition : Condition by inject()
    open fun execute(arguments: ArrayList<CommandArgument>) {
        execution.invoke(this, type.invoke(arguments))
    }
}

