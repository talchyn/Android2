package com.example.android2.ui.fragments.onboard.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android2.R
import com.example.android2.databinding.FragmentMainOnBoardBinding

class MainOnBoardFragment : Fragment() {

    private lateinit var binding: FragmentMainOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        when (requireArguments().getInt(AGE_ONBOARD_PAGE_POSITION)) {
            0 -> {
                binding.pagerText.text = "Очень удобный функционал"
                binding.pagerImage.setAnimation("designer.json")
            }
            1 -> {
                binding.pagerText.text = "Быстрый, качественный продукт"
                binding.pagerImage.setAnimation("product.json")
            }
            2 -> {
                binding.pagerText.text = "Куча функций и интересных фишек"
                binding.pagerImage.setAnimation("analysis.json")

            }
        }
    }
    @SuppressLint("ResourceType")
    private fun visibilityTextStartWork() {
        val statusFragment = requireArguments().getInt(AGE_ONBOARD_PAGE_POSITION)
        if(statusFragment == 2) {
            binding.textBack.visibility = View.GONE
            binding.pagerText.apply {
                visibility = View.VISIBLE
                setOnClickListener {
                    findNavController().navigate(
                        R.id.action_onBoardFragment_to_detailFragment
                    )
//                    onBoard()
                }
            }
        }else{
            binding.textBack.visibility = View.VISIBLE
            binding.pagerText.apply {
                visibility = View.VISIBLE
                setOnClickListener {
                    findNavController().navigate(
                        R.id.action_onBoardFragment_to_detailFragment
                    )
                }
            }
        }
    }


    companion object {
        const val AGE_ONBOARD_PAGE_POSITION = "onboarding_page_position"
    }


}