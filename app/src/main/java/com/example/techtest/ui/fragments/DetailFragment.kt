package com.example.techtest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.techtest.R
import com.example.techtest.databinding.DetailFragmentLayoutBinding
import com.example.techtest.utility.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var navController: NavController
    private var mView: View? = null
    private lateinit var detailBinding: DetailFragmentLayoutBinding
//    private lateinit var viewModel: DetailsViewModel
    private var fishName : String = ""
    private var imagePath : String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (mView == null) {
            detailBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.detail_fragment_layout,
                container,
                false
            )

            mView = detailBinding.root
        }
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        addListeners()
    }

//    initialize view model and get argument for fish name and image path
    private fun init(){
//        viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
        navController = findNavController()
        fishName = arguments?.getString("fish_name").toString()
        imagePath = arguments?.getString("image_path").toString()


    }

//    listeners for events & api request
    private fun addListeners(){
        detailBinding.toolbar.backIcon.setOnClickListener{
            navController.navigateUp()
        }

//    check network connectivity to request api call
        if(Constants.isNetworkAvailable(requireContext())){
            requestFishDetails()
        }else{
            Toast.makeText(activity, "Internet Not Available", Toast.LENGTH_SHORT).show()
        }
        

    }

//    observe api response
    private fun requestFishDetails(){
        Constants.showProgressDialog(requireActivity())
        /*viewModel.getFishDetails(fishName).observe(viewLifecycleOwner){ fishDetails ->
            Constants.cancelProgressDialog()

            if(fishDetails!= null){
                bindFishDetails(fishDetails)
            }

        }*/
    }

//    bind fish details into UI
    /*private fun bindFishDetails(fishDetails: ArrayList<FishesItem>){

        try{
            val fish = fishDetails.get(0)
            GlideApp.with(this)
                .load(imagePath)
                .into(detailBinding.image)

            (getString(R.string.calories)+fish.calories).also { detailBinding.tvCalories.text = it }
            (getString(R.string.carbo)+fish.carbohydrate).also { detailBinding.tvCarbo.text = it }
            (getString(R.string.choles)+fish.cholesterol).also { detailBinding.tvCholesterol.text = it }
            (getString(R.string.fat)+fish.fatTotal).also { detailBinding.tvFat.text = it }
            detailBinding.tvFishName.text = fish.speciesName
            detailBinding.toolbar.title.text = fish.speciesName
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                detailBinding.tvManage.text = Html.fromHtml(fish.fisheryManagement, Html.FROM_HTML_MODE_COMPACT)
            }else{
                detailBinding.tvManage.text = Html.fromHtml(fish.fisheryManagement)
            }
        }catch (e: IndexOutOfBoundsException){
            e.printStackTrace()
            Toast.makeText(activity, "Data not available.", Toast.LENGTH_SHORT).show()
            navController.navigateUp()
        }


    }
*/
    // cancel coroutine job if there is any running task
    override fun onDetach() {
//        viewModel.cancelJob()
        super.onDetach()
    }


}