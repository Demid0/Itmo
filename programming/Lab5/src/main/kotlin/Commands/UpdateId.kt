package Commands

import java.lang.Exception
/***
 * update id {element} : обновить значение элемента коллекции, id которого равен заданному
 * @author Demid0
 * @since 1.0
 */
class UpdateId: Command() {
    override fun execute(args: List<String>) {
        try {
            var bool = false
            val id: Long = args[1].toLong()
            val route = asker.askRoute(reader, writer)
            for (element in data.collection) {
                if (element.getId() == id) {
                    element.update(
                        name = route.getName(),
                        coordinates = route.getCoordinates(),
                        from = route.getFrom(),
                        to = route.getTo(),
                        distance = route.getDistance()
                    )
                    bool = true
                    break
                }
            }
            if (bool) writer.println("Done!")
            else writer.println("No element with this id")
        } catch (e: Exception) {
            System.err.println("Wrong id format.")
        }
    }

}
