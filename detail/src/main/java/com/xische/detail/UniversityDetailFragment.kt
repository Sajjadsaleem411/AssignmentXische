package com.xische.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.xische.detail.databinding.FragmentUniversityDetailBinding


class UniversityDetailFragment : Fragment() {
    private val args: UniversityDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentUniversityDetailBinding.inflate(inflater, container, false)
        binding.item = args.detailItem
        return binding.root

    }
}