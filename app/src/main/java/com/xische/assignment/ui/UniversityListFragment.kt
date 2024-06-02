package com.xische.assignment.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.xische.assignment.DefaultMainViewModel
import com.xische.assignment.R
import com.xische.assignment.databinding.FragmentUniversityListBinding
import com.xische.assignment.ui.adapter.UniversityAdapter
import com.xische.core.data.University
import com.xische.core.models.Status
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UniversityListFragment : Fragment() {

    private val viewModel: DefaultMainViewModel by viewModels()
    private val adapter: UniversityAdapter = UniversityAdapter(::moveToNext)
    private lateinit var binding: FragmentUniversityListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUniversityListBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.adapter = adapter
        binding.lifecycleOwner = viewLifecycleOwner

        setupData()
        return binding.root
    }

    private fun setupData() {
        initFlow()
        viewModel.getUniversities()
    }

    private fun initFlow() {
        lifecycleScope.launch {
            viewModel.res.collectLatest {
                // Checking the results
                when (it.status) {
                    Status.LOADING -> {
                        binding.loader
                        binding.apply {
                            rvUniversity.visibility = View.GONE
                            loader.visibility = View.VISIBLE
                            tvError.visibility = View.GONE
                        }
                    }

                    Status.SUCCESS -> {
                        it.data?.let { data ->
                            adapter.submitList(data)
                        }
                        binding.apply {
                            rvUniversity.visibility = View.VISIBLE
                            loader.visibility = View.GONE
                            tvError.visibility = View.GONE
                        }
                    }

                    Status.ERROR -> {
                        binding.apply {
                            rvUniversity.visibility = View.GONE
                            loader.visibility = View.GONE
                            tvError.visibility = View.VISIBLE
                        }
                    }
                }
                Log.d("dataUpdate: ", it.toString())
            }
        }
    }

    private fun moveToNext(item: University) {
    }
}