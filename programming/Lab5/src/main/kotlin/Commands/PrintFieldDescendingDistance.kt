package Commands
/***
 *     print_field_descending_distance : вывести значения поля distance всех элементов в порядке убывания
 */
class PrintFieldDescendingDistance: Command() {
    override fun execute(args: List<String>) {
        val collection = data.collection.sortedByDescending { it.getDistance() }
        if (collection.isEmpty()) writer.println("Collection is empty.")
        else writer.println("Collection:")
        for (element in collection) {
            writer.print("${element.getDistance()} ")
        }
        writer.println()
    }
}
