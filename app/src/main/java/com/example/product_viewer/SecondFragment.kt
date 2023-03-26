package com.example.product_viewer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.product_viewer.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        init()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // bundle.putString("product_id",product.id)
        //        bundle.putString("title",product.headerText)
        //        bundle.putString("subhead",product.subheadText)

        val buttonId = arguments?.getString("product_id")
        val subhead = arguments?.getString("title")
        val title = arguments?.getString("subhead")
        view.findViewById<Button>(R.id.card_id_btn).text = "id кнопки " + buttonId
        view.findViewById<TextView>(R.id.text).text = subhead
        view.findViewById<TextView>(R.id.subhead).text = title
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun init(){
        binding.productToolbar.setNavigationOnClickListener { findNavController().popBackStack() }
        binding.switchColor.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.textLayout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.purple_200))
            } else {
                binding.textLayout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.purple_300))
            }
        })
    }
}