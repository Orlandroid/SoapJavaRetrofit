package com.example.soapcountry.ui.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.soapcountry.databinding.FragmentCalculatorBinding
import com.example.soapcountry.util.AlertDialogMessage
import com.example.soapcountry.util.Util


class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!
    private var viewModel: CalculatorViewModel? = null
    private var alertDialogMessage: AlertDialogMessage? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculatorBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(CalculatorViewModel::class.java)
        viewModel!!.context = requireContext()
        setUpUi()
        setUpObservers()
        return binding.root
    }

    private fun setUpUi() {
        with(binding) {
            root.setOnClickListener {
                Util.hideKeyboard(requireActivity())
            }
            txtNumber.editText?.doOnTextChanged { _, _, _, _ ->
                enableButtons()
            }
            txtNumber2.editText?.doOnTextChanged { _, _, _, _ ->
                enableButtons()
            }
            toolbarLayout.backTextToolbar.text = "Atrás"
            toolbarLayout.backIconToolbar.setOnClickListener {
                findNavController().popBackStack()
            }
            btnSumar.setOnClickListener {
                val number = binding.txtNumber.editText?.text.toString().toInt()
                val number2 = binding.txtNumber2.editText?.text.toString().toInt()
                binding.progressBar2.visibility = View.VISIBLE
                binding.tvResult.text="-"
                viewModel?.getAdd(number, number2)
            }
            btnRestar.setOnClickListener {

            }
            btnMultiplicar.setOnClickListener {

            }
            btnDividir.setOnClickListener {

            }
        }
    }

    private fun areEmptyFields(): Boolean {
        val number = binding.txtNumber.editText?.text.toString()
        val number2 = binding.txtNumber2.editText?.text.toString()
        if (number.isEmpty() or number2.isEmpty()) {
            return true
        }
        return false
    }

    private fun enableButtons() {
        with(binding) {
            if (areEmptyFields()) {
                btnSumar.isEnabled = false
                btnRestar.isEnabled = false
                btnDividir.isEnabled = false
                btnMultiplicar.isEnabled = false
            } else {
                btnSumar.isEnabled = true
                btnRestar.isEnabled = true
                btnDividir.isEnabled = true
                btnMultiplicar.isEnabled = true
            }
        }
    }

    private fun setUpObservers() {
        viewModel?.errorNetwork()?.observe(viewLifecycleOwner) {
            if (it == null) {
                return@observe;
            }
            binding.progressBar2.visibility = View.INVISIBLE
            alertDialogMessage = AlertDialogMessage(it)
            alertDialogMessage!!.show(requireFragmentManager(), "Dialog")
        }
        viewModel!!.msjError().observe(viewLifecycleOwner) { respose: String? ->
            if (respose == null) {
                return@observe
            }
            binding.progressBar2.visibility = View.INVISIBLE
        }
        viewModel!!.resultAdd().observe(viewLifecycleOwner) {
            if (it != null) {
                binding.tvResult.text=it
            }
            binding.progressBar2.visibility = View.INVISIBLE
        }
    }


}