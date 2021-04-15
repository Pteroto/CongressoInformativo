package br.com.gustavomonteiro.deputado.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.gustavomonteiro.camararepository.model.Deputado
import br.com.gustavomonteiro.deputado.R
import com.bumptech.glide.Glide
import com.skydoves.transformationlayout.TransformationLayout

class DeputadoAdapter(
    private val deputadoList: List<Deputado>,
    private val onItemClick: (Deputado, TransformationLayout) -> Unit
) : RecyclerView.Adapter<DeputadoAdapter.DeputadoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeputadoHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.deputado_item, parent, false)
        return DeputadoHolder(view)
    }

    override fun getItemCount(): Int {
        return deputadoList.size
    }

    override fun onBindViewHolder(holder: DeputadoHolder, position: Int) {
        holder.bindView(deputadoList[position], onItemClick)
    }

    inner class DeputadoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(deputado: Deputado, onItemClick: (Deputado, TransformationLayout) -> Unit) {
            val photo = itemView.findViewById<ImageView>(R.id.deputadoPhoto)
            val name = itemView.findViewById<TextView>(R.id.deputadoName)

            val transformationLayout =
                itemView.findViewById<TransformationLayout>(R.id.transformationLayout)
            transformationLayout.transitionName = deputado.nome

            Glide.with(itemView).load(deputado.urlFoto).into(photo)
            name.text = deputado.nome
            itemView.setOnClickListener {
                onItemClick(deputado, transformationLayout)
            }
        }
    }
}