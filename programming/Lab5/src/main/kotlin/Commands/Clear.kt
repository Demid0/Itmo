package Commands
/***
 * clear : очистить коллекцию
 * @author Demid0
 * @since 1.0
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
