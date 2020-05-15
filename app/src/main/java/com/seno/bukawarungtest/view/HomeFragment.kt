package com.seno.bukawarungtest.view

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.seno.bukawarungtest.R
import com.seno.bukawarungtest.dagger.BaseFragment
import com.seno.bukawarungtest.utils.UiState
import com.seno.bukawarungtest.utils.observe
import com.seno.bukawarungtest.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val viewModel by navGraphViewModels<UserViewModel>(R.id.nav_main) {
        viewModelFactory
    }

    private val homeAdapter by lazy(LazyThreadSafetyMode.NONE) {
        HomeAdapter(::onClick)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.refreshAllUser()

        recycler.adapter = homeAdapter

        swipeRefresh.setOnRefreshListener { viewModel.refreshAllUser() }

        observe(viewModel.getAllUser) {
            homeAdapter.items = it ?: emptyList()
        }
        observe(viewModel.refreshUserState) {
            swipeRefresh.isRefreshing = it == UiState.Loading
        }
    }

    private fun onClick(id: Int) {
        val navigation = HomeFragmentDirections.actionUserFragment(id)
        findNavController().navigate(navigation)
    }
}


