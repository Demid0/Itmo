import Utils.*
import java.io.*


val writer = PrintWriter(System.out, true)
val reader = BufferedReader(InputStreamReader(System.`in`))

val creator = UtilFabric()

val starter = creator.createStarter()
val asker = creator.createAsker()
val invoker = creator.createInvoker()
val serializator = creator.createSerializator()
val data = creator.createData()

val tank = Tank(invoker, data, serializator, asker, reader, writer)
fun main(args: Array<String>) {
    starter.start(tank)
    while(true) {
        val input = reader.readLine().split(" ").toMutableList()
        input.removeAll(setOf("", {input.size}))
        invoker.invoke(tank, input)
    }
}
