package com.seno.bukawarungtest.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import coil.api.load
import com.seno.bukawarungtest.R
import com.seno.bukawarungtest.dagger.BaseFragment
import kotlinx.android.synthetic.main.fragment_user.*


class ProfileFragment: BaseFragment(R.layout.fragment_user) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        avatarImage.isVisible = false
        backgroundImage.load(R.drawable.picture_dummy)
        name.text = "Sebastian Seno"
        emailText.text = "seno.sebastian@gmail.com"
        jobText.isVisible = true
        jobText.text = "Android Developer"
        deepLink.isVisible = true

        igButton.setOnClickListener {
            val uri: Uri =
                Uri.parse("http://www.instagram.com/sebastiansenow")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        linkedInButton.setOnClickListener {
            val uri: Uri =
                Uri.parse("http://www.linkedin.com/in/sebastianseno/")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        githubButton.setOnClickListener {
            val uri: Uri =
                Uri.parse("https://github.com/sebastianseno")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}