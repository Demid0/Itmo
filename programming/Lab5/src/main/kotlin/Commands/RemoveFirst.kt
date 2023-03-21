package Commands

import java.util.NoSuchElementException
/***
 *     remove_first : удалить первый элемент из коллекции
 */
class RemoveFirst: Command() {
    override fun execute(args: List<String>) {
        try {
            data.collection.remove(data.collection.first())
            writer.println("Done!")
        }
        catch (e: NoSuchElementException) { System.err.println("Collection is empty") }
        catch (e: Exception) { System.err.println("Something went wrong") }
    }
}
