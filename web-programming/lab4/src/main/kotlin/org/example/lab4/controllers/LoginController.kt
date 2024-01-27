package org.example.lab4.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("")
class LoginController {
    @GetMapping
    fun isValidUser() {

    }

    @PostMapping
    fun createUser() {

    }

}