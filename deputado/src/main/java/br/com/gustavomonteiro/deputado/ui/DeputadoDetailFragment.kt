package br.com.gustavomonteiro.deputado.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.transition.ChangeBounds
import br.com.gustavomonteiro.core.viewBinding
import br.com.gustavomonteiro.deputado.R
import br.com.gustavomonteiro.deputado.databinding.DeputadoDetailFragmentBinding
import com.bumptech.glide.Glide

class DeputadoDetailFragment : Fragment(R.layout.deputado_detail_fragment) {
    private val binding by viewBinding(DeputadoDetailFragmentBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = ChangeBounds()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()

        arguments?.getString(URL_PHOTO_KEY)?.let {
            Glide.with(this).load(it).into(binding.deputadoPhoto)
        }
        startPostponedEnterTransition()
    }

    companion object {
        const val URL_PHOTO_KEY = "urlPhoto"
        const val DEPUTADO_ID_KEY = "deputadoId"

        fun newInstance(deputadoId: Int, urlPhoto: String) =
            DeputadoDetailFragment().apply {
                arguments =
                    Bundle().apply {
                        putInt(DEPUTADO_ID_KEY, deputadoId)
                        putString(URL_PHOTO_KEY, urlPhoto)
                    }
            }
    }

}