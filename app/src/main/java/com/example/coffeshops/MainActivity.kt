package com.example.travels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.Toast
import android.widget.ViewSwitcher
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeshops.R
import com.example.coffeshops.TravelAdapter
import com.example.coffeshops.Travels

class MainActivity : AppCompatActivity(),ViewSwitcher.ViewFactory {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = ArrayList<Travels>()
        items.add(Travels(R.drawable.images1))
        items.add(Travels(R.drawable.images2))
        items.add(Travels(R.drawable.images3))
        items.add(Travels(R.drawable.images4))
        items.add(Travels(R.drawable.images5))
        items.add(Travels(R.drawable.images6))
        val grande = findViewById<ImageSwitcher>(R.id.imageViewGrande)
        val recView = findViewById<RecyclerView>(R.id.recyclerView)
        grande.setFactory(this)
        grande.inAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        grande.outAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right)

        recView.setHasFixedSize(true)

        val adaptador = TravelAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adaptador.onClick = {

            grande.setImageResource(items[recView.getChildAdapterPosition(it)].imagen)
        }

    }
    override fun makeView(): View {
        val imageView = ImageView(this)
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER

        return imageView
    }
}