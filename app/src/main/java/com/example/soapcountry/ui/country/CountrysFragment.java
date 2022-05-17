package com.example.soapcountry.ui.country;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soapcountry.databinding.FragmentCountrysBinding;


public class CountrysFragment extends Fragment {

    private FragmentCountrysBinding binding;
    private CountryViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCountrysBinding.inflate(inflater);
        viewModel = new ViewModelProvider(getActivity()).get(CountryViewModel.class);
        setUpUi();
        return binding.getRoot();
    }

    private void setUpUi() {
        viewModel.getCountrList();
        binding.textView2.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(CountrysFragmentDirections.actionCountrysFragmentToCountryFragment());
        });
    }
}