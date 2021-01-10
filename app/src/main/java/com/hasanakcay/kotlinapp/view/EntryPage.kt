package com.hasanakcay.kotlinapp.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.Navigation
import com.hasanakcay.kotlinapp.R

class EntryPage : Fragment(R.layout.fragment_entry_page) {
    lateinit var loginButton: Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginButton = view.findViewById(R.id.loginButton)
        loginButton.setOnClickListener(this::login)
    }

    fun login(view: View) {
        val action = EntryPageDirections.actionEntryPageToDetailPage()
        Navigation.findNavController(view).navigate(action)
    }


}