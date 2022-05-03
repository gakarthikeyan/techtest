package com.example.techtest.ui.fragments

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.techtest.R
import com.example.techtest.databinding.HomeFragmentLayoutBinding
import com.example.techtest.models.FishesItem
import com.example.techtest.ui.adapters.home.HomeListAdapter
import com.example.techtest.utility.Constants
import com.example.techtest.viewmodel.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    lateinit var navController: NavController
    private var mView: View? = null
    lateinit var homeBinding: HomeFragmentLayoutBinding
    var fishesList: ArrayList<FishesItem> = arrayListOf()
    lateinit var homeAdapter: HomeListAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (mView == null) {
            homeBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.home_fragment_layout,
                container,
                false
            )

            mView = homeBinding.root
        }
        return mView
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        addListeners()
    }

    private fun init(){
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        navController = findNavController()
        homeBinding.toolbar.backIcon.visibility = GONE
        homeBinding.toolbar.title.text = "Species"

    }

    private fun addListeners(){
        Constants.showProgressDialog(activity)
        viewModel.getAllFishes().observe(viewLifecycleOwner){ allFishes ->
            Constants.cancelProgressDialog()

            if(allFishes != null){
                fishesList.clear()
                fishesList = allFishes
                loadFishes()

            }else{
                Toast.makeText(activity, "Data not available.", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun loadFishes(){
        homeAdapter = HomeListAdapter(requireActivity(), fishesList)
        linearLayoutManager = LinearLayoutManager(activity)
        homeBinding.fishRecyclerView.layoutManager = linearLayoutManager
        homeBinding.fishRecyclerView.adapter = homeAdapter
    }
}