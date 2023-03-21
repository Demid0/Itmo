package Commands
/***
 *     clear : очистить коллекцию
 */
class Clear: Command() {
    override fun execute(args: List<String>) {
        try {
            data.collection.clear()
            writer.println("Done!")
        } catch (e: Exception) {
            System.err.println("Not cleared. Хз как")
        }
    }
}
