package com.bieitoproyect.androidlifeguardapp.contentModel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bieitoproyect.androidlifeguardapp.R
import com.google.android.material.button.MaterialButton

class DetailIctus : AppCompatActivity() {

    private lateinit var goToOvance : MaterialButton
    private lateinit var goToRCP : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_ictus)
        instance()
        action()
    }
    private fun instance() {
        var ictusTitle : TextView = findViewById(R.id.title_ictus)
        ictusTitle.setText(R.string.ICTUS);
        var ictusDesc : TextView = findViewById(R.id.tv_ictus_desc)
        ictusDesc.setText(R.string.ictus_desc);
        var rcpImage : ImageView = findViewById(R.id.iv_ictus_image)
        rcpImage.setImageResource(R.drawable.img_ictus)
        goToOvance =findViewById<MaterialButton>(R.id.goToOvance)
        goToOvance.setText(R.string.OVACE_short)
        goToRCP =findViewById<MaterialButton>(R.id.goToRCP)
        goToRCP.setText(R.string.RCP_short)
    }
    private fun action() {
        val botonsalir =findViewById<Button>(R.id.close)
        botonsalir.setOnClickListener{
            finish()
        }
        goToOvance.setOnClickListener{
            val detailOV = Intent(this, DetailOvance::class.java)
            startActivity(detailOV)
        }

        goToRCP.setOnClickListener{
            val detailCR = Intent(this, DetailCardioRespiratoria::class.java)
            startActivity(detailCR)
        }
    }
}