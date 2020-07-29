package com.newlecture.app.entity

object Program {
    fun add(x: Int, y: Int): Int {
        return x + y
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val result = add(3, 4)
        println(result)
    }
}