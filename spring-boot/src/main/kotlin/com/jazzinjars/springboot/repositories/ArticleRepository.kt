package com.jazzinjars.springboot.repositories

import com.jazzinjars.springboot.model.Article
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {
    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}