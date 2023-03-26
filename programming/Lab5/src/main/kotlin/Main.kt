import utils.*
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import java.io.BufferedReader

/***
 * Точка входа в программу
 */
fun main(args: Array<String>) {
    startKoin {
        modules(koinModule)
    }
    val utilFabric = UtilFabric()
    val app: App by utilFabric.inject()
    val starter: Starter by utilFabric.inject()
    val bufferedReaderManager: ReaderManager<BufferedReader> by utilFabric.inject()
    val reader = bufferedReaderManager.get()

    starter.downloadLastSystemCondition()
    try {
        app.run(reader)
    } catch (_: NullPointerException) {
        System.err.println("Зачем вы Ctrl+D нажали?")
    }
}
