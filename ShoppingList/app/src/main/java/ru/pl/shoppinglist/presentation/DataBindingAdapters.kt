package ru.pl.shoppinglist.presentation

import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter("numberToString")
fun bindNumberToString(textInputEditText: EditText, number: Int) {
    textInputEditText.setText(number.toString())
}