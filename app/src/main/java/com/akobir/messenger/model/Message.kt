package com.akobir.messenger.model

data class Message(var profile: Int, var fullname: String, var isOnline: Boolean = false)