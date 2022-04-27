package com.example.dungeonans.Activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.AttributeSet
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.dungeonans.Fragment.FindIdFragment
import com.example.dungeonans.Fragment.FindPwFragment
import com.example.dungeonans.Fragment.LoginFragment
import com.example.dungeonans.R
import java.util.*
import kotlin.math.roundToInt

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.empty_activity_layout)

        supportFragmentManager.beginTransaction().replace(R.id.emptyLayout, LoginFragment())
            .commit()
    }

    fun loginEvent() {
        val loginIntent = Intent(this, MainActivity::class.java) // 회원가입 페이지로 전환
        startActivity(loginIntent)

    }

    fun registerEvent() {
        val registerIntent = Intent(this, RegisterActivity::class.java) // 회원가입 페이지로 전환
        startActivity(registerIntent)
    }

    fun transFragEvent(transNum : Int) {
        val transaction = this.supportFragmentManager.beginTransaction()
        val loginFrag = LoginFragment()
        val findIdFrag = FindIdFragment()
        val findPwFrag = FindPwFragment()

        when(transNum) {
            0 -> transaction.replace(R.id.emptyLayout, loginFrag)
            1 -> transaction.replace(R.id.emptyLayout, findIdFrag)
            2 -> transaction.replace(R.id.emptyLayout, findPwFrag)
        }
        transaction.commit()
    }

    fun showToastEvent(text : String, isShort : Boolean) {
        if (isShort) {
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        }
    }


}