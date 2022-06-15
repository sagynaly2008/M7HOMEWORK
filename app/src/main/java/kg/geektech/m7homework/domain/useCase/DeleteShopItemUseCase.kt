package kg.geektech.m7homework.domain.useCase

import kg.geektech.m7homework.domain.model.ShopItem
import kg.geektech.m7homework.domain.repository.ShopListRepository

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    suspend fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}