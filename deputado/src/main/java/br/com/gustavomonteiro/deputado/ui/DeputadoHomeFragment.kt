package br.com.gustavomonteiro.deputado.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import br.com.gustavomonteiro.camararepository.models.Deputado
import br.com.gustavomonteiro.camararepository.models.ResultDeputadoList
import br.com.gustavomonteiro.core.viewBinding
import br.com.gustavomonteiro.deputado.DeputadoHomeActivity
import br.com.gustavomonteiro.deputado.R
import br.com.gustavomonteiro.deputado.databinding.DeputadoHomeFragmentBinding
import br.com.gustavomonteiro.deputado.di.ActivityScope
import br.com.gustavomonteiro.deputado.presentation.DeputadoHomeViewModel
import br.com.gustavomonteiro.deputado.presentation.factory.DeputadoHomeViewModelFactory
import kotlinx.android.synthetic.main.deputado_home_fragment.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class DeputadoHomeFragment : Fragment(R.layout.deputado_home_fragment) {

    @ActivityScope
    @Inject
    lateinit var vmFactory: DeputadoHomeViewModelFactory
    private val viewModel: DeputadoHomeViewModel by viewModels { vmFactory }
    private val binding by viewBinding(DeputadoHomeFragmentBinding::bind)

    override fun onAttach(context: Context) {
        (activity as DeputadoHomeActivity).deputadoComponent.inject(this)
        super.onAttach(context)
    }

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(view.context, 3)
            clipToPadding = false
        }

        viewModel.deputadosList.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ResultDeputadoList.Success -> onSucess(it.deputadoList)
                is ResultDeputadoList.Failure -> onFailure(it.errorMsg)
                is ResultDeputadoList.Loading -> setLoading(it.status)
            }
        })
    }

    private fun onSucess(deputados: List<Deputado>) {
        recyclerView.adapter = DeputadoAdapter(deputados) {
            onDeputadoClick(it)
        }

        setLoading(false)
    }

    private fun onFailure(errorMsg: String) {
        Log.d("teste", errorMsg)
    }

    private fun setLoading(boolean: Boolean) {
        if (boolean) {
            Log.d("teste", "show")
            progressBar.show()
        } else {
            Log.d("teste", "hide")
            progressBar.hide()
        }
    }

    private fun onDeputadoClick(deputado: Deputado) {
        Log.d("teste", deputado.nome)
    }

    companion object {
        fun newInstance() = DeputadoHomeFragment()
    }
}

