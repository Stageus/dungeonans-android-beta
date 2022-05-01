package com.example.dungeonans.Fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.UiThread
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.dungeonans.Activity.LoginActivity
import com.example.dungeonans.R
import com.raycoarana.codeinputview.CodeInputView
import com.raycoarana.codeinputview.OnCodeCompleteListener
import java.util.*
import kotlin.concurrent.timer


class FindPwFragment : Fragment() {

    private lateinit var loginActivity : LoginActivity
    private lateinit var mCountDownTimer : CountDownTimer
    private var isRunning = false

    override fun onAttach(context: Context) {
        super.onAttach(context)
        loginActivity = activity as LoginActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {
        val view = inflater.inflate(R.layout.findpw_fragment_layout, container, false)

        // button
        val sendCodeBtn = view?.findViewById<Button>(R.id.sendCodeBtn)
        val backPageBtn = view.findViewById<ImageButton>(R.id.backPageBtn)

        //EditText
        val idET = view?.findViewById<EditText>(R.id.findPwIdET)
        val emailET = view?.findViewById<EditText>(R.id.findPwEmailET)

        //codeInput
        var mailCodeInput = view.findViewById<CodeInputView>(R.id.codeInputView)


        //listener
        sendCodeBtn?.setOnClickListener {
            sendCodeEvent(idET, emailET) // 이메일로 인증 코드 전송
        }

        backPageBtn.setOnClickListener {
            moveBackPageEvent()
        }

        mailCodeInput?.addOnCompleteListener {
            setMailCodeView(mailCodeInput)
        }


        return view
    }

    private fun sendCodeEvent(idET : EditText?, emailET: EditText?) {
        val mailCodeLayout = view?.findViewById<LinearLayout>(R.id.codeInputLayout)
        val idString = idET?.text.toString()
        val emailString = emailET?.text.toString()

        if (idString.isEmpty() || emailString.isEmpty()) {
            loginActivity.showToastEvent("아이디 또는 이메일을 입력해주세요.", true)
        }
        else {
            loginActivity.showToastEvent("인증번호가 전송되었습니다.",false)
            mailCodeLayout?.visibility = View.VISIBLE

            if (isRunning) {
                mCountDownTimer.cancel()
            }
            startCountDown()
        }

    }

    fun startCountDown() {
        val timeTV = view?.findViewById<TextView>(R.id.timeTV)
        val mailCodeLayout = view?.findViewById<LinearLayout>(R.id.codeInputLayout)

        isRunning = true

        mCountDownTimer = object : CountDownTimer(180000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(time: Long) {
                val duration = time/1000
                val sec = duration % 60
                val min = duration / 60
                if (sec >= 10) {
                    timeTV?.text = "${min}:${sec}"
                }
                else {
                    timeTV?.text = "${min}:0${sec}"
                }
            }

            override fun onFinish() {
                isRunning = false
                mailCodeLayout?.visibility = View.INVISIBLE
            }
        }
        mCountDownTimer.start()
    }

    private fun moveBackPageEvent() {
        if (isRunning) {
            mCountDownTimer.cancel()
        }
        loginActivity.transFragEvent(0)
    }

    private fun setMailCodeView(mailCodeInput : CodeInputView) {
        if(mailCodeInput.code.toInt() == 123456) {
            loginActivity.transFragEvent(0)
            loginActivity.showToastEvent("이메일이 전송되었습니다.",true)
        }
        else {
            mailCodeInput.setError("인증번호가 올바르지 않습니다.")
        }

        mailCodeInput.setEditable(true)
        mailCodeInput.code = ""
    }

    fun connectLoginApi() { // 인증번호 보내는 api 연결

    }

}