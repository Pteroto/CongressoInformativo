package br.com.gustavomonteiro.deputado

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.commitNow
import br.com.gustavomonteiro.camararepository.models.Deputado
import br.com.gustavomonteiro.core.viewBinding
import br.com.gustavomonteiro.deputado.databinding.DeputadoHomeActivityBinding
import br.com.gustavomonteiro.deputado.di.DeputadoComponent
import br.com.gustavomonteiro.deputado.di.DeputadoComponentProvider
import br.com.gustavomonteiro.deputado.ui.DeputadoDetailFragment
import br.com.gustavomonteiro.deputado.ui.DeputadoHomeFragment

class DeputadoHomeActivity : AppCompatActivity() {
    private val binding by viewBinding(DeputadoHomeActivityBinding::inflate)
    lateinit var deputadoComponent: DeputadoComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        deputadoComponent =
            (applicationContext as DeputadoComponentProvider).provideDeputadoComponent()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            goToHomeFragment()
        }
    }

    fun goToHomeFragment() {
        supportFragmentManager.commitNow {
            replace(R.id.container, DeputadoHomeFragment.newInstance())
        }
    }

    fun gotoDetailFragment(deputado: Deputado) {
        val fragment = DeputadoDetailFragment.newInstance(deputado.id, deputado.urlFoto)

        supportFragmentManager.commit(true) {
            replace(R.id.container, fragment)
            addToBackStack(null)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, DeputadoHomeActivity::class.java)
        }
    }
}