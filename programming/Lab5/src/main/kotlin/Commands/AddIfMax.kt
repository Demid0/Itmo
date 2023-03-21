package Commands

class AddIfMax: Command() {
    override fun execute(args: List<String>) {
        try {
            val route = asker.askRoute(reader, writer)
            var bool = true
            for (element in data.collection) {
                if (element.getDistance() >= route.getDistance()) {
                    writer.println("I didn't add it")
                    bool = false
                    break
                }
            }
            if (bool) {
                data.collection.add(route)
                writer.println("Done!")
            }
        } catch (e: Exception) {
            System.err.println("Something went wrong.")
        }
    }

}
