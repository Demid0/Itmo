package web.lab4.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import web.lab4.entities.point.Point
import web.lab4.entities.point.PointService
import web.lab4.entities.user.UserService

@RestController
@RequestMapping("controller")
class Controller {

    @Autowired
    private lateinit var pointService: PointService
    @Autowired
    private lateinit var userService: UserService

    @PostMapping
    fun create(@RequestBody point: Point, @RequestHeader(HttpHeaders.AUTHORIZATION) token: String): ResponseEntity<*> {
        try {
            point.ownerId = userService.getByToken(token).id
            return ResponseEntity.ok(pointService.save(point))
        } catch (e: Exception) {
            return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping
    fun readAll(@RequestHeader(HttpHeaders.AUTHORIZATION) token: String): ResponseEntity<*> {
        try {
            val ownerId = userService.getByToken(token).id
            return ResponseEntity.ok(pointService.getByOwnerId(ownerId))
        } catch (e: Exception) {
            return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
        }
    }
    @DeleteMapping
    fun deleteAll(@RequestHeader(HttpHeaders.AUTHORIZATION) token: String) : ResponseEntity<*> {
        try {
            val ownerId = userService.getByToken(token).id
            return ResponseEntity(pointService.deleteAllByOwnerId(ownerId), HttpStatus.OK)
        } catch (e: Exception) {
            return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
        }
    }

    @DeleteMapping("{id}")
    fun deleteOne(@PathVariable id: Int, @RequestHeader(HttpHeaders.AUTHORIZATION) token: String): ResponseEntity<*> {
        try {
            val ownerId = userService.getByToken(token).id
            return ResponseEntity(pointService.deleteById(id, ownerId), HttpStatus.OK)
        } catch (e: Exception) {
            return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
        }
    }
}