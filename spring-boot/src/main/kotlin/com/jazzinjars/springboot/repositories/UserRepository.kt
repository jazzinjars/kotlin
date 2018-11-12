package com.jazzinjars.springboot.repositories

import com.jazzinjars.springboot.model.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository: CrudRepository<User, Long> {
    fun findById(login: String): Optional<User>
}
