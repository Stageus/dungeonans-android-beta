package com.example.dungeonans.Fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dungeonans.R
import kotlinx.android.synthetic.main.fragment_edit_introduce.*
import kotlinx.android.synthetic.main.fragment_profile_edit.*

class ProfileIntroduceEditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit_introduce, container, false)

        introduce_ET.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                confirm_introduce_btn.isEnabled = introduce_ET.length() > 0
            }

            override fun afterTextChanged(p0: Editable?) = Unit
        })

        confirm_introduce_btn.setOnClickListener {
            // 변경된 상태 메세지 서버에 보내주기
            introduce_tv.text = introduce_ET.text
        }

        return view
    }
}