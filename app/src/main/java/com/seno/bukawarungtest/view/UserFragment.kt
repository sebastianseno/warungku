package com.seno.bukawarungtest.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import coil.api.load

import com.seno.bukawarungtest.R
import com.seno.bukawarungtest.dagger.BaseFragment
import com.seno.bukawarungtest.utils.observe
import com.seno.bukawarungtest.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : BaseFragment(R.layout.fragment_user) {

    private val viewModel by navGraphViewModels<UserViewModel>(R.id.nav_main) {
        viewModelFactory
    }

    private val args by navArgs<UserFragmentArgs>()

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setUserId(args.userId)

        observe(viewModel.getUserbyId){
            avatarImage.load(it?.avatar)
            name.text = "${it?.firstName} ${it?.lastName}"
            emailText.text = it?.email
        }
    }
}
