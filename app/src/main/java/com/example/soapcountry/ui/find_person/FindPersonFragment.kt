package com.example.soapcountry.ui.find_person

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.soapcountry.databinding.FragmentFindPersonBinding
import com.example.soapcountry.databinding.FragmentTemperatureBinding


class FindPersonFragment : Fragment() {

    private var _binding: FragmentFindPersonBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFindPersonBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}