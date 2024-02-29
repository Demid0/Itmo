package controllers

import builders.packet
import clientMessageHandler
import models.User
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import tornadofx.Controller
import utils.Tokenizer
import java.nio.ByteBuffer

class SetUserController: Controller(), KoinComponent {
    private val tokenizer by inject<Tokenizer>()

    fun exec(commandName: String, user: User): Pair<Boolean, Pair<Boolean, ByteBuffer>> {
        val ans = clientMessageHandler.sendAndRecieve(packet {
            this.commandName = commandName
            argsArray {
                string(tokenizer.md5(user.usernameProperty.value))
                string(tokenizer.md5(user.passwordProperty.value))
            }
        })
        return (ans.first && clientMessageHandler.unpackMessage(ans.second).first().commandName == "set_user") to ans
    }
}