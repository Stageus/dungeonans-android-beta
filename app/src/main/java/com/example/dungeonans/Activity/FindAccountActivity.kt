package com.example.dungeonans.Activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dungeonans.Fragment.FindIdFragment
import com.example.dungeonans.R

class FindAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.empty_activity_layout)

        this.supportFragmentManager.beginTransaction()
            .replace(R.id.emptyLayout, FindIdFragment())
            .commit()


    }






}