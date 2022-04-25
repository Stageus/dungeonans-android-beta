package com.example.dungeonans.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.dungeonans.Activity.LoginActivity
import com.example.dungeonans.R

class FindIdFragment : Fragment() {

    private val loginActivity = activity as LoginActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.findpw_fragment_layout, container, false)

        // Edit Text
        val nameET = view?.findViewById<EditText>(R.id.findIdNameET)
        val emailET = view?.findViewById<EditText>(R.id.findIdEmailET)

        // button
        val backPageBtn = view?.findViewById<ImageButton>(R.id.)
        val findIdBtn = view?.findViewById<Button>(R.id.findIdBtn)

        findIdBtn?.setOnClickListener {
            findIdEvent(nameET, emailET)
        }



        return view
    }

    private fun findIdEvent(nameET: EditText?, emailET: EditText?) {
        val nameString = nameET?.text.toString()
        val emailString = emailET?.text.toString()


    }
}