package br.com.gustavomonteiro.infocongresso.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.com.gustavomonteiro.deputado.DeputadoHomeActivity
import br.com.gustavomonteiro.infocongresso.R
import br.com.gustavomonteiro.infocongresso.databinding.MainFragmentBinding
import br.com.gustavomonteiro.infocongresso.ui.main.viewmodel.MainViewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = MainFragmentBinding.bind(view)

        binding.testButton.setOnClickListener {
            startActivity(DeputadoHomeActivity.newIntent(requireContext()))
        }
    }
}
