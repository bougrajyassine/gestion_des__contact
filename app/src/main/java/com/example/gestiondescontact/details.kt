package com.example.gestiondescontact

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.gestiondescontact.databinding.ActivityDetailsBinding
import kotlinx.android.synthetic.main.activity_details.*

class details : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        binding= ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nom=intent.getSerializableExtra("nom")as contact
        var em=nom.email
        var no=nom.nom
        var te=nom.tel
        emaill.text=em
        nomm.text=no
        tell.text=te
        floatingActionButton2.setOnClickListener(View.OnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+te))
            startActivity(i)
        })
        floatingActionButton3.setOnClickListener(View.OnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+te))
            startActivity(i)
        })
        floatingActionButton5.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/html"
            intent.putExtra(Intent.EXTRA_EMAIL, em)
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
            intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.")
            startActivity(Intent.createChooser(intent, "Send Email"))
            startActivity(intent)
        })

    }
}