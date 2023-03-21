package Utils

import org.koin.dsl.module
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.util.*

val koinModule = module {

    single { Starter() }

    single { Asker() }

    single { PrintWriterManager(PrintWriter(System.out, true)) }

    single { BufferedReaderManager(BufferedReader(InputStreamReader(System.`in`))) }

    single { Invoker() }

    single { Serializator() }

    single { Data() }

    single { Stack<String>() }

}