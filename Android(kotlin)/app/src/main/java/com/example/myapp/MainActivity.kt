package com.example.myapp

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : Activity() { //Activity 상속을 받음
    override fun onCreate(savedInstanceState: Bundle?) { //Bundle:자료형, ? 붙이면 null을 담을 수 있음
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main) //res 에 있는 것은 R. 찍으면 나온다.
        // 상대경로 res->layout->activity_main.xml

//        var btn1 = Button(this)
//        btn1.setText("Button1")
//        val btn1=Button(this)
//        btn1.text="버튼1"
//        val btn2=Button(this)
//        btn2.text="버튼2"
//
//        val layout1=LinearLayout(this)
//        layout1.addView(btn1)
//        layout1.addView(btn2)

//        this.setContentView(layout1)
    }
}