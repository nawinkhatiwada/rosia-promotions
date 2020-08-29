package com.rosia.promotionservice.promotion.service.bill.type

import com.rosia.promotionservice.promotion.data.PromotionModel

interface TypeReceiver {

    fun handleCurrentBillUseCase(promotion: PromotionModel): Boolean
    fun handleNextBillUseCase(promotion: PromotionModel): Boolean
}