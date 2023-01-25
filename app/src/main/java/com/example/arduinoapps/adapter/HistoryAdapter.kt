package com.example.arduinoapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.arduinoapps.databinding.ListHistoryBinding
import com.example.arduinoapps.model.History
import com.example.arduinoapps.model.Tips
import java.util.ArrayList

class HistoryAdapter (private val listHistory : ArrayList<History>,
                      val listener : HistoryAdapter.onTipsClick): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    inner class HistoryViewHolder(val binding: ListHistoryBinding) : RecyclerView.ViewHolder(binding.root)

    class onTipsClick {
        fun onHistoryClickListener(history: History) {
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(ListHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HistoryAdapter.HistoryViewHolder, position: Int) {
        holder.binding.apply {
            Heartrate.text = listHistory[position].heartRate.toString()
            TVHeartrate.text = listHistory[position].heartRate.toString()
        }

        holder.itemView.setOnClickListener {
            listener.onHistoryClickListener(listHistory[position])
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}