package com.example.androidmvvmsample.views

import androidx.fragment.app.viewModels
import com.example.androidmvvmsample.R
import com.example.androidmvvmsample.adapter.HomeRecyclerAdapter
import com.example.androidmvvmsample.common.BaseFragment
import com.example.androidmvvmsample.common.HomeParameter
import com.example.androidmvvmsample.common.observe
import com.example.androidmvvmsample.databinding.FragmentHomeBinding
import com.example.androidmvvmsample.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_home

    val viewModel by viewModels<HomeViewModel>()
    lateinit var adapter : HomeRecyclerAdapter

    val parameter: HomeParameter? by lazy {
        getBundle()
    }


    override fun setUpView() {
        val adapter = HomeRecyclerAdapter()
        binding.recyclerView.adapter = adapter
    }

    override fun setUpObserve() {
        observe(viewModel.kakaoImage) { list ->
//            adapter.submitData()
        }
    }

    private fun getBundle(): HomeParameter? {
        return arguments?.getParcelable("key")
    }

}