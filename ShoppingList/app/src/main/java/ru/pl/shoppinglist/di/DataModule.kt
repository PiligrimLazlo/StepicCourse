package ru.pl.shoppinglist.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.pl.shoppinglist.data.AppDatabase
import ru.pl.shoppinglist.data.ShopListDao
import ru.pl.shoppinglist.data.ShopListRepositoryImpl
import ru.pl.shoppinglist.domain.ShopListRepository

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindRepository(shopListRepositoryImpl: ShopListRepositoryImpl): ShopListRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideShopListDao(application: Application): ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }
    }

}