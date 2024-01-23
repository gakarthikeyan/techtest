package com.example.techtest.ui.fragments

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
import com.example.domain.model.Products
import com.example.techtest.R
import com.example.techtest.databinding.HomeFragmentLayoutBinding
import com.example.techtest.ui.adapters.home.HomeListAdapter
import com.example.techtest.utility.Constants
import com.example.techtest.viewmodel.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeListAdapter.FishItemClickListener {
    private lateinit var navController: NavController
    private var mView: View? = null
    private lateinit var homeBinding: HomeFragmentLayoutBinding
    private lateinit var homeAdapter: HomeListAdapter
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
        homeBinding.toolbar.title.text = getString(R.string.species)

    }

//    add listener for request and response of api call
    private fun addListeners(){

    //    check network connectivity to request api call
        if(Constants.isNetworkAvailable(requireContext())){
            viewModel.products.observe(viewLifecycleOwner){ state ->
                if(state?.isLoading == true){
                    Constants.showProgressDialog(activity)
                }

                if(state?.error?.isNotBlank() == true){
                    Constants.cancelProgressDialog()
                    Toast.makeText(activity, state.error, Toast.LENGTH_SHORT).show()
                }

                state?.data?.let { data ->
                    Constants.cancelProgressDialog()
                    loadFishes(data)

                }
            }

        }else{
            Toast.makeText(activity, "Internet Not Available", Toast.LENGTH_SHORT).show()
        }


    }
// prepare and setup adapter for fish list
//    private fun loadFishes(fishList: List<FishesItem>){
    private fun loadFishes(fishList: Products){
        homeAdapter = HomeListAdapter(requireActivity(), fishList)
        linearLayoutManager = LinearLayoutManager(activity)
        homeBinding.fishRecyclerView.layoutManager = linearLayoutManager
        homeBinding.fishRecyclerView.adapter = homeAdapter
        homeAdapter.setCastCrewItemClickListener(this)
    }

//    capture item clicked state and pass data to details page
    override fun fishItemClicked(fishName: String, image: String) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(fishName, image)
        navController.navigate(action)

    }
}