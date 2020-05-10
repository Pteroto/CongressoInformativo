package br.com.gustavomonteiro.congressoinformativo.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import br.com.gustavomonteiro.congressoinformativo.R
import br.com.gustavomonteiro.congressoinformativo.ui.main.viewmodel.MainViewModel
import br.com.gustavomonteiro.congressoinformativo.ui.main.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels { MainViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.deputado.observe(viewLifecycleOwner, Observer {
            result.text = it.nomeCivil
            Log.d("teste", it.nomeCivil)
        })

        viewModel.error.observe(viewLifecycleOwner, Observer {
            result.text = it
            Log.d("teste", it)
        })

        test_button.setOnClickListener {
            result.text = ""
           viewModel.getDeputado(edittext.text.toString())
        }
    }
}
