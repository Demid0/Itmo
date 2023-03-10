import Serialization.Serializator
import Utils.*

val starter = Starter()
val data = Data()
val asker = Asker()
val invoker = Invoker()
val serializator = Serializator()
val tank = Tank(invoker, data, serializator, asker)
fun main(args: Array<String>) {
    starter.start(tank)
    while(true) {
        val input = readln().split(" ").toMutableList()
        input.removeAll(setOf("", {input.size}))
        try {
            invoker.invoke(tank, input)
        } catch (e: Exception) {
            println("Oops, something went wrong")
        }
    }
}
