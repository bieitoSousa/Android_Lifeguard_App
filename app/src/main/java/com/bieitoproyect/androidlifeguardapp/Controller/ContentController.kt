package com.bieitoproyect.androidlifeguardapp.Controller

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat
import com.bieitoproyect.androidlifeguardapp.contentModel.ContentDetail
import com.bieitoproyect.androidlifeguardapp.dataModel.Content
import java.io.Serializable
import androidx.core.content.ContextCompat.startActivity

class ContentController {

    var contentList : MutableList<Content> = startContent()

     fun startContent(): MutableList<Content> {
        val content = mutableListOf<Content>()

        val rcp = Content(
                1,
                "RCP",
                "Reanimación Cardio Respiratoría",
                "https://previews.123rf.com/images/momoforsale/momoforsale1705/momoforsale170500075/77463516-rcp-o-icono-de-vector-de-resucitaci%C3%B3n-cardiopulmonar.jpg",
                "",
                "",
                "img_rcp"

        )
        val ictus = Content(
                2,
                "ICTUS",
                "interrupción súbita del flujo sanguíneo a una parte del cerebro",
                "https://st2.depositphotos.com/1393072/46294/v/600/depositphotos_462947296-stock-illustration-stroke-line-icon-human-diseases.jpg",
                "https://st2.depositphotos.com/1393072/46294/v/600/depositphotos_462947296-stock-illustration-stroke-line-icon-human-diseases.jpg",
                "",
                "img_ictus"
        )
        val ovance = Content(
                3,
                "OVACE",
                "Obstrucción de las vía aérea",
                "https://st2.depositphotos.com/4297405/8094/v/950/depositphotos_80947822-stock-illustration-first-aid-scene-illustration-shows.jpg",
                "https://st2.depositphotos.com/4297405/8094/v/950/depositphotos_80947822-stock-illustration-first-aid-scene-illustration-shows.jpg",
                "",
                "img_ovace"
        )

        content.add(rcp)
        content.add(ictus)
        content.add(ovance)

        return content
    }

    fun getContent( ) : MutableList<Content> {
        return contentList
    }

    fun getContent( pos : Int) : Content{
        return contentList[pos]
    }

    fun getNextContent(pos : Int) : Content{
        return if(pos < contentList.size-1 )
            contentList[pos+1]
        else
            contentList[0]
    }

    fun getPreContent(pos : Int) : Content{
        return if (pos > 0 )
            contentList[pos-1]
        else
            contentList[contentList.size -1]
    }

    fun getNextContentName(pos:Int): String ? {
        return getNextContent(pos).shortTitle
    }
    fun getPreContentName(pos:Int): String ?{
        return getPreContent(pos).shortTitle
    }

}