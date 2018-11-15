package com.jazzinjars.springboot.controller

import com.jazzinjars.springboot.repositories.ArticleRepository
import com.jazzinjars.springboot.services.MarkdownConverter
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/article")
class ArticleController(private val repository: ArticleRepository,
                        private val markdownConverter: MarkdownConverter) {

    @GetMapping("/")
    fun findAll() = repository.findAllByOrderByAddedAtDesc()

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Long, @RequestParam converter: String?) = when (converter) {
        "markdown" -> repository.findById(id).map { it.copy(
                headline = markdownConverter.invoke(it.headline),
                content = markdownConverter.invoke(it.content)) }
        null -> repository.findById(id)
        else -> throw IllegalArgumentException("Only markdown converter is supported")
    }
}