package com.example.dungeonans.Fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dungeonans.Activity.UserProfileEditActivity
import com.example.dungeonans.databinding.FragmentProfileEditBinding

class UserProfileEditFragment : Fragment() {

    private lateinit var profileActivity : UserProfileEditActivity

    private var _binding: FragmentProfileEditBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        profileActivity = activity as UserProfileEditActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileEditBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.introduceTv.text = arguments?.getString("introduce")


        binding.backBtn.setOnClickListener { // 뒤로가기
           profileActivity.moveBackEvent()
        }

        binding.profileImgAddTv.setOnClickListener { // 프로필 사진 수정
            //profileActivity.transFragEvent(1)
        }

        binding.addIntroduceTv.setOnClickListener { // 프로필 소개 수정
            profileActivity.transFragEvent(ProfileIntroduceEditFragment())
        }

        binding.stackAddTv.setOnClickListener { // 기술 스택 수정
            //profileActivity.transFragEvent(3)

        }

        binding.linkAddTv.setOnClickListener { // 링크 수정
            profileActivity.transFragEvent(ProfileLinkEditFragment())

        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}