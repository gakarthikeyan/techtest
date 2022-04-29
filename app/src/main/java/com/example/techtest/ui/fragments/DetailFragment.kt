package com.example.techtest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.techtest.R
import com.example.techtest.databinding.DetailFragmentLayoutBinding

class DetailFragment : Fragment() {
    lateinit var navController: NavController
    private var mView: View? = null
    lateinit var detailBinding: DetailFragmentLayoutBinding

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
    }

    private fun init(){
        navController = findNavController()

    }


}