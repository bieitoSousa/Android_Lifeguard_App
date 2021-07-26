package com.bieitoproyect.androidlifeguardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bieitoproyect.androidlifeguardapp.contentModel.CardioRespiratoria
import com.bieitoproyect.androidlifeguardapp.contentModel.Ictus
import com.bieitoproyect.androidlifeguardapp.contentModel.Ovance

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun bttCardioRespiratoria(view: View) {
        val cardioRespiratoria = Intent(this, CardioRespiratoria::class.java).apply {
        }
        startService(cardioRespiratoria)
    }

    fun bttOvance(view: View) {  val ovance = Intent(this, Ovance::class.java).apply {
    }
        startService(ovance)}

    fun bttIctus(view: View) {  val ictus = Intent(this, Ictus::class.java).apply {
    }
        startService(ictus)}
}