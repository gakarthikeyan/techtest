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

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        try {
            val images = fishList.get(position).speciesIllustrationPhoto
            val title = fishList.get(position).speciesName
            if(images!==null){
                //            load fish image 1
                /*GlideApp.with(context)
                    .load(images.get(0).src)
                    .into(holder.fishImage1)*/
                //            load fish image 2
               /* GlideApp.with(context)
                    .load(images.get(1).src)
                    .into(holder.fishImage2)*/

                //            load fish image 3
                GlideApp.with(context)
                    .load(images.src)
                    .into(holder.fishImage3)
            }


            holder.fishTitle.text = title

        }catch (e: Exception){
            if(BuildConfig.DEBUG){
                e.printStackTrace()
            }

        }

    }

    override fun getItemCount(): Int {
        return fishList.size
    }

    class HomeListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fishImage1 = view.findViewById<ImageView>(R.id.image1)
        val fishImage2 = view.findViewById<ImageView>(R.id.image2)
        val fishImage3 = view.findViewById<ImageView>(R.id.image3)
        val fishTitle = view.findViewById<TextView>(R.id.tv_fish_name)
    }

    fun setCastCrewItemClickListener(listener: FishItemClickListener) {
        mItemClickListener = listener
    }

    interface FishItemClickListener{
        fun fishItemClicked(position: Int)
    }
}