import Utils.*
import org.koin.core.component.inject
import org.koin.core.context.startKoin


fun main(args: Array<String>) {
    startKoin {
        modules(koinModule)
    }
    val utilFabric = UtilFabric()
    val starter: Starter by utilFabric.inject()
    val bufferedReaderManager: BufferedReaderManager by utilFabric.inject()
    val reader = bufferedReaderManager.get()
    val invoker: Invoker by utilFabric.inject()
    starter.downloadLastSystemCondition()
    while(true) {
        val input = reader.readLine().split(" ").toMutableList()
        input.removeAll(setOf("", {input.size}))
        invoker.invoke(input)
    }
}
