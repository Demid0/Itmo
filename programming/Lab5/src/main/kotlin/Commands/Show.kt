package Commands

class Show : Command {
    override fun execute(args: List<String>) {
        var collection = Data.collection
        println("Collection:")
        for (element in collection) {
            println(element.toString())
        }
    }
}
