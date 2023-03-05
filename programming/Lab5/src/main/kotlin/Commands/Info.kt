package Commands

class Info : Command {
    override fun execute(args: List<String>) {
        println("Information about collection:")
        println("Type: ${Data.collection::class}")
        println("Size: ${Data.collection.size}")
    }
}
