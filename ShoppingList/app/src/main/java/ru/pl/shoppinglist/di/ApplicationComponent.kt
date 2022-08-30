package ru.pl.shoppinglist.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.pl.shoppinglist.presentation.MainActivity
import ru.pl.shoppinglist.presentation.ShopItemFragment

@ApplicationScope
@Component(modules = [ViewModelModule::class, DataModule::class])
interface ApplicationComponent {

    fun inject(shopItemFragment: ShopItemFragment)

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent

    }

}