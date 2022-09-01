package ru.pl.factorialtest

sealed class State

object Error : State()
object Progress : State()
class Factorial(val value: String): State()