package com.example.soapcountry.ui.country;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.soapcountry.R;
import com.example.soapcountry.databinding.FragmentCountrysBinding;
import com.example.soapcountry.model.response.listcountry.CountryCodeAndName;
import com.example.soapcountry.ui.country.adapters.CountryAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CountrysFragment extends Fragment implements SearchView.OnQueryTextListener{

    private FragmentCountrysBinding binding;
    private CountryViewModel viewModel;
    private CountryAdapter countryAdapter;
    List<CountryCodeAndName> countryList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCountrysBinding.inflate(inflater);
        viewModel = new ViewModelProvider(getActivity()).get(CountryViewModel.class);
        setHasOptionsMenu(true);
        setUpUi();
        setUpObservers();
        return binding.getRoot();
    }

    private void setUpUi() {
        viewModel.getCountrList();
        binding.progressBar.setVisibility(View.VISIBLE);
        binding.toolbarLayout.toolbarTitle.setText("Países");
        countryAdapter = new CountryAdapter();
        countryAdapter.setListener(new CountryAdapter.ClickOnCountry() {
            @Override
            public void clikOnTransport(CountryCodeAndName country) {
                Navigation.findNavController(getView()).navigate(CountrysFragmentDirections.actionCountrysFragmentToCountryFragment(country.getsISOCode(), country.getsName()));
            }
        });
        binding.recyclerCountrys.setAdapter(countryAdapter);
    }


    private void setUpObservers() {
        viewModel.getListaCountry().observe(getViewLifecycleOwner(), responseCountryListEnvelop -> {
            List<CountryCodeAndName> listaCountry = new ArrayList<>();
            binding.progressBar.setVisibility(View.INVISIBLE);
            listaCountry.addAll(responseCountryListEnvelop.getBody().getListOfCountryNamesByNameResponse().getListOfCountryNamesByNameResponse().getCountryCodeAndName());
            Collections.sort(listaCountry, CountryCodeAndName.SortDecending);
            mostrarItems(listaCountry);
        });
        viewModel.msjError().observe(getViewLifecycleOwner(), response -> {
            Toast.makeText(requireContext(), "Error en el servidor", Toast.LENGTH_SHORT).show();
        });
    }

    private void mostrarItems(List<CountryCodeAndName> _list) {
        ArrayList<CountryCodeAndName> listRecycler = new ArrayList<>();
        for (int i = 0; i < _list.size(); i++) {
            CountryCodeAndName item = _list.get(i);
            if (!existHeader(item.getsName().substring(0, 1), listRecycler)) {
                CountryCodeAndName headerMonth = new CountryCodeAndName();
                headerMonth.setsName(item.getsName());
                headerMonth.setTypeOfView(0);
                listRecycler.add(headerMonth);
            }
            listRecycler.add(item);
        }
        countryAdapter.setData(listRecycler);
    }



    private boolean existHeader(String month, ArrayList<CountryCodeAndName> list) {
        for (CountryCodeAndName item : list) {
            if (item.getsName().substring(0, 1).equals(month) && item.getTypeOfView() == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Search");
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Toast.makeText(requireContext(), "Submit", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Toast.makeText(requireContext(), "Query", Toast.LENGTH_SHORT).show();
        return false;
    }


}