package com.byrevestn1k.beequeen.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageFormat
import android.media.Image
import android.os.Environment
import androidx.camera.core.ImageProxy
import java.io.File
import java.io.FileOutputStream
import java.nio.ByteBuffer

object FileUtil {

    fun saveImage(context: Context, imageProxy: ImageProxy, label: String, filename: String) {
        val bitmap = imageProxy.toBitmap() ?: return
        val dir = File(context.filesDir, "training_images/$label")
        if (!dir.exists()) dir.mkdirs()
        val file = File(dir, filename)
        val fos = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fos)
        fos.flush()
        fos.close()
    }

    private fun ImageProxy.toBitmap(): Bitmap? {
        val plane = planes[0]
        val buffer: ByteBuffer = plane.buffer
        val bytes = ByteArray(buffer.remaining())
        buffer.get(bytes)
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }
}
