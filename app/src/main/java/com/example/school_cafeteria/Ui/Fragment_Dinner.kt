package com.example.school_cafeteria.Ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.school_cafeteria.databinding.FragmentDinnerBinding

class Fragment_Dinner : Fragment() {
    private var _binding: FragmentDinnerBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDinnerBinding.inflate(inflater, container, false)







        return binding.root

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}