package web.lab4.controllers

import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import web.lab4.domain.Point
import web.lab4.repo.PointRepo

@RestController
@RequestMapping("controller/hash_to_init")
class Controller {
    private final var array: PointRepo

    @Autowired
    constructor(pointRepo: PointRepo) {
        array = pointRepo
    }

    @PostMapping
    fun create(@RequestBody point: Point) = array.save(point)

    @GetMapping
    fun readAll() = array.findAll()

    @GetMapping("{id}")
    fun readOne(@PathVariable("id") point: Point) = point

    @PutMapping("{id}")
    fun updateOne(@PathVariable("id") pointFromDb: Point, @RequestBody point: Point): Point {
        BeanUtils.copyProperties(point, pointFromDb, "id")
        return array.save(pointFromDb)
    }

    @DeleteMapping("{id}")
    fun deleteOne(@PathVariable id: Int) = array.deleteById(id)

    @DeleteMapping
    fun deleteAll() = array.deleteAll()
}