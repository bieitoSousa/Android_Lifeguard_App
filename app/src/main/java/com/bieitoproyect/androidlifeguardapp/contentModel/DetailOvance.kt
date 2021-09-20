package com.bieitoproyect.androidlifeguardapp.contentModel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bieitoproyect.androidlifeguardapp.R
import com.google.android.material.button.MaterialButton

class DetailOvance : AppCompatActivity() {
    private lateinit var goToIctus : MaterialButton
    private lateinit var goToRCP : MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_ovance)
        instance()
        action()

    }
    private fun instance() {
        var ovaceTitle : TextView = findViewById(R.id.title_ovace)
        ovaceTitle.setText(R.string.OVACE);
        var ovaceDesc : TextView = findViewById(R.id.tv_ovace_desc)
        ovaceDesc.setText(R.string.rcp_desc);
        var ovaceImage : ImageView = findViewById(R.id.iv_ovace_image)
        ovaceImage.setImageResource(R.drawable.img_ovace)
        goToIctus = findViewById<MaterialButton>(R.id.goToIctus)
        goToIctus.setText(R.string.ICTUS_short)
        goToRCP =findViewById<MaterialButton>(R.id.goToRCP)
        goToRCP.setText(R.string.RCP_short)

    }
    private fun action() {
        val botonsalir =findViewById<Button>(R.id.close)
        botonsalir.setOnClickListener{
            finish()
        }

       goToIctus =findViewById<MaterialButton>(R.id.goToIctus)
        goToIctus.setOnClickListener{
            val detailIT = Intent(this, DetailIctus::class.java)
            startActivity(detailIT)
        }



        goToRCP =findViewById<MaterialButton>(R.id.goToRCP)
        goToRCP.setOnClickListener{
            val detailCR = Intent(this, DetailCardioRespiratoria::class.java)
            startActivity(detailCR)
        }
    }
}