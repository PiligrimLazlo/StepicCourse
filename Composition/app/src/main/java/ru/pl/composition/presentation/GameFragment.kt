package ru.pl.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.pl.composition.R
import ru.pl.composition.databinding.FragmentGameBinding
import ru.pl.composition.domain.entity.GameResult
import ru.pl.composition.domain.entity.GameSettings
import ru.pl.composition.domain.entity.Level
import ru.pl.composition.domain.entity.Question

class GameFragment : Fragment() {

    private lateinit var level: Level
    private lateinit var gameViewModel: GameViewModel

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = checkNotNull(_binding) {
            getString(R.string.binding_null_error)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gameViewModel = ViewModelProvider(this)[GameViewModel::class.java]

        binding.tvSum.setOnClickListener {
            launchGameFinishedFragment(
                GameResult(
                    true, 10, 20,
                    GameSettings(
                        1, 1,
                        1, 1
                    )
                )
            )
        }
    }

    private fun launchGameFinishedFragment(gameResult: GameResult) {
        //requireActivity().supportFragmentManager.popBackStack()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, GameFinishedFragment.newInstance(gameResult))
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseArgs() {
        requireArguments().getParcelable<Level>(KEY_LEVEL)?.let { level = it }
    }

    companion object {
        private const val KEY_LEVEL = "KEY_LEVEL"
        const val NAME = "GameFragment"

        fun newInstance(level: Level): GameFragment {
            return GameFragment().apply {
                arguments = bundleOf(
                    KEY_LEVEL to level
                )
            }
        }
    }
}
