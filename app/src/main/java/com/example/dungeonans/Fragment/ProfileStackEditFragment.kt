package com.example.dungeonans.Fragment

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.example.dungeonans.Activity.UserProfileEditActivity
import com.example.dungeonans.R
import kotlinx.android.synthetic.main.fragment_edit_stack.*

class ProfileStackEditFragment : Fragment() {

    private lateinit var profileActivity : UserProfileEditActivity
    val btnIdxArrayList = arrayListOf<Int>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        profileActivity = activity as UserProfileEditActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit_stack, container, false)

        back_btn.setOnClickListener {
            profileActivity.transFragEvent(0)
        }

        add_custom_stack_btn.setOnClickListener {  // 커스텀 스택 추가
            addCustomStack()
        }

        val radioBtnId = stack_radio_group.checkedRadioButtonId
        val radioBtn = stack_radio_group.findViewById<RadioButton>(radioBtnId)

        confirm_stack_btn.isEnabled = radioBtn.isChecked

        //val index: Int = stack_radio_group.indexOfChild(stack_radio_group.findViewById<RadioButton>(stack_radio_group.checkedRadioButtonId))

        stack_radio_group.setOnCheckedChangeListener { _, checkedId ->
            Log.d("TAG", "$checkedId")
            if (checkedId in btnIdxArrayList)
                btnIdxArrayList.remove(checkedId)
            else
                btnIdxArrayList.add(checkedId)
        }


        return view
    }

    private fun addCustomStack() {
        AlertDialog.Builder(profileActivity)
            .setView(R.layout.dialog_custom_stack)
            .setCancelable(true)
            .show()
    }

}