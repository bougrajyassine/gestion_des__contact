package com.example.gestiondescontact

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MyAdapter(var mCtx:Context, var ressources:Int, var items:List<contact>)
    :ArrayAdapter<contact>(mCtx,ressources,items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater:LayoutInflater= LayoutInflater.from(mCtx)
        val view:View=layoutInflater.inflate(ressources,null)
        val nomtextView:TextView=view.findViewById(R.id.nomm)

        val teltextView:TextView=view.findViewById(R.id.tell)
        var emailView:TextView=view.findViewById(R.id.emaill)
        val contact=items[position]


        nomtextView.text=contact.nom
        teltextView.text=contact.tel
        emailView.text=contact.email


        return view
    }
}