package com.example.gestiondescontact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.emaill
import kotlinx.android.synthetic.main.activity_main.nomm
import kotlinx.android.synthetic.main.activity_main.tell

class MainActivity : AppCompatActivity() {

    lateinit var  noms: ArrayList<String>
    lateinit var contact: ArrayList<contact>
    lateinit var myAdapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        noms=ArrayList()
        contact= ArrayList()
        myAdapter= ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,noms)
        list.adapter=myAdapter

        floatingActionButton.setOnClickListener(View.OnClickListener {
        var moncontact=contact(nomm.text.toString(),tell.text.toString(),emaill.text.toString())
            contact.add(moncontact)
            noms.add(moncontact.nom)
            nomm.text.clear()
            tell.text.clear()
            emaill.text.clear()

            myAdapter.notifyDataSetChanged()
            list.setOnItemClickListener { parent, view, position, id ->
                var nom=contact[position]

                val i = Intent(this,details::class.java)
                i.putExtra("nom",nom)

                startActivity(i)
            }
    })


    }
}