package utils

import GUIsystemCommands.*
import commandArgumentsAndTheirsComponents.Visibility
import org.koin.dsl.module
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter

val GUIclientKoinModule = module {

    single { ParseCommandAndAskArguments() }

    single { ReaderManager(BufferedReader(InputStreamReader(System.`in`))) }

    single { WriterManager(PrintWriter(System.out)) }

    single { App() }

    single { Serializator() }

    single {
        val systemCommandInvoker = SystemCommandInvoker()
        systemCommandInvoker.addCommand(printToClient)
        systemCommandInvoker.addCommand(clearTable)
        systemCommandInvoker.addCommand(insertIntoTable)
        systemCommandInvoker
    }

    single { ArrayDeque<String>() }

    single { HashMap<String, BufferedReader>() }

    single { ClientMessageHandler() }

    single { Condition(Visibility.UNLOGGED_USER) }

    single { Tokenizer() }

}