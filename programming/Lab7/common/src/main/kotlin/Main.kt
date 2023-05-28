import builders.ArgumentsBuilder

fun main(args: Array<String>) {
    val argumentsBuilder = ArgumentsBuilder()
    val route = argumentsBuilder.route {
        name = "Asdfg"
        coordinates = coordinates {
            x = null
            y = null
        }
        from = null
        to = location {
                x = 1
                y = 2.0f
                z = 3
                name = "sdfl"
            }
        distance = 5.0
    }
    println(route.toString())
}
