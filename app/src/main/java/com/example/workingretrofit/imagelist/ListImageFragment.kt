package com.example.workingretrofit.imagelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.workingretrofit.adapter.ListImageAdapter
import com.example.workingretrofit.databinding.FragmentListImageBinding


class ListImageFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentListImageBinding.inflate(inflater)


        binding.lifecycleOwner = this
        val adapter=ListImageAdapter()
        binding.listGrid.adapter=adapter

        val listImageViewModelFactory=ListImageViewModelFactory()
        val listImageViewModel:ListImageViewModel by lazy {
            ViewModelProvider(this,listImageViewModelFactory).get(ListImageViewModel::class.java) }
        binding.listImageViewModel=listImageViewModel
        listImageViewModel.getImages()

       listImageViewModel.responseFromNetWork.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
       })
        return binding.root
    }
}