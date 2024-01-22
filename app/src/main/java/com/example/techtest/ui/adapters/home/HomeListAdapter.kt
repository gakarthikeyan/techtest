package com.example.techtest.ui.adapters.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.products.Products
import com.example.techtest.BuildConfig
import com.example.techtest.R
import com.example.techtest.utility.GlideApp

class HomeListAdapter (private val context: FragmentActivity, private val fishList: Products): RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder>() {

    private lateinit var mItemClickListener : FishItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        return HomeListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fishes_custom_layout, parent, false)
        )
    }
// bind data into UI
    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        try {
            val images = fishList.products[position].images
            val title = fishList.products[position].title
            val fishName = fishList.products[position].brand
            GlideApp.with(context)
                .load(images[0])
                .into(holder.fishImage)


            holder.fishTitle.text = title

            holder.fishImage.setOnClickListener{
                mItemClickListener.fishItemClicked(fishName, images[0])
            }

        }catch (e: Exception){
            if(BuildConfig.DEBUG){
                e.printStackTrace()
            }

        }

    }

    override fun getItemCount(): Int {
        return fishList.products.size
    }
//prepare view holder to bind data into UI
    class HomeListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fishImage: ImageView = view.findViewById(R.id.image)
        val fishTitle: TextView = view.findViewById(R.id.tv_fish_name)
    }

//    pass click listener instance from the client page
    fun setCastCrewItemClickListener(listener: FishItemClickListener) {
        mItemClickListener = listener
    }
// interface to monitor item clicked state
    interface FishItemClickListener{
        fun fishItemClicked(fishName: String, image: String)
    }
}