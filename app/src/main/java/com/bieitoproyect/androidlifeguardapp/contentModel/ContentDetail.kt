package com.bieitoproyect.androidlifeguardapp.contentModel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bieitoproyect.androidlifeguardapp.Controller.ContentController
import com.bieitoproyect.androidlifeguardapp.R
import com.bieitoproyect.androidlifeguardapp.dataModel.Content
import com.google.android.material.button.MaterialButton
import java.io.Serializable

class ContentDetail () : AppCompatActivity() {
    private var contentController : ContentController = ContentController()

    private lateinit var goBack : ImageButton
    private lateinit var goToMenu : ImageButton
    private lateinit var goEdit : ImageButton



    private lateinit var goToNext : MaterialButton
    private lateinit var goToPre : MaterialButton


    private var nextButton = R.string.ICTUS_short
    private var preButton = R.string.OVACE_short

    private var rcpDesc = R.string.rcp_desc
    private var rcpTitle = R.string.RCP
    private var content : Content? = null
    private var title : String ? = null
    private var desc : String ? = null

    var  imgLong = arrayOf( R.drawable.img_rcp,R.drawable.img_ictus,R.drawable.img_ovace)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_detail)
        content = intent.extras?.get("extra_object") as Content
        Log.i("rewed IN ContentDetail", content.toString())
        instance(content!!)

    }
    private fun instance(c : Content) {
            var tvRcpTitle: TextView = findViewById(R.id.title_rcp)
            tvRcpTitle.setText(c.longTitle);
            var tvRcpDesc: TextView = findViewById(R.id.tv_rcp_desc)
            tvRcpDesc.setText(c.desc);
            var ivRcpImage: ImageView = findViewById(R.id.iv_rcp_image)
            ivRcpImage.setImageResource(imgLong[c.id -1])
            goBack = findViewById(R.id.goBack)
            goBack.setImageResource(R.drawable.ic_close)
            goEdit = findViewById(R.id.goEdit)
            goEdit.setImageResource(R.drawable.ic_edit)
            goToMenu = findViewById(R.id.goToMenu)
            goToMenu.setImageResource(R.drawable.ic_menu)
            goToNext = findViewById<MaterialButton>(R.id.goToNext)
            goToNext.setText(contentController.getNextContentName(c.id -1))
            goToPre = findViewById<MaterialButton>(R.id.goToPre)
            goToPre.setText(contentController.getPreContentName(c.id -1))

    }
    private fun action() {
        goToNext.setOnClickListener{
            val intent = Intent(this, ContentDetail::class.java)
            var putExtraContent = contentController.getNextContent(content!!.id -1)
            Log.i("goToNext", putExtraContent.toString())
            intent.putExtra("extra_object", putExtraContent as Serializable)
            startActivity(intent)
        }

        goToPre.setOnClickListener{
            val intent = Intent(this, ContentDetail::class.java)
            var putExtraContent = contentController.getPreContent(content!!.id -1)
            Log.i("goToPre", putExtraContent.toString())
            intent.putExtra("extra_object", putExtraContent as Serializable)
            startActivity(intent)
        }

        goBack.setOnClickListener{
            finish()
            finishActivity(0)
            Log.i("goBack", "cerrar")
        }

        goToMenu.setOnClickListener{
            finish()
            finishActivity(0)
            Log.i("goToMenu", "ir al menu")
        }

        goEdit.setOnClickListener{

        }

    }

}