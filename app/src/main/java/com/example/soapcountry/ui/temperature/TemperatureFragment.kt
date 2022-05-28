package com.example.soapcountry.ui.temperature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.example.soapcountry.databinding.FragmentTemperatureBinding
import com.example.soapcountry.util.AlertDialogMessage
import com.example.soapcountry.util.Util


class TemperatureFragment : Fragment() {


    private var _binding: FragmentTemperatureBinding? = null
    private val binding get() = _binding!!
    private var alertDialogMessage: AlertDialogMessage? = null
    private var viewModel: TemperatureViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTemperatureBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(TemperatureViewModel::class.java)
        viewModel!!.context = requireContext()
        setUpUi()
        setUpObservers()
        return binding.root
    }

    private fun setUpUi() {
        with(binding) {
            binding.root.setOnClickListener {
                Util.hideKeyboard(requireActivity())
            }
            inputTemperature.editText?.doOnTextChanged { text, start, count, after ->
                val temperature = binding.inputTemperature.editText?.text.toString()
                btnCelcius.isEnabled = temperature.isNotEmpty()
                btnFarenheit.isEnabled = temperature.isNotEmpty()
            }
            btnCelcius.setOnClickListener {
                tvResult.text = "-"
                progressBar3.visibility = View.VISIBLE
                val celcius = binding.inputTemperature.editText?.text.toString()
                viewModel?.celsiustoFarenheit(celcius)
            }
            btnFarenheit.setOnClickListener {
                tvResult.text = "-"
                progressBar3.visibility = View.VISIBLE
                val farenheit = binding.inputTemperature.editText?.text.toString()
                viewModel?.farenheittoCelsius(farenheit.toInt())
            }
        }
    }

    private fun setUpObservers() {
        viewModel?.errorNetwork?.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.progressBar3.visibility = View.INVISIBLE
                alertDialogMessage = AlertDialogMessage(it)
                alertDialogMessage!!.show(requireFragmentManager(), "Dialog")
            }
        }
        viewModel?.msjError?.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.progressBar3.visibility = View.INVISIBLE
                alertDialogMessage = AlertDialogMessage(it)
                alertDialogMessage!!.show(requireFragmentManager(), "Dialog")
            }
        }
        viewModel?.celsiustoFarenheit?.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.progressBar3.visibility = View.INVISIBLE
                binding.tvResult.text = it
            }
        }
        viewModel?.farenheittoCelsius?.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.progressBar3.visibility = View.INVISIBLE
                binding.tvResult.text = it.toString()
            }
        }
    }


}