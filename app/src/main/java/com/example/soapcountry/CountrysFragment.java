package com.example.soapcountry;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soapcountry.databinding.FragmentCountrysBinding;


public class CountrysFragment extends Fragment {

    private FragmentCountrysBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCountrysBinding.inflate(inflater);
        setUpUi();
        return binding.getRoot();
    }

    private void setUpUi() {
        binding.textView2.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(CountrysFragmentDirections.actionCountrysFragmentToCountryFragment());
        });
    }
}