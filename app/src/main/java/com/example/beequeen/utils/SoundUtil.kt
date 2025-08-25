package com.byrevestn1k.beequeen.utils

import android.content.Context
import android.media.MediaPlayer

object SoundUtil {
    fun playSound(context: Context, resId: Int) {
        val mediaPlayer = MediaPlayer.create(context, resId)
        mediaPlayer.start()
        mediaPlayer.setOnCompletionListener { it.release() }
    }
}
