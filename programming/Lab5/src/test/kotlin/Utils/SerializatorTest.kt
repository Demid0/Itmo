package Utils

import CollectionObjectsClasses.Route
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File
import java.io.InputStreamReader
import java.io.PrintWriter

class SerializatorTest {

    @Test
    fun `check serialization and deserialization`() {
        //check
        val serializator = Serializator()
        var file = File("testData")
        var reader = InputStreamReader(file.inputStream())
        val rollback = reader.readText()
        var input: String
        var collection: MutableCollection<Route>
        var output: String
        var writer: PrintWriter
        try {
            for (strategy in serializator.getStrategies()) {
                file = File("testData")
                reader = InputStreamReader(file.inputStream())
                input = reader.readText()
                collection = serializator.deserialize(input)
                output = serializator.serialize(collection)
                assertEquals(input, output)
                serializator.changeStrategy(strategy.value)
                writer = PrintWriter("testData")
                writer.print(serializator.serialize(collection))
                writer.flush()
            }
            //check for last
            file = File("testData")
            reader = InputStreamReader(file.inputStream())
            input = reader.readText()
            collection = serializator.deserialize(input)
            output = serializator.serialize(collection)
            assertEquals(input, output)
        } catch (_: Exception) {
            assertEquals("good", "bad")
        }
        finally {//rollback
            writer = PrintWriter("testData")
            writer.print(rollback)
            writer.flush()
        }
    }
}