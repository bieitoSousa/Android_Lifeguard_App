package com.bieitoproyect.androidlifeguardapp.dataModel

import com.bieitoproyect.androidlifeguardapp.R
import java.io.Serializable

 data class Content(val id: Int, var shortTitle: String? = null, var longTitle: String? = null, var urlShortImg: String? = null, var urlLongImg: String? = null, var desc: String? = null, var imgName: String? = null) : Serializable{
    var imgLong = arrayOf(R.drawable.img_rcp, R.drawable.img_ictus, R.drawable.img_ovace)
    var imgShort = arrayOf(R.drawable.ic_rcp, R.drawable.ic_ictus, R.drawable.ic_ovace)
    override fun toString(): String {
         return "ID ["+ id +"] shortTitle ["+ shortTitle +"]"
     }

}
