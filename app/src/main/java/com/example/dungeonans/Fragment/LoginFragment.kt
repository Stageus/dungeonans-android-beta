package com.example.dungeonans.Fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.dungeonans.Activity.LoginActivity
import com.example.dungeonans.Activity.RegisterActivity
import com.example.dungeonans.R

class LoginFragment : Fragment() {

    private lateinit var loginActivity : LoginActivity


    override fun onAttach(context: Context) {
        super.onAttach(context)

        loginActivity = activity as LoginActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.login_activity_layout, container, false)

        // Button
        val loginBtn = view?.findViewById<Button>(R.id.loginBtn)
        val registerBtn = view?.findViewById<Button>(R.id.registerBtn)
        val findAccountBtn = view?.findViewById<Button>(R.id.findAccountBtn)

        // Edit Text
        val loginIdET = view?.findViewById<EditText>(R.id.idET)?.text.toString()
        val loginPwET = view?.findViewById<EditText>(R.id.pwET)?.text.toString()


        // 로그인 버튼 클릭
        loginBtn?.setOnClickListener {
            pushLoginEvent(loginIdET, loginPwET) // 로그인
        }

        registerBtn?.setOnClickListener {
            loginActivity.registerEvent() // 회원가입
        }

        findAccountBtn?.setOnClickListener {
            findExistingAccountEvent() // 계정찾기 다이어로그
        }

    return view
    }


    private fun pushLoginEvent(id : String, pw : String) {
        if (id.isEmpty() || pw.isEmpty()) { // 로그인 아이디, 비밀번호 공백 시
            loginActivity.showToastEvent("아이디 또는 비밀번호를 다시 확인해주세요." , true)
        }
        else {
            connectLoginApi(id, pw) // login api 연결
        }
    }

    fun connectLoginApi(id : String, pw : String) {
        loginActivity.loginEvent() // 로그인

    }

    private fun findExistingAccountEvent() {
        AlertDialog.Builder(loginActivity)
            .setView(R.layout.findaccount_dialog_layout)
            .setCancelable(true)
            .show()
            .also { alertDialog ->

                if(alertDialog == null) {
                    return@also
                }

                val findIdBtn = alertDialog.findViewById<Button>(R.id.findIdBtn)
                val findPwBtn = alertDialog.findViewById<Button>(R.id.findPwBtn)

                findIdBtn?.setOnClickListener{ // id 찾기
                    alertDialog.dismiss()
                    loginActivity.transFragEvent(1) // findIdFrag 전환
                }

                findPwBtn?.setOnClickListener {  // pw 찾기
                    alertDialog.dismiss()
                    loginActivity.transFragEvent(2) // findPwFrag 전환
                }
            }
    }
}
