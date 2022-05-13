package com.example.dungeonans.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.dungeonans.R
import kotlinx.android.synthetic.main.activity_search_result.*

class SearchProfileActivity : AppCompatActivity(),
    SearchView.OnQueryTextListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        setSupportActionBar(top_tool_bar)


    }






    override fun onQueryTextSubmit(query: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        TODO("Not yet implemented")
    }


}