package com.ims.runningapp_kotlin.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.io.ByteArrayOutputStream

class Converters {

    @TypeConverter
    fun toBitmap(bytes: ByteArray): Bitmap{
        return BitmapFactory.decodeByteArray(bytes,0, bytes.size)
    }

    @TypeConverter
    fun fromBitmap(bmp: Bitmap) : ByteArray{
        val outpuutStream = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.PNG, 100, outpuutStream)
        return outpuutStream.toByteArray()

    }
}