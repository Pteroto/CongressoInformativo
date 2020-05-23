package br.com.gustavomonteiro.infocongresso.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import br.com.gustavomonteiro.infocongresso.AppApplication
import br.com.gustavomonteiro.infocongresso.R
import br.com.gustavomonteiro.infocongresso.databinding.MainFragmentBinding
import br.com.gustavomonteiro.infocongresso.ui.main.viewmodel.MainViewModel
import br.com.gustavomonteiro.infocongresso.ui.main.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var vmFactory: MainViewModelFactory

    private val viewModel: MainViewModel by viewModels { vmFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = MainFragmentBinding.bind(view)
        (activity?.application as AppApplication).component.inject(this)

        viewModel.deputado.observe(viewLifecycleOwner, Observer {
            binding.result.text = it.nomeCivil
            Log.d("teste", it.nomeCivil)
        })

        viewModel.error.observe(viewLifecycleOwner, Observer {
            binding.result.text = it
            Log.d("teste", it)
        })

        binding.testButton.setOnClickListener {
            binding.result.text = ""
            viewModel.getDeputado(binding.editText.text.toString())
        }
    }
}
