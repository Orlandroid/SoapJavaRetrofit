package com.example.soapcountry.ui.country;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.soapcountry.databinding.FragmentCountryBinding;
import com.squareup.picasso.Picasso;


public class CountryFragment extends Fragment {


    private FragmentCountryBinding binding;
    private String countryCode;
    private String countryName;
    private CountryViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCountryBinding.inflate(inflater);
        viewModel = new ViewModelProvider(getActivity()).get(CountryViewModel.class);
        setUpUi();
        setUpObservers();
        return binding.getRoot();
    }

    private void setUpUi() {
        countryCode = CountryFragmentArgs.fromBundle(getArguments()).getCountryCode();
        countryName = CountryFragmentArgs.fromBundle(getArguments()).getCountryName();
        binding.tvPais.setText(countryName);
        viewModel.getCountryFlag(countryCode);
        viewModel.getCapitalCity(countryCode);
        viewModel.getCountryCurrency(countryCode);
        viewModel.getCountryIntPhoneCode(countryCode);
    }

    @SuppressLint("SetTextI18n")
    private void setUpObservers() {
        viewModel.countryFlag().observe(getViewLifecycleOwner(), response -> {
            Toast.makeText(requireContext(), response.getCountryFlagResultUrl(), Toast.LENGTH_SHORT).show();
            Log.w("IMAGE", response.getCountryFlagResultUrl());
            Picasso.get().load(response.getCountryFlagResultUrl()).into(binding.imageView);
        });
        viewModel.capitalCity().observe(getViewLifecycleOwner(), response -> {
            Log.w("CAPITAL", response);
            binding.tvCapital.setText(response);
        });
        viewModel.countryCurrency().observe(getViewLifecycleOwner(), reponse -> {
            binding.tvMoneda.setText(reponse.getsName() + " (" + reponse.getIsoCode() + ")");
        });
        viewModel.countryIntPhoneCode().observe(getViewLifecycleOwner(), response -> {
            binding.tvCodigoTelefono.setText(response);
        });
    }


}