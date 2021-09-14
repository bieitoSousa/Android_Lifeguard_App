package com.bieitoproyect.androidlifeguardapp.contentModel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bieitoproyect.androidlifeguardapp.R
import com.google.android.material.button.MaterialButton

class DetailCardioRespiratoria : AppCompatActivity() {
    private lateinit var goToIctus : MaterialButton
    private lateinit var goToOvance : MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_cardio_respiratoria)
        instance()
        action()

    }
    private fun instance() {
        var rcpTitle : TextView = findViewById(R.id.title_rcp)
        rcpTitle.setText(R.string.RCP);

        var rcpDesc : TextView = findViewById(R.id.tv_rcp_desc)
        rcpDesc.setText(R.string.rcp_desc);
        var rcpImage : ImageView = findViewById(R.id.iv_rcp_image)
        rcpImage.setImageResource(R.drawable.rcp_image)
        goToIctus = findViewById<MaterialButton>(R.id.goToIctus)
        goToIctus.setText(R.string.ICTUS_short)
        goToOvance =findViewById<MaterialButton>(R.id.goToOvance)
        goToOvance.setText(R.string.OVACE_short)

    }
    private fun action() {
        val botonsalir =findViewById<Button>(R.id.close)
        botonsalir.setOnClickListener{
            finish()
        }

        goToIctus.setOnClickListener{
            val detailIT = Intent(this, DetailIctus::class.java)
            startActivity(detailIT)
        }

        goToOvance.setOnClickListener{
            val detailOV = Intent(this, DetailOvance::class.java)
            startActivity(detailOV)
        }



    }
}