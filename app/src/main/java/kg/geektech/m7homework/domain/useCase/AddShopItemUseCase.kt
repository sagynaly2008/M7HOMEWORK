package kg.geektech.m7homework.domain.useCase

import kg.geektech.m7homework.domain.model.ShopItem
import kg.geektech.m7homework.domain.repository.ShopListRepository

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    suspend fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}