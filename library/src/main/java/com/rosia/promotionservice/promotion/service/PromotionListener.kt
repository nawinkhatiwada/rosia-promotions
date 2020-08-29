package com.rosia.promotionservice.promotion.service

import com.rosia.promotionservice.promotion.data.PromotionModel

interface PromotionListener {
    fun getUpdatedPromotion(promotion: PromotionModel, message: String)
}