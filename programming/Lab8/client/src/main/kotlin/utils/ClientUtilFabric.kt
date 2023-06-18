package utils

import commandArgumentsAndTheirsComponents.Visibility
import org.koin.dsl.module
import tornado.UIAsker
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter


val clientKoinModule = module {

    single { parseCommandAndAskArguments() }

    single { ReaderManager(BufferedReader(InputStreamReader(System.`in`))) }

    single { WriterManager(PrintWriter(System.out)) }

    single { ConsoleApp() }

    single { Serializator() }

    single { Asker() }

    single { SystemCommandInvoker() }

    single { ArrayDeque<String>() }

    single { HashMap<String, BufferedReader>() }

    single { ClientMessageHandler() }

    single { Condition(Visibility.UNLOGGED_USER) }

    single { Tokenizer() }

    single { UIAsker() }

}

