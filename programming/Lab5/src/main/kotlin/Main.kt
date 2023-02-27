
fun main(args: Array<String>) {
    Starter.start()
    while(true) {
        var input = readln().split(" ").toMutableList()
        input.removeAll(setOf("", {input.size}))
        Invoker.invoke(input)
    }
}