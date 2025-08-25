package com.byrevestn1k.beequeen

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.byrevestn1k.beequeen.utils.FileUtil
import com.byrevestn1k.beequeen.utils.ModelUtil
import com.byrevestn1k.beequeen.utils.SoundUtil
import kotlinx.android.synthetic.main.activity_live_detection.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class LiveDetectionActivity : AppCompatActivity() {

    private lateinit var cameraExecutor: ExecutorService
    private val model by lazy { ModelUtil.loadModel(this) }
    private val lastFrames = mutableListOf<ImageProxy>()
    private val MAX_FRAMES = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_detection)

        if (allPermissionsGranted()) {
            startCamera()
        } else {
            ActivityCompat.requestPermissions(
                this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
            )
        }

        cameraExecutor = Executors.newSingleThreadExecutor()

        btnCorrect.setOnClickListener {
