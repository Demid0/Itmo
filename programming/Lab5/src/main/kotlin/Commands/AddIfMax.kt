package Commands

class AddIfMax : Command {
    override fun execute(args: List<String>) {
        val route = Asker.askRoute()
        var bool = true
        for (element in Data.collection) {
            if (element.getDistance() >= route.getDistance()) {
                println("I didn't add it")
                bool = false
                break
            }
        }
        if(bool) {
            Data.collection.add(route)
            println("Route added")
        }
    }

}
