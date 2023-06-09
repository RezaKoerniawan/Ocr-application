package com.reza.ocrapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.reza.ocrapplication.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        if (arguments != null) {
            binding.image.setImageBitmap(requireArguments().getParcelable("image"))
            binding.textviewResultOcr.setText(requireArguments().getString("ocr_text"))
            binding.textviewDistanceLocation.setText(requireArguments().getString("lat"))
            binding.textviewEstimateTime.setText(requireArguments().getString("long"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}