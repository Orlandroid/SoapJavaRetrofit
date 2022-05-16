package com.example.soapcountry;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soapcountry.databinding.FragmentCountryBinding;


public class CountryFragment extends Fragment {


    private FragmentCountryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentCountryBinding.inflate(inflater);
        return binding.getRoot();
    }

}