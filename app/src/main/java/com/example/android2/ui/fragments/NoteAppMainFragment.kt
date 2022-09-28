package com.example.android2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android2.R
import com.example.android2.databinding.FragmentNoteAppMainBinding
import com.example.android2.extensions.getBackStackData
import com.example.android2.model.NoteModel
import com.example.android2.ui.adapters.NoteAdapter

class NoteAppMainFragment : Fragment() {

    private lateinit var binding: FragmentNoteAppMainBinding
    private var listNote: ArrayList<NoteModel> = ArrayList()
    private val adapter = NoteAdapter(listNote)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteAppMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRecyclerView()
        addNoteListener()
        addNoteToList()

    }


    private fun addNoteListener() {
        binding.buttonAddNote.setOnClickListener(){
            findNavController().navigate(NoteAppMainFragmentDirections.actionNoteAppMainFragmentToDetailFragment())
        }

    }

    private fun addNoteToList() {
        getBackStackData<String>("key") {
            listNote.add(NoteModel(it))
        }
    }

    private fun initializeRecyclerView() {
        binding.recycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.recycleView.adapter = adapter
    }

//    private fun updateList() {
//        adapter.setUpAdapter(listNote)
//        adapter.notifyDataSetChanged()
//    }
}




