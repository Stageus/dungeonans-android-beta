package com.example.dungeonans.Fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.dungeonans.Activity.RegisterActivity
import com.example.dungeonans.R
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class RegisterConfirmFragment : Fragment() {

    private val registerActivity = activity as RegisterActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.register_confirmpage_fragment, container, false)

        // Button
        val nextPageBtn = view.findViewById<Button>(R.id.nextPageBtn)
        val backPageBtn = view.findViewById<ImageButton>(R.id.backPageBtn)

        // EditText
        val nameET = view.findViewById<EditText>(R.id.nameInRegisterET)
        val idET = view.findViewById<EditText>(R.id.idInRegisterET)
        val pwET = view.findViewById<EditText>(R.id.pwInRegisterET)
        val rePwET = view.findViewById<EditText>(R.id.rePwInRegisterET)
        val emailET = view.findViewById<EditText>(R.id.emailInRegisterET)
        val editTextList = arrayListOf<EditText>(nameET, idET, pwET, rePwET, emailET)

        // InputLayout
        val pwIL = view.findViewById<TextInputLayout>(R.id.pwInputLayout)
        val rePwIL = view.findViewById<TextInputLayout>(R.id.rePwInputLayout)
        val emailIL = view.findViewById<TextInputLayout>(R.id.emailInputLayout)

        // domain Spinner
        val domainList = resources.getStringArray(R.array.domain_array)
        val domainSpinner = view.findViewById<Spinner>(R.id.domainSpinner)

        // 도메인 스피너 적용
        domainSpinner?.adapter = ArrayAdapter(registerActivity, android.R.layout.simple_spinner_item, domainList)
        domainSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var doamain = domainSpinner.selectedItem.toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) = Unit
        }

        // state boolean
        var isIdOverlapping = false // 아이디 중복 여부
        var isNameAcceptable = false // 이름 예외처리 여부
        var isIdAcceptable = false // 아이디 예외처리 여부
        var isPwAcceptable = false // 비밀번호 예외처리 여부
        var isRePwAcceptable = false // 비밀번호 재입력 예외처리 여부
        var isEmailAcceptable = false // 이메일 예외처리 여부

        // 예외처리
        for (i in 0 until editTextList.size) {
            editTextList[i].addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) = Unit
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    when (i) {
                        0 -> isNameAcceptable = nameExceptionHandling(nameET) // 이름 예외처리 함수 호출부
                        1 -> isIdAcceptable = idExceptionHandling(idET) // 아이디 예외처리 함수 호출부
                        2 -> pwExceptionHandling(pwET) // 비밀번호 예외처리 함수 호출부
                        3 -> rePwExceptionHandling(rePwET) // 비밀번호 재입력 예외처리 함수 호출부
                        4 -> emailExceptionHandling(emailET) // 이메일 예외처리 함수 호출부
                    }
                }
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit })
        }

        // 다음 페이지 이동
        nextPageBtn.setOnClickListener {
            moveNextPageEvent()
        }

        backPageBtn.setOnClickListener {
            moveBackPageEvent()
        }

        return view
    }

    private fun nameExceptionHandling(nameET: EditText) : Boolean {
        val nameIL = view?.findViewById<TextInputLayout>(R.id.nameInputLayout)
        var isAcceptable = false


        return isAcceptable
    }

    private fun idExceptionHandling(idET: EditText) : Boolean {
        var isAcceptable = false

        val idIL = view?.findViewById<TextInputLayout>(R.id.idInputLayout)

        if (idET.length() < 4) {
            idIL?.error = "4자 이상 입력해주세요."
        }
        else if (!Pattern.matches("^[A-Za-z0-9]*$",idET.text)) {
            idIL?.error = "아이디 형식에 부합하지 않습니다."
        }
        else {
            isAcceptable = true
        }

        return isAcceptable
    }

    private fun pwExceptionHandling(pwET: EditText) {

    }

    private fun rePwExceptionHandling(rePwET: EditText) {

    }

    private fun emailExceptionHandling(emailET: EditText) {

    }

    private fun connectLoginApi()

    private fun moveBackPageEvent() {

    }

    private fun moveNextPageEvent() {

    }



}