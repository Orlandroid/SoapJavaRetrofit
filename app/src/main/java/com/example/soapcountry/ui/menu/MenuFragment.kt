package com.example.soapcountry.ui.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.soapcountry.R
import com.example.soapcountry.databinding.FragmentMenuBinding
import com.example.soapcountry.util.ClickOnItem


class MenuFragment : Fragment(), ClickOnItem<MenuAdapter.MenuElement> {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    private val adapter = MenuAdapter(getListener())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        setUpUi()
        return binding.root
    }

    private fun setUpUi() {
        binding.recyclerMenu.adapter = adapter
        binding.recyclerMenu.layoutManager = GridLayoutManager(requireContext(), 2)
        adapter.setData(setMenus())
    }

    private fun getListener(): ClickOnItem<MenuAdapter.MenuElement> = this

    private fun setMenus(): List<MenuAdapter.MenuElement> {
        val countrys = MenuAdapter.MenuElement("Countrys", R.drawable.countries)
        val numbers = MenuAdapter.MenuElement("Numbers", R.drawable.number_blocks)
        val calculator = MenuAdapter.MenuElement("Calculator", R.drawable.calculator)
        val temperature = MenuAdapter.MenuElement("Temperature", R.drawable.temperature)
        return listOf(countrys, numbers, calculator, temperature)
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
        }
    }

}