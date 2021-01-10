package com.hasanakcay.kotlinapp.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hasanakcay.kotlinapp.R

class DetailPage : Fragment(R.layout.fragment_detail_page) {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigationView = view.findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(this::onBottomNavigationItemSelected)
    }

     fun onBottomNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.albumsPage){
            activity?.let {
                val action = DetailPageDirections.actionDetailPageToAlbumsPage()
                Navigation.findNavController(it,R.id.fragment).navigate(action)
            }
        }else if (item.itemId == R.id.profilePage){
            activity?.let {
                val action = DetailPageDirections.actionDetailPageToProfilePage()
                Navigation.findNavController(it,R.id.fragment).navigate(action)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}