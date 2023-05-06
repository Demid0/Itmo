package utils

import clientCommands.utils.CommandParser
import org.koin.core.component.KoinComponent
import org.koin.dsl.module
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.io.PrintWriter
import java.util.Stack

val clientKoinModule = module {

    single { CommandParser() }

    single { ReaderManager(BufferedReader(InputStreamReader(System.`in`))) }

    single { WriterManager(PrintWriter(System.out)) }

    single { App() }

    single { Serializator() }

    single { Asker() }

    single { SystemCommandInvoker() }

    single { Stack<String>() }

    single { Stack<BufferedReader>() }

}

class ClientUtilsFabric: KoinComponent