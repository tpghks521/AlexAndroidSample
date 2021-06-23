package com.example.androidmvvmsample.views

import androidx.fragment.app.viewModels
import com.example.androidmvvmsample.R
import com.example.androidmvvmsample.common.BaseFragment
import com.example.androidmvvmsample.common.MainParameter
import com.example.androidmvvmsample.databinding.FragmentMainBinding
import com.example.androidmvvmsample.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>() {

    val viewModel by viewModels<MainViewModel>()

    val parameter: MainParameter? by lazy {
        getBundle()
    }

    override fun setUpView() {
        TODO("Not yet implemented")
    }

    override fun setUpObserve() {
        TODO("Not yet implemented")
    }

    override val layoutRes: Int
        get() = R.layout.fragment_main

    private fun getBundle(): MainParameter? {
        return arguments?.getParcelable("key")
    }

}