package com.example.androidmvvmsample.views

import androidx.fragment.app.viewModels
import com.example.androidmvvmsample.R
import com.example.androidmvvmsample.common.BaseFragment
import com.example.androidmvvmsample.databinding.FragmentHomeBinding
import com.example.androidmvvmsample.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {


    val viewModel by viewModels<HomeViewModel>()


    override fun setUpView() {
        TODO("Not yet implemented")
    }

    override fun setUpObserve() {
        TODO("Not yet implemented")
    }

    override val layoutRes: Int
        get() = R.layout.fragment_home

}