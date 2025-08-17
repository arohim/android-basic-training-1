package com.him.mobile.android_basic_sharing_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.him.mobile.android_basic_sharing_1.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {

    private lateinit var binding: FragmentBlank2Binding

    private val args by navArgs<BlankFragment2Args>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlank2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView3.text = args.param1
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}