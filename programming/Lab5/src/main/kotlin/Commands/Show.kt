package Commands
/***
 *     show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
 */
class Show: Command() {
    override fun execute(args: List<String>) {
        val collection = data.collection
        if (collection.isEmpty()) writer.println("Collection is empty :(")
        else writer.println("Collection:")
        for (element in collection) {
            println(element.toString())
        }
    }
}
