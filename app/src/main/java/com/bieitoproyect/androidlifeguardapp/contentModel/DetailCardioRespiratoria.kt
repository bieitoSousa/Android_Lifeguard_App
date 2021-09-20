package com.bieitoproyect.androidlifeguardapp.contentModel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bieitoproyect.androidlifeguardapp.R
import com.google.android.material.button.MaterialButton

class DetailCardioRespiratoria : AppCompatActivity() {

    private lateinit var goBack : ImageButton
    private lateinit var goToMenu : ImageButton
    private lateinit var goEdit : ImageButton


    private lateinit var goToIctus : MaterialButton
    private lateinit var goToOvance : MaterialButton


    private var nextButton = R.string.ICTUS_short
    private var preButton = R.string.OVACE_short

    private var rcpDesc = R.string.rcp_desc
    private var rcpTitle = R.string.RCP


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_cardio_respiratoria)
        instance()
        action()

    }
    private fun instance() {
        var tvRcpTitle : TextView = findViewById(R.id.title_rcp)
        tvRcpTitle.setText(rcpTitle);
        var tvRcpDesc : TextView = findViewById(R.id.tv_rcp_desc)
        tvRcpDesc.setText(rcpDesc);
        var ivRcpImage : ImageView = findViewById(R.id.iv_rcp_image)
        ivRcpImage.setImageResource(R.drawable.img_rcp)


        goBack = findViewById(R.id.goBack)
        goBack.setImageResource(R.drawable.ic_close)
        goEdit = findViewById(R.id.goEdit)
        goEdit.setImageResource(R.drawable.ic_edit)
        goToMenu = findViewById(R.id.goToMenu)
        goToMenu.setImageResource(R.drawable.ic_menu)

        goToIctus = findViewById<MaterialButton>(R.id.goToIctus)
        goToIctus.setText(nextButton)




        goToOvance =findViewById<MaterialButton>(R.id.goToOvance)
        goToOvance.setText(preButton)




    }
    private fun action() {

        goToIctus.setOnClickListener{
            val detailIT = Intent(this, DetailIctus::class.java)
            startActivity(detailIT)
        }

        goToOvance.setOnClickListener{
            val detailOV = Intent(this, DetailOvance::class.java)
            startActivity(detailOV)
        }

        goBack.setOnClickListener{
            finish()
        }

        goToMenu.setOnClickListener{
                finish()
        }

        goEdit.setOnClickListener{
            val detailOV = Intent(this, DetailOvance::class.java)
            startActivity(detailOV)
        }

    }
}