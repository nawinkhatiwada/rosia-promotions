package com.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.service.PromotionListener

class MainActivity: AppCompatActivity(), PromotionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // pass promotion model fetched from view model
//        PromotionService(this).checkPromotion()
    }

    override fun getUpdatedPromotion(promotion: PromotionModel, message: String) {
        // getUpdate of promotion
    }
}