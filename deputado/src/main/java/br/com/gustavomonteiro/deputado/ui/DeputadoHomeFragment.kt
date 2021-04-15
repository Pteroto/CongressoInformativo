package br.com.gustavomonteiro.deputado.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import br.com.gustavomonteiro.camararepository.model.Deputado
import br.com.gustavomonteiro.camararepository.model.ResultDeputadoRequest
import br.com.gustavomonteiro.core.viewBinding
import br.com.gustavomonteiro.deputado.DeputadoHomeActivity
import br.com.gustavomonteiro.deputado.R
import br.com.gustavomonteiro.deputado.databinding.DeputadoHomeFragmentBinding
import br.com.gustavomonteiro.deputado.di.ActivityScope
import br.com.gustavomonteiro.deputado.presentation.DeputadoHomeViewModel
import br.com.gustavomonteiro.deputado.presentation.factory.DeputadoHomeViewModelFactory
import com.skydoves.transformationlayout.TransformationLayout
import com.skydoves.transformationlayout.onTransformationStartContainer
import javax.inject.Inject

class DeputadoHomeFragment : Fragment(R.layout.deputado_home_fragment) {

    @ActivityScope
    @Inject
    lateinit var vmFactory: DeputadoHomeViewModelFactory
    private val viewModel: DeputadoHomeViewModel by viewModels { vmFactory }
    private val binding by viewBinding(DeputadoHomeFragmentBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onTransformationStartContainer()
    }

    override fun onAttach(context: Context) {
        (activity as DeputadoHomeActivity).deputadoComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(view.context, 3)
            clipToPadding = false
        }

        viewModel.requestResult.observe(viewLifecycleOwner, {
            when (it) {
                is ResultDeputadoRequest.Success -> onSucess(it.deputadoList)
                is ResultDeputadoRequest.Failure -> onFailure(it.errorMsg)
                is ResultDeputadoRequest.Loading -> setLoading(it.status)
            }
        })
    }

    private fun onSucess(deputados: List<Deputado>) {
        setLoading(false)
        binding.recyclerView.adapter =
            DeputadoAdapter(deputados) { deputado, transformationLayout ->
                onDeputadoClick(deputado, transformationLayout)
            }
    }

    private fun onFailure(errorMsg: String) {
        setLoading(false)
        showDialogError(errorMsg)
    }

    private fun setLoading(boolean: Boolean) {
        if (boolean) {
            binding.progressBar.show()
        } else {
            binding.progressBar.hide()
        }
    }

    private fun onDeputadoClick(deputado: Deputado, transformationLayout: TransformationLayout) {
        (activity as DeputadoHomeActivity?)?.gotoDetailFragment(deputado, transformationLayout)
    }

    private fun showDialogError(errorMsg: String) {
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setTitle("Erro")
        alertDialogBuilder.setMessage(errorMsg)
        alertDialogBuilder.setPositiveButton("Tentar Novamente") { _, _ ->
            viewModel.retryOnClick()
        }
        alertDialogBuilder.setNegativeButton("Fechar") { _, _ ->
            activity?.onBackPressed()
        }
        alertDialogBuilder.create().show()
    }

    companion object {
        fun newInstance() = DeputadoHomeFragment()
    }
}

