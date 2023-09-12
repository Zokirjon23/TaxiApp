package uz.uzbekcard.taxiapp.source.local

import android.content.Context

class Storage(private val context: Context) {

   private val shp = context.getSharedPreferences("storage",Context.MODE_PRIVATE)
   private val editor = shp.edit()

    var token : String? get() { return shp.getString("token",null) }
        set(value) = editor.putString("token",value).apply()
}