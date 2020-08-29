package com.rosia.promotionservice.promotion.service.normal.type

import com.rosia.promotionservice.promotion.data.PromotionModel

interface TypeReceiver {
    fun handleNormalUseCase(promotion: PromotionModel): Boolean
}