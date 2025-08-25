package com.byrevestn1k.beequeen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.byrevestn1k.beequeen.utils.FileUtil
import java.io.File

class TrainingAdapter(private val images: List<File>) :
    RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder>() {

    class TrainingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.trainingImage)
        val btnQueen: Button = itemView.findViewById(R.id.btnQueen)
        val btnWorker: Button = itemView.findViewById(R.id.btnWorker)
        val btnDrone: Button = itemView.findViewById(R.id.btnDrone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout/item_training_image_mark.xml, parent, false)
        return TrainingViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        val file = images[position]
        holder.imageView.setImageURI(file.toURI())

        holder.btnQueen.setOnClickListener {
            FileUtil.markImage(file, "queen")
        }
        holder.btnWorker.setOnClickListener {
            FileUtil.markImage(file, "worker")
        }
        holder.btnDrone.setOnClickListener {
            FileUtil.markImage(file, "drone")
        }
    }

    override fun getItemCount(): Int = images.size
}
