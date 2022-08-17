package ru.pl.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import ru.pl.shoppinglist.data.ShopListRepositoryImpl
import ru.pl.shoppinglist.domain.DeleteShopItemUseCase
import ru.pl.shoppinglist.domain.EditShopItemUseCase
import ru.pl.shoppinglist.domain.GetShopListUseCase
import ru.pl.shoppinglist.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}