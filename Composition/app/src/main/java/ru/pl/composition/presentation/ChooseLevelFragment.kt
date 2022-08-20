package ru.pl.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.pl.composition.R
import ru.pl.composition.databinding.FragmentChooseLevelBinding
import ru.pl.composition.databinding.FragmentGameFinishedBinding

class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = checkNotNull(_binding) {
            getString(R.string.binding_null_error)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance(): ChooseLevelFragment {
            return ChooseLevelFragment()
        }

    }
}
