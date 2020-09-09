package com.rosia.promotionservice.promotion.service

import com.rosia.promotionservice.promotion.data.PromotionModel

open class Promotion : PromotionListener {

    lateinit var promotionModel: PromotionModel
    lateinit var message: String

    override fun getUpdatedPromotion(promotion: PromotionModel, message: String) {
        this.promotionModel = promotion
        this.message = message
    }
}