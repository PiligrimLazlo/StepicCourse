package ru.pl.composition.domain.usecases

import ru.pl.composition.domain.entity.GameSettings
import ru.pl.composition.domain.entity.Level
import ru.pl.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }

}