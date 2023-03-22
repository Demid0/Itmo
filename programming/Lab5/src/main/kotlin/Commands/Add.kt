package Commands

/***
 * add {element} : добавить новый элемент в коллекцию
 * @author Demid0
 * @since 1.0
 */
class Add: Command() {
    override fun execute(args: List<String>) {
        try {
            data.collection.add(asker.askRoute(reader, writer))
            writer.println("Done!")
        } catch (e: Exception) {
            System.err.println("Not added.")
        }
    }
}