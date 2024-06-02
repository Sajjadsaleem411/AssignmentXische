package com.xische.assignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xische.assignment.databinding.ItemUniversityBinding
import com.xische.core.data.University

class UniversityAdapter(private val clickListener: (University) -> Unit) :
    ListAdapter<University, AmazonsItemViewHolder>(AmazonsItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmazonsItemViewHolder {
        return AmazonsItemViewHolder(
            ItemUniversityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AmazonsItemViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
            holder.itemView.setOnClickListener {
                clickListener(item)
            }
        }
    }

}

class AmazonsItemViewHolder(
    private val binding: ItemUniversityBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: University) {
        binding.apply {
            this.item = item
            executePendingBindings()
        }
    }
}


private class AmazonsItemDiffCallback : DiffUtil.ItemCallback<University>() {
    override fun areItemsTheSame(oldItem: University, newItem: University): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: University, newItem: University): Boolean {
        return oldItem == newItem
    }
}
