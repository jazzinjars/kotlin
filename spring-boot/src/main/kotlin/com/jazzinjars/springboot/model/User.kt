package com.jazzinjars.springboot.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class User (
       @Id val login: String,
       val firstname: String,
       val lastname: String,
       val description: String? = null
)