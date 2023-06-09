package com.arstagaev.testkmm10

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform