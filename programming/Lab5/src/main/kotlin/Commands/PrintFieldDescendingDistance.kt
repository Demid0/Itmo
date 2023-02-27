package Commands

class PrintFieldDescendingDistance : Command {
    override fun execute(args: List<String>) {
        var collection = Data.collection.sortedByDescending { it.getDistance() }
        for (element in collection) {
            print("${element.getDistance()} ")
        }
    }
}
