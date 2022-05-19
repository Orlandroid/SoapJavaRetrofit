package com.example.soapcountry.ui.numbers;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soapcountry.databinding.FragmentNumbersBinding;
import com.example.soapcountry.util.Util;


public class NumbersFragment extends Fragment {

    private FragmentNumbersBinding binding;
    private NumbersViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNumbersBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(NumbersViewModel.class);
        setUpUi();
        setUpObservers();
        return binding.getRoot();
    }

    private void setUpUi() {
        binding.root.setOnClickListener(view -> {
            Util.closeKeyboard(requireContext());
        });
        binding.btnConvertToWords.setOnClickListener(view -> {
            binding.progressBar2.setVisibility(View.VISIBLE);
            viewModel.numbersToWords(binding.txtWords.getEditText().getText().toString());
        });
        binding.toolbarLayout.backTextToolbar.setText("Atrás");
        binding.toolbarLayout.backIconToolbar.setOnClickListener(view -> {
            Navigation.findNavController(getView()).popBackStack();
        });
    }


    private void setUpObservers() {
        viewModel.msjError().observe(getViewLifecycleOwner(), respose -> {
            if (respose == null) {
                return;
            }
            binding.progressBar2.setVisibility(View.VISIBLE);
        });
        viewModel.words().observe(getViewLifecycleOwner(), response -> {
            if (response == null) {
                return;
            }
            binding.progressBar2.setVisibility(View.INVISIBLE);
            binding.tvPalabras.setText(response);
        });
    }
}