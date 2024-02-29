package models

import javafx.beans.property.SimpleStringProperty
import tornadofx.ViewModel

class User {
    val usernameProperty = SimpleStringProperty()
    val passwordProperty = SimpleStringProperty()
}

class UserModel(var user: User): ViewModel() {
    var username = bind { user.usernameProperty }
    var password = bind { user.passwordProperty }
}