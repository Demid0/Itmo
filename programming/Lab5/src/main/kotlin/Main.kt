
fun main(args: Array<String>) {
    Starter.start()
    while(true) {
        val input = readln().split(" ").toMutableList()
        input.removeAll(setOf("", {input.size}))
        Invoker.invoke(input)
    }
}