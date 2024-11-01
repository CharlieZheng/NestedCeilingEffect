package com.tory.nestedceiling.app.page

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.tory.nestedceiling.app.views.ModuleStaggerItemModel
import com.tory.nestedceiling.app.views.ModuleStaggerItemView
import com.tory.module_adapter.base.ItemSpace
import com.tory.module_adapter.base.NormalModuleAdapter
import com.tory.nestedceiling.app.utils.dp
import com.tory.nestedceiling.widget.NestedChildRecyclerView

class StaggeredFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val recyclerView = NestedChildRecyclerView(requireContext())

        val listAdapter = NormalModuleAdapter()
        listAdapter.register (gridSize = 2, itemSpace = ItemSpace(spaceH = 10.dp(), spaceV = 8.dp(), edgeH = 8.dp())) {
            ModuleStaggerItemView(it.context)
        }
        recyclerView.adapter = listAdapter
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)

        listAdapter.setItems(MutableList(200) {
            ModuleStaggerItemModel()
        })

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                Log.d("NestedCeilingEffect", "onScrollStateChanged child newState: $newState")
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                //Log.d("NestedCeilingEffect", "onScrolled child dy: $dy")
            }

        })

        return recyclerView
    }

}
