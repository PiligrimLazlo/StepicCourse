package ru.pl.shoppinglist

import android.app.Application
import ru.pl.shoppinglist.di.DaggerApplicationComponent

class ShopListApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

}