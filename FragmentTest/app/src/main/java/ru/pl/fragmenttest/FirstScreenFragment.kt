package ru.pl.fragmenttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import ru.pl.fragmenttest.databinding.FragmentFirstScreenBinding
import ru.pl.fragmenttest.databinding.FragmentSecondScreenBinding

class FirstScreenFragment : Fragment() {

    private var _binding: FragmentFirstScreenBinding? = null
    private val binding: FragmentFirstScreenBinding
        get() = checkNotNull(_binding) {
            "Binding must not be null!"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            button.setOnClickListener {
                val text = et.text.toString()
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container ,SecondScreenFragment.createInstance(text))
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}