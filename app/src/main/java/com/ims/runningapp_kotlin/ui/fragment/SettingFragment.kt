package com.ims.runningapp_kotlin.ui.fragment

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.ims.runningapp_kotlin.R
import com.ims.runningapp_kotlin.utilities.Constants.KEY_NAME
import com.ims.runningapp_kotlin.utilities.Constants.KEY_WEIGHT
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_setting.*
import javax.inject.Inject


class SettingFragment : Fragment(R.layout.fragment_setting) {

    @Inject
    lateinit var sharedPreferences : SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadFieldssFromSharedPref()
        btnApplyChanges.setOnClickListener{
            val success = applyChangesToSharedPref()
            if (success){
                Snackbar.make(view, "Saved Changes", Snackbar.LENGTH_LONG).show()
            }else{
                Snackbar.make(view, "Please fill out all the filed", Snackbar.LENGTH_LONG).show()
            }
        }
    }



    private fun loadFieldssFromSharedPref(){
        val name = sharedPreferences.getString(KEY_NAME, "")
        val weight = sharedPreferences.getFloat(KEY_WEIGHT, 80f)
        etName.setText(name)
        etWeight.setText(weight.toString())
    }
    
    private fun applyChangesToSharedPref() : Boolean {
        val nameText = etName.text.toString()
        val weightText = etWeight.text.toString()
        if (nameText.isEmpty() || weightText.isEmpty()){
            return false
        }
        sharedPreferences.edit()
            .putString(KEY_NAME, nameText)
            .putFloat(KEY_WEIGHT, weightText.toFloat())
            .apply()
        val toolbarText = "Let's go $nameText"
        requireActivity().tvToolbarTitle.text = toolbarText
        return true
    }
}