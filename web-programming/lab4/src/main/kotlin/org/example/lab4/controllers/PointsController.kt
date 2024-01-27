package org.example.lab4.controllers

import org.example.lab4.from3lab.Point
import org.example.lab4.from3lab.PointCreator
import org.example.lab4.from3lab.PointsRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("main")
class PointsController {
    private final val pointsRepo: PointsRepo

    @Autowired
    constructor(pointsRepo: PointsRepo) {
        this.pointsRepo = pointsRepo
    }

    @PostMapping
    fun create(@RequestBody params: Map<String, String>): Point {
        val point: Point
        try {
            point = PointCreator.create(
                params["x"]!!.toDouble(),
                params["y"]!!.toDouble(),
                params["r"]!!.toDouble(),
                params["time"]!!
            )
            pointsRepo.save(point)
            return point
        } catch (e: Exception) {
            println("pointsController.create exception ${e.message}")
        }
        return Point(id = -1)
    }

    @GetMapping
    fun read() = pointsRepo.findAll()

    @DeleteMapping
    fun delete() = pointsRepo.deleteAll()

}