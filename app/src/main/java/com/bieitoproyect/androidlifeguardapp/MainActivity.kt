package com.bieitoproyect.androidlifeguardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.bieitoproyect.androidlifeguardapp.contentModel.DetailCardioRespiratoria
import com.bieitoproyect.androidlifeguardapp.contentModel.DetailIctus
import com.bieitoproyect.androidlifeguardapp.contentModel.DetailOvance
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

private const val TAG = "MyActivity"

class MainActivity : AppCompatActivity()  {
    private lateinit var cvRCP : MaterialCardView
    private lateinit var cvOvance : MaterialCardView
    private lateinit var cvIctus : MaterialCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instance()
        action()
    }
    private fun action() {
        cvRCP.setOnClickListener {
            Log.i(TAG, "Boton bttCardioRespiratoria pulsado")
            sendMessage(" Accion Boton bttCardioRespiratoria pulsado")
            val detailCR = Intent(this, DetailCardioRespiratoria::class.java)
            startActivity(detailCR)
        }
        cvOvance.setOnClickListener {
            Log.i(TAG, "Boton bttOvance pulsado")
            sendMessage("Accion Boton bttOvance pulsado")
            val detailOV = Intent(this, DetailOvance::class.java)
            startActivity(detailOV)
        }
        cvIctus.setOnClickListener{
            Log.i(TAG, "Boton bttIctus pulsado")
            sendMessage("Accion Boton bttIctus pulsado")
            val detailIT = Intent(this, DetailIctus::class.java)
            startActivity(detailIT)
        }
    }

    private fun instance() {
        cvRCP = findViewById(R.id.cvRCP)
        cvOvance = findViewById(R.id.cvOVACE)
        cvIctus = findViewById(R.id.cvICTUS)
    }


    private fun sendMessage(message: String) {
        Toast.makeText(this,  message, Toast.LENGTH_SHORT).show()
    }
}