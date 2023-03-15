import Serialization.Serializator
import Utils.*
import java.io.*
import Utils.Data as Data

val starter = Starter()
val writer = PrintWriter(System.out, true)
val reader = BufferedReader(InputStreamReader(System.`in`))
val asker = Asker()
val invoker = Invoker()
val serializator = Serializator()
val data = Data()

val tank = Tank(invoker, data, serializator, asker, reader, writer)
fun main(args: Array<String>) {
    starter.start(tank)
    while(true) {
        val input = reader.readLine().split(" ").toMutableList()
        input.removeAll(setOf("", {input.size}))
        invoker.invoke(tank, input)
    }
}
