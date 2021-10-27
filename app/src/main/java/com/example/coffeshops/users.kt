package com.example.coffeshops



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Usuarios(val imagen:Int,val cadena: Int, val cadena2:Int)
class UserAdapter(var items: ArrayList<Usuarios>) : RecyclerView.Adapter<UserAdapter.TarjViewHolder>() {
    lateinit var onClick : (View) -> Unit

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var laImagen: ImageView
        private var texto: TextView
        private var subTexto: TextView

        init {
            laImagen=itemView.findViewById(R.id.userImage)
            texto = itemView.findViewById(R.id.username)
            subTexto=itemView.findViewById(R.id.UserYear)

        }

        fun bindTarjeta(t: Usuarios, onClick: (View) -> Unit) = with(itemView) {
            laImagen.setImageResource(t.imagen)
            texto.setText(t.cadena)
            subTexto.setText(t.cadena2)
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.users, viewGroup, false)
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