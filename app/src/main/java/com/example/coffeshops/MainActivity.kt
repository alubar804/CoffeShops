package com.example.coffeshops

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.ViewSwitcher
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeshops.R
import com.example.coffeshops.CafeAdapter
import com.example.coffeshops.Cafe

class MainActivity : AppCompatActivity(),ViewSwitcher.ViewFactory {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //TODO el que tiene las cards es SOL no imagenes pero imagenes tiene el linearmanajer que quieres

        val items = ArrayList<Cafe>()
        items.add(Cafe(R.drawable.images,R.string.titulo,R.string.subtitulo))
        items.add(Cafe(R.drawable.images1,R.string.titulo1,R.string.subtitulo1))
        items.add(Cafe(R.drawable.images2,R.string.titulo2,R.string.subtitulo2))
        items.add(Cafe(R.drawable.images3,R.string.titulo3,R.string.subtitulo3))
        items.add(Cafe(R.drawable.images4,R.string.titulo4,R.string.subtitulo4))
        items.add(Cafe(R.drawable.images5,R.string.titulo5,R.string.subtitulo5))
        items.add(Cafe(R.drawable.images6,R.string.titulo6,R.string.subtitulo6))

        val recView = findViewById<RecyclerView>(R.id.recyclerView)
        recView.setHasFixedSize(true)
        recView.itemAnimator = DefaultItemAnimator()
        val adaptador = CafeAdapter(items)
        recView.adapter = adaptador

        recView.layoutManager = GridLayoutManager(this,1)
        adaptador.onClick = {


        }


    }
    override fun makeView(): View {
        val imageView = ImageView(this)
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER

        return imageView
    }
}