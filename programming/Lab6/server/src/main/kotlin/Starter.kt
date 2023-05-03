import org.koin.core.component.KoinComponent
import java.io.*
import org.koin.core.component.inject
import utils.Serializator
import utils.WriterManager

/***
 * Класс, загружающий последнее сохраненное состояние системы и коллекции
 * @author Demid0
 * @since 1.0
 */
class Starter: KoinComponent {
    private val data: Data by inject()
    private val serializator: Serializator by inject()
    private val printWriterManager: WriterManager<PrintWriter> by inject()
    private val writer = printWriterManager.get()
    fun downloadLastSystemCondition() {
        writer.println("Downloading last system condition")
        try {
            val file = File(data.getInfoFileName())
            val reader = InputStreamReader(file.inputStream())
            val output = reader.readLines()

            // Пробует десериализовать по последней стратегии, если не получается, то пробегается по всем возможным
            serializator.changeStrategy(serializator.getStrategy(output[1])!!)
            if (!downloadCollection()) {
                var flag = false
                for (strategy in serializator.getStrategies()) {
                    serializator.changeStrategy(strategy.value)
                    if (downloadCollection()) {
                        flag = true
                        break
                    }
                }
                if (flag) writer.println("File was in ${serializator.getChosenStrategy().toString()} type.")
                else writer.println("Collection didn't download")
            }

            serializator.changeStrategy(serializator.getStrategy(output[1])!!)

            data.changeType(output[0])
            writer.println("Done!")
        } catch (_: Exception) {
            writer.println("Can't found info about last system condition. Will use default serialization strategy and default collection type.")
        }
    }

    private fun downloadCollection(): Boolean {
        try {
            val file = File(data.getFileName())
            val reader = InputStreamReader(file.inputStream())
            data.collection = serializator.deserialize(reader.readText(), data.collection)
        } catch (e: FileNotFoundException) {
            writer.println("File not found")
            return false
        } catch (e: Exception) {
            writer.println("Serialization strategy ${serializator.getChosenStrategy()} is not working.")
            return false
        }
        return true
    }

}