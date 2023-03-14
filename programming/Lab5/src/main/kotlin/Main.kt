import Serialization.Serializator
import Utils.*
import java.io.InputStreamReader
import java.io.PrintWriter

val starter = Starter()
val asker = Asker(InputStreamReader(System.`in`), PrintWriter(System.out))
val invoker = Invoker()
val serializator = Serializator()
val data = Data()
val tank = Tank(invoker, data, serializator, asker)
fun main(args: Array<String>) {
    starter.start(tank)
    while(true) {
        val input = readln().split(" ").toMutableList()
        input.removeAll(setOf("", {input.size}))
        invoker.invoke(tank, input)
    }
}
