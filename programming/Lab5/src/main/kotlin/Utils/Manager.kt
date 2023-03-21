package Utils

import java.io.BufferedReader
import java.io.PrintWriter

abstract class Manager<T>(private var obj: T) {
    fun get() = obj
    fun set(obj: T) {
        this.obj = obj
    }
}

class BufferedReaderManager(obj: BufferedReader) : Manager<BufferedReader>(obj)
class PrintWriterManager(obj: PrintWriter) : Manager<PrintWriter>(obj)
