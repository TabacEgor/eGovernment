package com.tabac.egovernment.model.dto

data class UserDTO(
    val login: String,
    val firstName: String,
    val lastName: String,
    val token: String
)
