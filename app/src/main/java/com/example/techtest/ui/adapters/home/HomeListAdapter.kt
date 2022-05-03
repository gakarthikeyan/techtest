package com.example.techtest.ui.adapters.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.techtest.BuildConfig
import com.example.techtest.R
import com.example.techtest.models.FishesItem
import com.example.techtest.utility.GlideApp

class HomeListAdapter (private val context: FragmentActivity, private val fishList: List<FishesItem>): RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder>() {

    lateinit var mItemClickListener : FishItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        return HomeListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fishes_custom_layout, parent, false)
        )
    }
// bind data into UI
    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        try {
            val images = fishList.get(position).speciesIllustrationPhoto
            val title = fishList.get(position).speciesName
            val fishName = fishList.get(position).path.replace("/profiles/", "")
            if(images!==null){
                //            load fish image
                GlideApp.with(context)
                    .load(images.src)
                    .into(holder.fishImage)
            }


            holder.fishTitle.text = title

            holder.fishImage.setOnClickListener{
                mItemClickListener.fishItemClicked(fishName, images.src)
            }

        }catch (e: Exception){
            if(BuildConfig.DEBUG){
                e.printStackTrace()
            }

        }

    }

    override fun getItemCount(): Int {
        return fishList.size
    }
//prepare view holder to bind data into UI
    class HomeListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fishImage = view.findViewById<ImageView>(R.id.image)
        val fishTitle = view.findViewById<TextView>(R.id.tv_fish_name)
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