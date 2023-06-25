package utils

import commandArgumentsAndTheirsComponents.Visibility
import org.koin.core.component.KoinComponent
import org.koin.dsl.module
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.util.concurrent.ArrayBlockingQueue


val clientKoinModule = module {

    single { ParseCommandAndAskArguments() }

    single { ReaderManager(BufferedReader(InputStreamReader(System.`in`))) }

    single { WriterManager(PrintWriter(System.out)) }

    single { App() }

    single { Serializator() }

    single { Asker() }

    single { SystemCommandInvoker() }

    single { ArrayBlockingQueue<String>(10000) }

    single { HashMap<String, BufferedReader>() }

    single { ClientMessageHandler() }

    single { Condition(Visibility.UNLOGGED_USER) }

    single { Tokenizer() }

}

class ClientUtilsFabric: KoinComponent
