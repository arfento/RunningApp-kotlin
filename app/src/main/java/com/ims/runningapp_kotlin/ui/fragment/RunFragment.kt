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
import com.ims.runningapp_kotlin.ui.viewmodel.StatisticsViewModel
import kotlinx.android.synthetic.main.fragment_run.*


class RunFragment : Fragment() {

    private val viewModel : StatisticsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        fab.setOnClickListener {
            findNavController().navigate(R.id.action_runFragment_to_trackingFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_run, container, false)
    }

}