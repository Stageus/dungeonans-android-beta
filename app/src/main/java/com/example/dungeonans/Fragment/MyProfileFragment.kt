package com.example.dungeonans.Fragment

import GridSpacingItemDecoration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dungeonans.Adapter.BlogCardViewAdapter
import com.example.dungeonans.DataClass.BlogData
import com.example.dungeonans.R


class MyProfileFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.myprofilepage_fragment,container,false)

        var settingBtn = view.findViewById<ImageButton>(R.id.settingBtn)
        settingBtn.setOnClickListener{
            val bottomDrawer = BottomSheetFragment()
            bottomDrawer.show(parentFragmentManager,BottomSheetFragment.TAG)
        }

        var instaBtn = view.findViewById<Button>(R.id.instaBtn)
        instaBtn.setOnClickListener{
//            Uri uri = Uri.parse("http://instagram.com/_u/xxx");
//            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
//
//            likeIng.setPackage("com.instagram.android");
//
//            try {
//                startActivity(likeIng);
//            } catch (ActivityNotFoundException e) {
//                startActivity(new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("http://instagram.com/xxx")));
//            }
        }
        
        renderUi(view)
        return view
    }

    private fun renderUi(view: View) {
        var recyclerView : RecyclerView = view.findViewById(R.id.profilePageRecyclerView)
        var data : MutableList<BlogData> = setData()
        var adapter = BlogCardViewAdapter()

        adapter.listData = data
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.addItemDecoration(GridSpacingItemDecoration(2,60,false))
    }

    private fun setData() : MutableList<BlogData> {
        var data : MutableList<BlogData>  = mutableListOf()
        for (index in 0 until 4) {
            var cardViewTitle = "$index"
            var cardViewBody = "김주영 진짜 사랑해 김주영 진짜 사랑해 김주영 진짜 사랑해 김주영 진짜 사랑해 김주영 진짜 사랑해 김주영 진짜 사랑해 김주영 진짜 사랑해 김주영 진짜 사랑해"
            var cardViewWriter = "$index 번째 작성자"
            var cardViewProfile = R.drawable.profile_base_icon
            var listData = BlogData(cardViewTitle,cardViewBody,cardViewWriter,cardViewProfile)
            data.add(listData)
        }
        return data
    }

// 인스타 키기
//
}
