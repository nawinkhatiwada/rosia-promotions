package com.rosia.promotionservice.promotion.service.normal.disbursement

import com.rosia.promotionservice.promotion.data.PromotionModel

interface DisbursementReceiver {

    fun handleAmountWithCriteriaCountUseCase(promotion: PromotionModel)
    fun handleAmountWithCriteriaAmountUseCase(promotion: PromotionModel)
    fun handleAmountWithCriteriaQuantityUseCase(promotion: PromotionModel)

    fun handlePercentUseCase(promotion: PromotionModel)

    fun handleFreeSkuWithCriteriaQuantityUseCase(promotion: PromotionModel)
    fun handleFreeSkuWithCriteriaAmountUseCase(promotion: PromotionModel)
    fun handleFreeSkuWithCriteriaCountUseCase(promotion: PromotionModel)

    fun handlePercentWithCriteriaMultipleAmount(promotion: PromotionModel)
    fun handlePercentWithCriteriaGroupCountMultipleAmount(promotion: PromotionModel)
}