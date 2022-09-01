package ru.pl.factorialtest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import java.math.BigInteger
import kotlin.concurrent.thread
import kotlin.coroutines.suspendCoroutine

class MainViewModel : ViewModel() {

    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state

    private val myCoroutineScope = CoroutineScope(
        Dispatchers.Main + CoroutineName("myCoroutineScope")
    )

    fun calculate(value: String?) {
        _state.value = Progress
        if (value.isNullOrBlank()) {
            _state.value = Error
            return
        }
        myCoroutineScope.launch {
            val number = value.toLong()
            val result = factorial(number)
            _state.value = Factorial(result)
            Log.d("MainViewModel", coroutineContext.toString())
        }
    }

    private suspend fun factorial(number: Long): String {
        return withContext(Dispatchers.Default) {
            var result = BigInteger.ONE
            for (i in 1..number) {
                result = result.multiply(BigInteger.valueOf(i))
            }
            result.toString()
        }
    }

//    private suspend fun factorial(number: Long): String {
//        return suspendCoroutine {
//            thread {
//                var result = BigInteger.ONE
//                for (i in 1..number) {
//                    result = result.multiply(BigInteger.valueOf(i))
//                }
//                it.resumeWith(Result.success(result.toString()))
//            }
//        }
//    }

    override fun onCleared() {
        super.onCleared()
        myCoroutineScope.cancel()
    }
}