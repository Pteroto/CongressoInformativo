package br.com.gustavomonteiro.deputado.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.gustavomonteiro.camararepository.model.Deputado
import br.com.gustavomonteiro.core.viewBinding
import br.com.gustavomonteiro.deputado.R
import br.com.gustavomonteiro.deputado.databinding.DeputadoDetailFragmentBinding
import br.com.gustavomonteiro.deputado.extensions.loadUrlRounded
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeputadoDetailFragment : Fragment(R.layout.deputado_detail_fragment) {
    private val binding by viewBinding(DeputadoDetailFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.apply {
            setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material)
            setNavigationOnClickListener {
                activity?.onBackPressed()
            }
        }

        arguments?.getParcelable<Deputado>(DEPUTADO_KEY)?.let { deputado ->
            binding.textViewName.text = deputado.nome
            binding.textViewPartido.text = deputado.siglaPartido
            binding.textViewEmailValue.text = deputado.email
            binding.imageViewPhoto.loadUrlRounded(deputado.urlFoto)
        }
    }

    companion object {
        const val DEPUTADO_KEY = "deputadoParam"

        fun newInstance(deputado: Deputado) =
            DeputadoDetailFragment().apply {
                arguments =
                    Bundle().apply {
                        putParcelable(DEPUTADO_KEY, deputado)
                    }
            }
    }
}
