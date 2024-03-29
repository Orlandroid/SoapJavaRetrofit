package com.example.soapcountry.ui.numbers;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soapcountry.databinding.FragmentNumbersBinding;
import com.example.soapcountry.util.AlertDialogMessage;
import com.example.soapcountry.util.Util;


public class NumbersFragment extends Fragment {

    private FragmentNumbersBinding binding;
    private NumbersViewModel viewModel;
    private AlertDialogMessage alertDialogMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNumbersBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(NumbersViewModel.class);
        viewModel.context = requireContext();
        setUpUi();
        setUpObservers();
        return binding.getRoot();
    }

    private void setUpUi() {
        binding.root.setOnClickListener(view -> {
            Util.closeKeyboard(requireContext());
        });
        binding.btnConvertToWords.setOnClickListener(view -> {
            Util.hideKeyboard(requireActivity());
            binding.progressWords.setVisibility(View.VISIBLE);
            viewModel.numbersToWords(binding.txtWords.getEditText().getText().toString());
        });
        binding.btnCovertToDollars.setOnClickListener(view -> {
            Util.hideKeyboard(requireActivity());
            if (binding.inputDollars.getEditText().getText().toString().isEmpty()) {
                Util.showToast("Debes ingresar un numero a convertir", requireContext());
                return;
            }
            binding.progressDollars.setVisibility(View.VISIBLE);
            viewModel.numberToDollars(binding.inputDollars.getEditText().getText().toString());
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
            binding.progressWords.setVisibility(View.INVISIBLE);
            binding.progressDollars.setVisibility(View.INVISIBLE);
        });
        viewModel.words().observe(getViewLifecycleOwner(), response -> {
            if (response == null) {
                return;
            }
            binding.progressWords.setVisibility(View.INVISIBLE);
            binding.tvPalabras.setText(response);
        });
        viewModel.dollars().observe(getViewLifecycleOwner(), response -> {
            if (response == null) {
                return;
            }
            binding.progressDollars.setVisibility(View.INVISIBLE);
            binding.tvDollars.setText(response);
        });
        viewModel.errorNetwork().observe(getViewLifecycleOwner(), response -> {
            if (response == null) {
                return;
            }
            alertDialogMessage = new AlertDialogMessage(response);
            alertDialogMessage.show(requireFragmentManager(), "Dialog");
        });
    }
}