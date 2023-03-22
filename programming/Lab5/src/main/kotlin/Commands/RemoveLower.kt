package Commands
/***
 * remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный
 * @author Demid0
 * @since 1.0
 */
class RemoveLower: Command() {
    override fun execute(args: List<String>) {
        try {
            val route = asker.askRoute(reader, writer)
            for (element in data.collection) {
                if (element.getDistance() < route.getDistance()) {
                    data.collection.remove(element)
                }
            }
            writer.println("Done!")
        } catch (e: Exception) {
            System.err.println("Something went wrong.")
        }
    }
}
