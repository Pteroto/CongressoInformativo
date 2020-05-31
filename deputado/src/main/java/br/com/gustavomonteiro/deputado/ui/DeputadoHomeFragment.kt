package br.com.gustavomonteiro.deputado.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import br.com.gustavomonteiro.camararepository.models.Deputado
import br.com.gustavomonteiro.camararepository.models.ResultDeputadoList
import br.com.gustavomonteiro.deputado.DeputadoHomeActivity
import br.com.gustavomonteiro.deputado.R
import br.com.gustavomonteiro.deputado.di.ActivityScope
import br.com.gustavomonteiro.deputado.presentation.DeputadoHomeViewModel
import br.com.gustavomonteiro.deputado.presentation.factory.DeputadoHomeViewModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class DeputadoHomeFragment : Fragment(R.layout.deputado_home_fragment) {

    companion object {
        fun newInstance() = DeputadoHomeFragment()
    }

    @ActivityScope
    @Inject
    lateinit var vmFactory: DeputadoHomeViewModelFactory

    private val viewModel: DeputadoHomeViewModel by viewModels { vmFactory }

    override fun onAttach(context: Context) {
        (activity as DeputadoHomeActivity).deputadoComponent.inject(this)
        super.onAttach(context)
    }

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.deputadosList.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ResultDeputadoList.Success -> onSucess(it.deputadoList)
                is ResultDeputadoList.Failure -> onFailure(it.errorMsg)
                is ResultDeputadoList.Loading -> setLoading(it.status)
            }
        })
    }

    private fun onSucess(deputados: List<Deputado>) {
        deputados.forEach {
            Log.d("teste", it.nome)
        }
    }

    private fun onFailure(errorMsg: String) {
        Log.d("teste", errorMsg)
    }

    private fun setLoading(boolean: Boolean) {
        Log.d("teste", boolean.toString())
    }
}

