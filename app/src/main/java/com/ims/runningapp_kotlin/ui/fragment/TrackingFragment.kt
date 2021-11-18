package com.ims.runningapp_kotlin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ims.runningapp_kotlin.R
import com.ims.runningapp_kotlin.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_run.*


class TrackingFragment : Fragment(R.layout.fragment_tracking) {


    private val viewModelFactory : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }



}