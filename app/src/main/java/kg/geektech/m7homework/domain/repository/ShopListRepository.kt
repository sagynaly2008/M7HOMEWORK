package kg.geektech.m7homework.domain.repository

import androidx.lifecycle.LiveData
import kg.geektech.m7homework.domain.model.ShopItem

interface ShopListRepository { //типо кнопки
    suspend fun addShopItem(shopItem: ShopItem)
    suspend fun deleteShopItem(shopItem: ShopItem)
    suspend fun editShopItem(shopItem: ShopItem)
    suspend fun getShopItem(shopItemId: Int): ShopItem
    fun getShopList(): LiveData<List<ShopItem>>
}