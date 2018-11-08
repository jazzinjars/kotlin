package com.jazzinjars.springboot.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Article(
        val title: String,
        val headline: String,
        val content: String,
        val addedAt: LocalDateTime = LocalDateTime.now(),
        @Id @GeneratedValue val id: Long? = null,
        @ManyToOne @JoinColumn val author: User
)