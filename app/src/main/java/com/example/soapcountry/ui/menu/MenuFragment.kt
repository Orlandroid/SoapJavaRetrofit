package com.example.soapcountry.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.soapcountry.R
import com.example.soapcountry.databinding.FragmentMenuBinding
import com.example.soapcountry.ui.temperature.TemperatureViewModel
import com.example.soapcountry.util.AlertDialogMessage
import com.example.soapcountry.util.ClickOnItem


class MenuFragment : Fragment(), ClickOnItem<MenuAdapter.MenuElement> {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    private val adapter = MenuAdapter(getListener())
    private var viewModel: TemperatureViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(TemperatureViewModel::class.java)
        viewModel!!.context = requireContext()
        setUpUi()
        setUpObservers()
        return binding.root
    }

    private fun setUpUi() {
        binding.recyclerMenu.adapter = adapter
        binding.recyclerMenu.layoutManager = GridLayoutManager(requireContext(), 2)
        adapter.setData(setMenus())
    }

    private fun setUpObservers() {
        viewModel?.helloNameResponse?.observe(viewLifecycleOwner) {
            if (it != null) {
                val alertDialogMessage = AlertDialogMessage(it.body?.helloResponse?.message ?: "")
                alertDialogMessage.show(requireFragmentManager(), "Dialog")
            }
        }
    }

    private fun getListener(): ClickOnItem<MenuAdapter.MenuElement> = this

    private fun setMenus(): List<MenuAdapter.MenuElement> {
        val countrys = MenuAdapter.MenuElement("Countrys", R.drawable.countries)
        val numbers = MenuAdapter.MenuElement("Numbers", R.drawable.number_blocks)
        val calculator = MenuAdapter.MenuElement("Calculator", R.drawable.calculator)
        val temperature = MenuAdapter.MenuElement("Temperature", R.drawable.temperature)
        val findAperson = MenuAdapter.MenuElement("Find a person", R.drawable.people)
        val helloName = MenuAdapter.MenuElement("Hello name", R.drawable.hello)
        return listOf(countrys, numbers, calculator, temperature, findAperson, helloName)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun clickOnElement(element: MenuAdapter.MenuElement, position: Int?) {
        when (position) {
            0 -> {
                val action = MenuFragmentDirections.actionMenuFragmentToCountrysFragment()
                findNavController().navigate(action)
            }
            1 -> {
                val action = MenuFragmentDirections.actionMenuFragmentToNumbersFragment()
                findNavController().navigate(action)
            }
            2 -> {
                val action = MenuFragmentDirections.actionMenuFragmentToCalculatorFragment()
                findNavController().navigate(action)
            }
            3 -> {
                val action = MenuFragmentDirections.actionMenuFragmentToTemperatureFragment()
                findNavController().navigate(action)
            }
            4 -> {
                val action = MenuFragmentDirections.actionMenuFragmentToTemperatureFragment()
                findNavController().navigate(action)
            }
            5 -> {
                val action = MenuFragmentDirections.actionMenuFragmentToHelloFragment()
                findNavController().navigate(action)
            }
        }
    }

}