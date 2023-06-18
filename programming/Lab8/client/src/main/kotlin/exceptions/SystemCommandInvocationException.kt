package exceptions


open class SystemCommandInvocationException(message: String): Exception(message) {
    constructor() : this("")
}
class UIException(string: String = ""): SystemCommandInvocationException(string)

class RecursionException: SystemCommandInvocationException("No way! Recursion")
