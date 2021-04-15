package br.com.gustavomonteiro.deputado.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.gustavomonteiro.camararepository.model.Deputado
import br.com.gustavomonteiro.core.viewBinding
import br.com.gustavomonteiro.deputado.R
import br.com.gustavomonteiro.deputado.databinding.DeputadoDetailFragmentBinding
import com.bumptech.glide.Glide
import com.skydoves.transformationlayout.TransformationLayout
import com.skydoves.transformationlayout.onTransformationEndContainer

class DeputadoDetailFragment : Fragment(R.layout.deputado_detail_fragment) {
    private val binding by viewBinding(DeputadoDetailFragmentBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val params = arguments?.getParcelable<TransformationLayout.Params>(TRANSFORMATION_KEY)
        onTransformationEndContainer(params)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<Deputado>(DEPUTADO_KEY)?.let { deputado ->
            binding.detailContainer.transitionName = deputado.nome
            binding.deputadoName.text = deputado.nome
            binding.deputadoEmail.text = deputado.email
            binding.deputadoSigla.text = deputado.siglaPartido
            Glide.with(this)
                .load(deputado.urlFoto)
                .into(binding.deputadoPhoto)
        }
    }

    companion object {
        const val DEPUTADO_KEY = "deputadoParam"
        const val TRANSFORMATION_KEY = "transformationParams"

        fun newInstance(deputado: Deputado, transformationLayout: TransformationLayout) =
            DeputadoDetailFragment().apply {
                arguments =
                    Bundle().apply {
                        putParcelable(TRANSFORMATION_KEY, transformationLayout.getParams())
                        putParcelable(DEPUTADO_KEY, deputado)
                    }
            }
    }
}
