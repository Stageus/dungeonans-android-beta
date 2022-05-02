package com.example.dungeonans.Activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Adapter
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dungeonans.BlogData
import com.example.dungeonans.R
import com.example.dungeonans.Utils.Constants.TAG
import com.example.dungeonans.recylcerview.BlogGridViewRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_search_result.*

class SearchResultActivity: AppCompatActivity() {

    // 데이터
    var photoList = ArrayList<BlogData>()
    // 어뎁터
    private lateinit var blogGridRecyclerViewAdapter: BlogGridViewRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        Log.d(TAG, "searchResultActivity" )

        val bundle = intent.getBundleExtra("array_bundle")
        val searchTerm = intent.getStringExtra("search_term")

        photoList = bundle?.getSerializable("blog_array_list") as ArrayList<BlogData>

        Log.d(TAG, "searchTerm : $searchTerm, photoList.count(): ${photoList.count()}" )

        this.blogGridRecyclerViewAdapter = BlogGridViewRecyclerViewAdapter()
        this.blogGridRecyclerViewAdapter.submitList(photoList)

        search_recycler_view.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        search_recycler_view.adapter = this.blogGridRecyclerViewAdapter
    }

}