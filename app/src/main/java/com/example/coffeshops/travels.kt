package com.example.coffeshops

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class Travels(val imagen:Int, )
class TravelAdapter(var items: ArrayList<Travels>) : RecyclerView.Adapter<TravelAdapter.TarjViewHolder>() {
    lateinit var onClick : (View) -> Unit

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var laImagen: ImageView
        init {
            laImagen=itemView.findViewById(R.id.imageView)
        }

        fun bindTarjeta(t: Travels, onClick: (View) -> Unit) = with(itemView) {
            laImagen.setImageResource(t.imagen)
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.imagenes, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}