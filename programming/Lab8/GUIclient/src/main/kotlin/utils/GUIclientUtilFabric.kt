package utils

import GUIsystemCommands.*
import commandArgumentsAndTheirsComponents.Visibility
import org.koin.dsl.module
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.util.concurrent.ArrayBlockingQueue

val GUIclientKoinModule = module {

    single { ParseCommandAndAskArguments() }

    single { ReaderManager(BufferedReader(InputStreamReader(System.`in`))) }

    single { WriterManager(PrintWriter(System.out)) }

    single { App() }

    single { Asker() }

    single { Serializator() }

    single {
        val systemCommandInvoker = SystemCommandInvoker()
        with(systemCommandInvoker) {
            addCommand(printToClient)
            addCommand(clearTable)
            addCommand(insertIntoTable)
            addCommand(readFromFile)
        }
        systemCommandInvoker
    }

    single { ArrayBlockingQueue<String>(10000) }

    single { HashMap<String, BufferedReader>() }

    single { ClientMessageHandler() }

    single { Condition(Visibility.UNLOGGED_USER) }

    single { Tokenizer() }

}