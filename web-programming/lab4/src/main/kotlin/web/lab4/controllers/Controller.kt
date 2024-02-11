package web.lab4.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import web.lab4.authentication.jwt.JwtService
import web.lab4.entities.Point
import web.lab4.repositories.PointRepository
import web.lab4.repositories.UserRepository

@RestController
@RequestMapping("controller")
class Controller {

    @Autowired
    private lateinit var array: PointRepository
    @Autowired
    private lateinit var userRepository: UserRepository
    @Autowired
    private lateinit var jwtService: JwtService

    @PostMapping
    fun create(@RequestBody point: Point, @RequestHeader(HttpHeaders.AUTHORIZATION) token: String): ResponseEntity<*> {
        try {
            point.ownerId = userRepository.findByName(jwtService.extractUsername(token.split(" ")[1]).orEmpty())
                .orElseThrow { Exception("Bad token") }.id
            return ResponseEntity.ok(array.save(point))
        } catch (e: Exception) {
            return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping
    fun readAll(@RequestHeader(HttpHeaders.AUTHORIZATION) token: String): ResponseEntity<*> {
        try {
            val ownerId = userRepository.findByName(jwtService.extractUsername(token.split(" ")[1]).orEmpty())
                .orElseThrow { Exception("Bad token") }.id
            return ResponseEntity.ok(array.findAll().filter { it.ownerId == ownerId })
        } catch (e: Exception) {
            return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
        }
    }
    @DeleteMapping
    fun deleteAll(@RequestHeader(HttpHeaders.AUTHORIZATION) token: String) : ResponseEntity<*> {
        try {
            val ownerId = userRepository.findByName(jwtService.extractUsername(token.split(" ")[1]).orEmpty())
                .orElseThrow { Exception("Bad token") }.id
            return ResponseEntity(array.deleteAllByOwnerId(ownerId), HttpStatus.OK)
        } catch (e: Exception) {
            return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
        }
    }
}