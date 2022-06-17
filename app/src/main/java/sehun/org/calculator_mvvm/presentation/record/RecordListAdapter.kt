package sehun.org.calculator_mvvm.presentation.record

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sehun.org.calculator_mvvm.data.Record
import sehun.org.calculator_mvvm.databinding.ItemRecordBinding

class RecordListAdapter(
    private val onRecordClick: ((Record) -> Unit)? = null
) : ListAdapter<Record, RecordListAdapter.ViewHolder>(Comparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRecordBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val record: Record = getItem(position)
        holder.bind(record, onRecordClick)
    }

    class ViewHolder(
        private val binding: ItemRecordBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(record: Record, onRecordClick: ((Record) -> Unit)? = null) {
            binding.record = record
            binding.root.setOnClickListener { onRecordClick?.invoke(record) }
        }
    }

    private class Comparator : DiffUtil.ItemCallback<Record>() {
        override fun areItemsTheSame(oldItem: Record, newItem: Record): Boolean {
            return oldItem.result == newItem.result
        }

        override fun areContentsTheSame(oldItem: Record, newItem: Record): Boolean {
            return oldItem == newItem
        }
    }
}
