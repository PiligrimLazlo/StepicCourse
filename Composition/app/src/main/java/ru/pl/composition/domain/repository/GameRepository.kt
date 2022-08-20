package ru.pl.composition.domain.repository

import ru.pl.composition.domain.entity.GameSettings
import ru.pl.composition.domain.entity.Level
import ru.pl.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}