package com.rosia.promotionservice.promotion.service.bill.disbursement

import com.rosia.promotionservice.promotion.data.PromotionModel


interface DisbursementReceiver {
    fun handleBillAmountUseCase(promotion: PromotionModel)
    fun handleBillPercentUseCase(promotion: PromotionModel)
    fun handleBillFreeSkuUseCase(promotion: PromotionModel)
    fun handleBillPercentWithCriteriaMultipleAmount(promotion: PromotionModel)
    fun handleBillPercentWithCriteriaGroupCountMultipleAmount(promotion: PromotionModel)
}