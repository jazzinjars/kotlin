package com.jazzinjars.springboot.model

data class RenderedArticle (
        val title: String,
        val headline: String,
        val content: String,
        val author: User,
        val id: Long?,
        val addedAt: String
)
