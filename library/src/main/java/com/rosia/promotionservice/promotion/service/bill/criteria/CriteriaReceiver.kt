package com.rosia.promotionservice.promotion.service.bill.criteria

import com.rosia.promotionservice.promotion.data.PromotionModel

interface CriteriaReceiver {
    fun handleAmountCriteriaUseCase(promotion: PromotionModel): Boolean
    fun handleQuantityCriteriaUseCase(promotion: PromotionModel): Boolean
    fun handleCountCriteriaUseCase(promotion: PromotionModel): Boolean
    fun handleCountMultipleCriteriaUseCase(promotion: PromotionModel): Boolean
    fun handleGroupCountCriteriaUseCase(promotion: PromotionModel): Boolean
    fun handleGroupCountMultipleCriteriaUseCase(promotion: PromotionModel): Boolean
}