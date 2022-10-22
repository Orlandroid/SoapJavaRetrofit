package com.example.soapcountry.ui.hello

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.soapcountry.databinding.FragmentHelloBinding
import com.example.soapcountry.getTextWatcher
import com.example.soapcountry.util.AlertDialogMessage


class HelloFragment : Fragment() {

    private var _binding: FragmentHelloBinding? = null
    private val binding get() = _binding!!
    private var viewModel: HelloViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelloBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(HelloViewModel::class.java)
        viewModel!!.context = requireContext()
        setUpUi()
        observeViewModel()
        return binding.root
    }

    private fun setUpUi() {
        with(binding) {
            inputName.editText?.addTextChangedListener(getTextWatcher {
                btnSend.isEnabled = inputName.editText!!.text.toString().trim().isNotEmpty()
            })
            btnSend.setOnClickListener {
                hello()
            }
            inputName.editText?.setOnEditorActionListener { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    if (inputName.editText!!.text.toString().trim().isNotEmpty()) {
                        hello()
                    }
                }
                false
            }
            toolbarLayout.backIconToolbar.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun hello() {
        with(binding) {
            viewModel?.helloName(inputName.editText!!.text.toString())
            tvSaludo.text = "-"
            progressBar4.visibility = View.VISIBLE
        }
    }

    private fun observeViewModel() {
        viewModel?.helloNameResponse?.observe(viewLifecycleOwner) {
            if (it == null) return@observe
            binding.tvSaludo.text = it.body?.helloResponse?.message ?: ""
            binding.progressBar4.visibility = View.INVISIBLE
        }
        viewModel?.errorNetwork?.observe(viewLifecycleOwner) {
            if (it != null) {
                val alertDialogMessage = AlertDialogMessage(it)
                alertDialogMessage.show(requireFragmentManager(), "Dialog")
                binding.progressBar4.visibility = View.INVISIBLE
            }
        }
        viewModel?.msjError?.observe(viewLifecycleOwner) {
            if (it != null) {
                val alertDialogMessage = AlertDialogMessage(it)
                alertDialogMessage.show(requireFragmentManager(), "Dialog")
                binding.progressBar4.visibility = View.INVISIBLE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}