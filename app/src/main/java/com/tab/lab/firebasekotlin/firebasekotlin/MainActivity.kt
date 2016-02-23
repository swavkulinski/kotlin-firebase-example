package com.tab.lab.firebasekotlin.firebasekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.firebase.client.Firebase
import com.tab.lab.firebasekotlin.firebasekotlin.board.StatusRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Firebase.setAndroidContext(this)
        val statusRepository = StatusRepository()
        statusRepository.loadCurrentWeek()
        statusRepository.loadStatus(0)
    }
}
