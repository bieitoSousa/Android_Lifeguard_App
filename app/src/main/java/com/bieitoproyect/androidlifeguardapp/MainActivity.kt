package com.bieitoproyect.androidlifeguardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bieitoproyect.androidlifeguardapp.Controller.ContentController
import com.bieitoproyect.androidlifeguardapp.contentModel.ContentDetail
import com.bieitoproyect.androidlifeguardapp.dataModel.Content
import com.bieitoproyect.androidlifeguardapp.dataModel.ContentAdapter
import com.bieitoproyect.androidlifeguardapp.dataModel.OnClickListener
import com.bieitoproyect.androidlifeguardapp.databinding.ActivityMainBinding
import com.google.android.material.card.MaterialCardView
import java.io.Serializable

private const val TAG = "MyActivity"

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var cvRCP : MaterialCardView
    private lateinit var cvOvance : MaterialCardView
    private lateinit var cvIctus : MaterialCardView
    private var contentController : ContentController = ContentController()
    private lateinit var contentAdapter: ContentAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        writeContent()
    }

    private fun sendMessage(message: String) {
        Toast.makeText(this,  message, Toast.LENGTH_SHORT).show()
    }

    private fun writeContent() {

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contentAdapter = ContentAdapter(contentController.getContent(), this)
        linearLayoutManager = LinearLayoutManager(this)

        binding.content.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = contentAdapter
        }
    }

    override fun onClick(content: Content, position: Int) {
        Toast.makeText(this, "$position: ${content.shortTitle}" , Toast.LENGTH_SHORT).show()
        goToContentDetail(position)
    /*
        when (position) {
            1 -> goToRCP()
            2 ->goToICTUS()
            3 ->goToOVACE()
        }

         */
    }

   private fun goToContentDetail( position : Int){
        val intent = Intent(this, ContentDetail::class.java)
        var putExtraContent = contentController.getContent(position -1)
        Log.i("send TO ContentDetail", putExtraContent.toString())
        intent.putExtra("extra_object", putExtraContent as Serializable)
        startActivity(intent)

    }



    }