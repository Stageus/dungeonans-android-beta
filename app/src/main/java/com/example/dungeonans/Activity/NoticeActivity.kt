package com.example.dungeonans.Activity

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.example.dungeonans.R
import androidx.appcompat.widget.Toolbar

class NoticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.noticepage_activity)
        connectToolbar()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    fun connectToolbar() {
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        actionBar!!.setDisplayShowCustomEnabled(true)
        actionBar!!.setDisplayShowTitleEnabled(false)
        actionBar!!.setDisplayHomeAsUpEnabled(false)

        //좌측 버튼 활성화 => 로고로 바꿀것.
        actionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}