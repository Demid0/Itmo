val starter = Starter()
val data = Data()
val asker = Asker()
val invoker = Invoker()
fun main(args: Array<String>) {
    starter.start(data)
    while(true) {
        val input = readln().split(" ").toMutableList()
        input.removeAll(setOf("", {input.size}))
        invoker.invoke(data, asker, input)
    }
}