package com.example.dungeonans.Activity

import android.os.Bundle
import android.view.Menu
<<<<<<< HEAD
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
=======
>>>>>>> ba5ae12efaa18f00244c1b74ff5e37f507bd55e4
import androidx.appcompat.app.AppCompatActivity
import com.example.dungeonans.R
import androidx.appcompat.widget.Toolbar

class NoticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.noticepage_activity)
<<<<<<< HEAD

        var backBtn : ImageView = findViewById(R.id.backBtn)
        backBtn.setOnClickListener{
            finish()
        }

        renderUi()
=======
        connectToolbar()
>>>>>>> ba5ae12efaa18f00244c1b74ff5e37f507bd55e4
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

<<<<<<< HEAD
    private fun renderUi() {
        var noticePageLayout : LinearLayout = findViewById(R.id.noticePageLayout)

        for (index in 0 until 10) {
            var noticeCardView = layoutInflater.inflate(R.layout.notice_cardview,null)
            noticePageLayout.addView(noticeCardView)
        }
=======
    fun connectToolbar() {
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        actionBar!!.setDisplayShowCustomEnabled(true)
        actionBar!!.setDisplayShowTitleEnabled(false)
        actionBar!!.setDisplayHomeAsUpEnabled(false)

        //좌측 버튼 활성화 => 로고로 바꿀것.
        actionBar!!.setDisplayHomeAsUpEnabled(true)
>>>>>>> ba5ae12efaa18f00244c1b74ff5e37f507bd55e4
    }
}