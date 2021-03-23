package com.example.school_cafeteria.Ui

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.school_cafeteria.databinding.FragmentBreakBinding

class Fragment_Break: Fragment() {
    private var _binding: FragmentBreakBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBreakBinding.inflate(inflater, container, false)



        setHasOptionsMenu(true)


        Log.d(ContentValues.TAG, "onCreateView: ")

        return binding.root

    }
}