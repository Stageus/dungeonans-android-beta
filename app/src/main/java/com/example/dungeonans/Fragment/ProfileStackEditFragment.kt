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
import com.example.dungeonans.databinding.FragmentEditStackBinding
import com.example.dungeonans.databinding.FragmentLinkEditBinding
import kotlinx.android.synthetic.main.fragment_edit_stack.*

class ProfileStackEditFragment : Fragment() {

    private var _binding: FragmentEditStackBinding? = null
    private val binding get() = _binding!!

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
        _binding = FragmentEditStackBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.backBtn.setOnClickListener {
            //profileActivity.transFragEvent(0)
        }

        binding.addCustomStackBtn.setOnClickListener {  // 커스텀 스택 추가
            addCustomStack()
        }

        val radioBtnId = binding.stackRadioGroup.checkedRadioButtonId
        val radioBtn = binding.stackRadioGroup.findViewById<RadioButton>(radioBtnId)

        binding.confirmStackBtn.isEnabled = radioBtn.isChecked

        //val index: Int = stack_radio_group.indexOfChild(stack_radio_group.findViewById<RadioButton>(stack_radio_group.checkedRadioButtonId))

        binding.stackRadioGroup.setOnCheckedChangeListener { _, checkedId ->
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}