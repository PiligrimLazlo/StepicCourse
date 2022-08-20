package ru.pl.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import ru.pl.composition.R
import ru.pl.composition.databinding.FragmentGameBinding
import ru.pl.composition.domain.entity.Level

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = checkNotNull(_binding) {
            getString(R.string.binding_null_error)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val KEY_LEVEL = "KEY_LEVEL"

        fun newInstance(level: Level): GameFragment {
            return GameFragment().apply {
                arguments = bundleOf(
                    
                )
            }
        }
    }
}
