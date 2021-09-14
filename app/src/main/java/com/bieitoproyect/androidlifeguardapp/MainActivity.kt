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

private const val TAG = "MyActivity"

class MainActivity : AppCompatActivity()  {
    private lateinit var bttCardioRespiratoria : MaterialButton
    private lateinit var bttOvance : MaterialButton
    private lateinit var bttIctus : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instance()
        action()
    }
    private fun action() {
        bttCardioRespiratoria.setOnClickListener {
            Log.i(TAG, "Boton bttCardioRespiratoria pulsado")
            sendMessage(" Accion Boton bttCardioRespiratoria pulsado")
            val detailCR = Intent(this, DetailCardioRespiratoria::class.java)
            startActivity(detailCR)
        }
        bttOvance.setOnClickListener {
            Log.i(TAG, "Boton bttOvance pulsado")
            sendMessage("Accion Boton bttOvance pulsado")
            val detailOV = Intent(this, DetailOvance::class.java)
            startActivity(detailOV)
        }
        bttIctus.setOnClickListener{
            Log.i(TAG, "Boton bttIctus pulsado")
            sendMessage("Accion Boton bttIctus pulsado")
            val detailIT = Intent(this, DetailIctus::class.java)
            startActivity(detailIT)
        }
    }

    private fun instance() {
        bttCardioRespiratoria = findViewById(R.id.bttCardioRespiratoria)
        bttOvance = findViewById(R.id.bttOvance)
        bttIctus = findViewById(R.id.bttIctus)
    }


    private fun sendMessage(message: String) {
        Toast.makeText(this,  message, Toast.LENGTH_SHORT).show()
    }
}