package com.example.android2.ui.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android2.R
import com.example.android2.databinding.FragmentDetailBinding
import com.example.android2.extensions.setBackStackData

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendNote()
    }

    private fun sendNote() {
        binding.textConfirmNote.setOnClickListener(){
            setBackStackData("key", binding.textNote.text.toString(), true)
        }
    }
}