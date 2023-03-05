package Commands

class RemoveLower : Command {
    override fun execute(args: List<String>) {
        val route = Asker.askRoute()
        for (element in Data.collection) {
            if (element.getDistance() < route.getDistance()) {
                Data.collection.remove(element)
            }
        }
    }
}
