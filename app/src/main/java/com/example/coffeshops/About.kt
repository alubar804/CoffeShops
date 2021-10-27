package com.example.coffeshops

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val items = ArrayList<Usuarios>()
        items.add(Usuarios(R.drawable.image1,R.string.name1,R.string.year1))
        items.add(Usuarios(R.drawable.image2,R.string.name2,R.string.year2))
        items.add(Usuarios(R.drawable.image3,R.string.name3,R.string.year3))
        items.add(Usuarios(R.drawable.image4,R.string.name4,R.string.year4))
        items.add(Usuarios(R.drawable.image5,R.string.name5,R.string.year5))
        items.add(Usuarios(R.drawable.image6,R.string.name6,R.string.year6))

        val recView = findViewById<RecyclerView>(R.id.recyclerView)

        recView.setHasFixedSize(true)

        val adaptador = UserAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false,)
        adaptador.onClick = {
            Toast.makeText(this, ""+ resources.getString(items[recView.getChildAdapterPosition(it)].cadena), Toast.LENGTH_LONG).show()
        }
    }
}