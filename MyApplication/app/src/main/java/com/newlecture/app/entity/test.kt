package com.newlecture.app.entity

object test {
    @JvmStatic
    fun main(args: Array<String>) {
        val x = 0
        when (x) {
            1 -> println("x=1")
            2 -> println("x=2")
            else -> println("x is neither 1 nore 2")
        }
    }
}