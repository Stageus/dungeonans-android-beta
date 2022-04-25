package com.example.dungeonans.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.dungeonans.Activity.LoginActivity
import com.example.dungeonans.R
import com.raycoarana.codeinputview.CodeInputView
import com.raycoarana.codeinputview.OnCodeCompleteListener


class FindPwFragment : Fragment() {

    private val loginActivity = activity as LoginActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {
        val view = inflater.inflate(R.layout.findpw_fragment_layout, container, false)

        // button
        val sendCodeBtn = view?.findViewById<Button>(R.id.sendCodeBtn)

        //EditText
        val idET = view?.findViewById<EditText>(R.id.findPwIdET)
        val emailET = view?.findViewById<EditText>(R.id.findPwEmailET)

        //codeInput
        var mailCodeInput = view?.findViewById<CodeInputView>(R.id.codeInputView)

        sendCodeBtn?.setOnClickListener {
            sendCodeEvent(idET, emailET) // 이메일로 인증 코드 전송
        }

        mailCodeInput?.addOnCompleteListener(OnCodeCompleteListener {

        })


        return view
    }

    private fun sendCodeEvent(idET : EditText?, emailET: EditText?) {
        val idString = idET?.text.toString()
        val emailString = emailET?.text.toString()

        if (idString.isEmpty() || emailString.isEmpty()) {
            loginActivity.showToastEvent("아이디 또는 이메일을 입력해주세요.", true)
        }
        else {
            connectLoginApi()
        }
    }

    fun connectLoginApi() { // 인증번호 보내는 api 연결

    }


}