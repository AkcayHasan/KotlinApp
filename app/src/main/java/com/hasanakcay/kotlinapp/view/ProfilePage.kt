package com.hasanakcay.kotlinapp.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.hasanakcay.kotlinapp.R

class ProfilePage : Fragment(R.layout.fragment_profile_page) {

    lateinit var githubButton: Button

    private var github_url : String = "https://github.com/AkcayHasan"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        githubButton = view.findViewById(R.id.githubButton)
        githubButton.setOnClickListener(this::github)
    }

    fun github(view: View) {
        val urlIntent = Intent(Intent.ACTION_VIEW)
        urlIntent.data = Uri.parse(github_url)
        startActivity(urlIntent)
    }
}