import Utils.*
import org.koin.core.context.startKoin
import java.io.*


fun main(args: Array<String>) {
    startKoin {
        modules(koinModule)
    }
    val starter = Starter()
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val invoker = Invoker()
    starter.downloadLastSystemCondition()
    while(true) {
        val input = reader.readLine().split(" ").toMutableList()
        input.removeAll(setOf("", {input.size}))
        invoker.invoke(input)
    }
}
