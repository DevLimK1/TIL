package com.newlecture.app.entity

class NewlecExam2(private val kor: Int, private val eng: Int, private val math: Int) : Exam {
    override fun total(): Int {
        return kor + eng + math
    }

    override fun vag(): Float {
        return total() / 3.0f
    }

}