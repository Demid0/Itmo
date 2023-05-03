package utils

class AnswerPacket(var commandName: String = "print_to_client", var singleArg: String?, var commandType: CommandType?) {
    constructor(singleArg: String?) : this(singleArg = singleArg, commandType = null)
}