package Commands

/***
 * change_collection_type type : поменять тип коллекции
 * @author Demid0
 * @since 1.0
 */
class ChangeCollectionType: Command() {

    override fun execute(args: List<String>) {
        try {
            val newType = args[1]
            data.changeType(newType)
            writer.println("Changed!")
        } catch (e: NullPointerException) {
            System.err.println("Unsupported collection type.")
            printSupportedTypes()
        } catch (e: IndexOutOfBoundsException) {
            System.err.println("Empty input.")
            printSupportedTypes()
        }
    }

    private fun printSupportedTypes() {
        println("You can use this types:")
        for (type in data.getSupportedCollectionTypes()) {
            println(type.key)
        }
    }
}