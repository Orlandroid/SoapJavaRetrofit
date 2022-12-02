package com.example.soapcountry.ui.country;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.soapcountry.R;
import com.example.soapcountry.databinding.FragmentCountryBinding;
import com.example.soapcountry.util.AlertDialogMessage;


public class CountryFragment extends Fragment implements AlertDialogMessage.ClickOnDialog {


    private FragmentCountryBinding binding;
    private String countryCode;
    private String countryName;
    private CountryViewModel viewModel;
    private AlertDialogMessage alertDialogMessage;

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
        binding.informationCard.setBackgroundResource(R.drawable.background_card);
        countryCode = CountryFragmentArgs.fromBundle(getArguments()).getCountryCode();
        countryName = CountryFragmentArgs.fromBundle(getArguments()).getCountryName();
        showSkeletons();
        binding.toolbarLayout.backTextToolbar.setText("Atrás");
        binding.toolbarLayout.backIconToolbar.setOnClickListener(view -> {
            Navigation.findNavController(getView()).popBackStack();
        });
        binding.tvPais.setText(countryName);
        viewModel.getCountryFlag(countryCode);
        viewModel.getCapitalCity(countryCode);
        viewModel.getCountryCurrency(countryCode);
        viewModel.getCountryIntPhoneCode(countryCode);
    }

    private void showSkeletons() {
        binding.skeletonPais.showSkeleton();
        binding.skeletonCapital.showSkeleton();
        binding.skeletonMoneda.showSkeleton();
        binding.skeletonCodigoTelefono.showSkeleton();
        binding.skeletonImage.showSkeleton();
    }

    @SuppressLint("SetTextI18n")
    private void setUpObservers() {
        viewModel.countryFlag().observe(getViewLifecycleOwner(), response -> {
            if (response == null) {
                return;
            }
            binding.skeletonImage.showOriginal();
            Glide.with(requireContext()).load(response.getCountryFlagResultUrl()).transition(DrawableTransitionOptions.withCrossFade()).placeholder(R.drawable.loading_animation).into(binding.imageView);
        });
        viewModel.capitalCity().observe(getViewLifecycleOwner(), response -> {
            if (response == null) {
                return;
            }
            binding.tvCapital.setText(response);
            binding.skeletonPais.showOriginal();
            binding.skeletonCapital.showOriginal();
        });
        viewModel.countryCurrency().observe(getViewLifecycleOwner(), response -> {
            if (response == null) {
                return;
            }
            binding.tvMoneda.setText(response.getsName() + " (" + response.getIsoCode() + ")");
            binding.skeletonMoneda.showOriginal();
        });
        viewModel.countryIntPhoneCode().observe(getViewLifecycleOwner(), response -> {
            if (response == null) {
                return;
            }
            binding.tvCodigoTelefono.setText(response);
            binding.skeletonCodigoTelefono.showOriginal();
        });
        viewModel.msjError().observe(getViewLifecycleOwner(), respose -> {
            if (respose == null) {
                return;
            }
            alertDialogMessage = new AlertDialogMessage(respose, this);
            alertDialogMessage.show(requireFragmentManager(), "Dialog");
        });
    }


    @Override
    public void clickOnAcept() {
        Navigation.findNavController(getView()).popBackStack();
    }

}