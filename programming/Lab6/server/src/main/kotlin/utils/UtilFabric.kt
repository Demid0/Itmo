package utils

import org.koin.core.component.KoinComponent
import org.koin.dsl.module
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.util.*

/***
 * Модуль для Koin DI
 * @author Demid0
 * @since 1.0
 */
val koinModule = module {

    single { Starter() }

    single { WriterManager(PrintWriter(System.out, true)) }

    single { ReaderManager(BufferedReader(InputStreamReader(System.`in`))) }

    single { ClientCommandInvoker() }

    single { Serializator() }

    single { Data() }

    single { Stack<String>() }

}

/***
 * Класс, экземпляр которого используется для инъекции зависимостей в main
 * @author Demid0
 * @since 1.0
 */
class UtilFabric: KoinComponent