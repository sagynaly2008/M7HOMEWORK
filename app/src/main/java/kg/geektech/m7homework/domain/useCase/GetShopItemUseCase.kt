package kg.geektech.m7homework.domain.useCase

import kg.geektech.m7homework.domain.model.ShopItem
import kg.geektech.m7homework.domain.repository.ShopListRepository

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    suspend fun getShopItem(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItem(shopItemId)
    }
}