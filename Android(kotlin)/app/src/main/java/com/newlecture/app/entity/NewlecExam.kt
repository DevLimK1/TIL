package com.newlecture.app.entity

class NewlecExam : Exam {
    private val kor = 0
    private val eng = 0
    private val math = 0
    override fun total(): Int {
        return kor + eng + math
    }

    override fun vag(): Float {
        return ((kor + eng + math) / 3.0).toFloat()
    }
}