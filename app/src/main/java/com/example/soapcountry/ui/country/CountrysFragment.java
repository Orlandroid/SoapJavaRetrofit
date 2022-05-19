package com.example.soapcountry.ui.country;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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
import com.example.soapcountry.util.AlertDialogMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CountrysFragment extends Fragment implements SearchView.OnQueryTextListener, AlertDialogMessage.ClickOnDialog {

    private FragmentCountrysBinding binding;
    private CountryViewModel viewModel;
    private CountryAdapter countryAdapter;
    List<CountryCodeAndName> countryList = new ArrayList<>();
    private AlertDialogMessage alertDialogMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCountrysBinding.inflate(inflater);
        viewModel = new ViewModelProvider(getActivity()).get(CountryViewModel.class);
        setUpUi();
        setUpObservers();
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    private void setUpUi() {
        viewModel.getCountrList();
        binding.progressBar.setVisibility(View.VISIBLE);
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbarLayout.toolbar);
        countryAdapter = new CountryAdapter();
        countryAdapter.setListener(new CountryAdapter.ClickOnCountry() {
            @Override
            public void clikOnTransport(CountryCodeAndName country) {
                Navigation.findNavController(getView()).navigate(CountrysFragmentDirections.actionCountrysFragmentToCountryFragment(country.getsISOCode(), country.getsName()));
            }
        });
        countryAdapter.setData(new ArrayList<>());
        binding.recyclerCountrys.setAdapter(countryAdapter);
        binding.swiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.empty.setVisibility(View.INVISIBLE);
                countryAdapter.setData(new ArrayList<>());
                viewModel.getCountrList();
                binding.swiperefreshlayout.setRefreshing(false);
                binding.progressBar.setVisibility(View.VISIBLE);
            }
        });
    }


    private void setUpObservers() {
        viewModel.getListaCountry().observe(getViewLifecycleOwner(), response -> {
            if (response == null) {
                return;
            }
            binding.progressBar.setVisibility(View.INVISIBLE);
            //eliminamos elementos para evitar duplicador
            countryList.clear();
            countryList.addAll(response.getBody().getListOfCountryNamesByNameResponse().getListOfCountryNamesByNameResponse().getCountryCodeAndName());
            Collections.sort(countryList, CountryCodeAndName.SortDecending);
            mostrarItems(countryList);
        });
        viewModel.msjError().observe(getViewLifecycleOwner(), respose -> {
            if (respose == null) {
                return;
            }
            alertDialogMessage = new AlertDialogMessage(respose, this);
            alertDialogMessage.show(requireFragmentManager(), "Dialog");
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
        //Toast.makeText(requireContext(), "Submit", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText.isEmpty()) {
            mostrarItems(countryList);
        } else {
            if (countryAdapter.filter(newText).size() != 0) {
                binding.empty.setVisibility(View.INVISIBLE);
                mostrarItems(countryAdapter.filter(newText));
            } else {
                binding.empty.setVisibility(View.VISIBLE);
            }
        }
        return false;
    }


    @Override
    public void clickOnAcept() {
        requireActivity().finish();
    }
}