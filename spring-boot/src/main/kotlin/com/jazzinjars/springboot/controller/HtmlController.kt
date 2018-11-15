package com.jazzinjars.springboot.controller

import com.jazzinjars.springboot.model.Article
import com.jazzinjars.springboot.model.RenderedArticle
import com.jazzinjars.springboot.repositories.ArticleRepository
import com.jazzinjars.springboot.services.MarkdownConverter
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.time.format.DateTimeFormatter

@Controller
class HtmlController(private val repository: ArticleRepository,
                     private val markdownConverter: MarkdownConverter,
                     private val properties: KotlinProperties) {

    @GetMapping("/")
    fun blog(model: Model): String {
        model["title"] = "Blog"
        model["articles"] = repository.findAllByOrderByAddedAtDesc().map { it.render() }
        return "blog"
    }

    @GetMapping("/article/{id}")
    fun article(@PathVariable id: Long, model: Model): String {
        val article = repository
                .findById(id)
                .orElseThrow { IllegalArgumentException("Wrong article id provided") }
                .render()
        model["title"] = article.title
        model["article"] = article
        return "article"
    }

    fun Article.render() = RenderedArticle (
            title,
            markdownConverter.invoke(headline),
            markdownConverter.invoke(content),
            author,
            id,
            addedAt.format(DateTimeFormatter.ISO_DATE)
    )
}