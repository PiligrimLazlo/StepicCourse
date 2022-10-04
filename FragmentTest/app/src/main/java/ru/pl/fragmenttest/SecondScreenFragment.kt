package ru.pl.fragmenttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import ru.pl.fragmenttest.databinding.FragmentSecondScreenBinding

class SecondScreenFragment: Fragment() {

    private var _binding: FragmentSecondScreenBinding? = null
    private val binding: FragmentSecondScreenBinding
        get() = checkNotNull(_binding) {
            "Binding must not be null!"
        }

    private lateinit var argumentText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        argumentText = arguments?.getString(ARG_TEXT_KEY) ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tv.text = argumentText
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_TEXT_KEY = "ARG_TEXT_KEY"

        fun createInstance(textArgs: String): SecondScreenFragment {
            return SecondScreenFragment().apply {
                arguments = bundleOf(ARG_TEXT_KEY to textArgs)
            }
        }
    }
}