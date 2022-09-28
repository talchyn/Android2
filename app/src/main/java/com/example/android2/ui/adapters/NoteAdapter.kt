package com.example.android2.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android2.databinding.ItemNoteBinding
import com.example.android2.R
import com.example.android2.model.NoteModel

class NoteAdapter(
    private var list:ArrayList<NoteModel>
): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    class ViewHolder (item: View):RecyclerView.ViewHolder(item) {
        private val binding = ItemNoteBinding.bind(item)
        fun onBind(noteModel: NoteModel) {
            binding.itemTitle.text = noteModel.title

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}