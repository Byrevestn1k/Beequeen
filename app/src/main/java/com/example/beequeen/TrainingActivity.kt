package com.byrevestn1k.beequeen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.byrevestn1k.beequeen.utils.FileUtil
import kotlinx.android.synthetic.main.activity_training.*

class TrainingActivity : AppCompatActivity() {

    private lateinit var adapter: TrainingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training)

        val images = FileUtil.loadTrainingImages(this)
        adapter = TrainingAdapter(images)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
