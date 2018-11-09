package com.jazzinjars.springboot.repositories

import com.jazzinjars.springboot.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long>
