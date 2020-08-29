package com.rosia.promotionservice.promotion

import java.io.Serializable

/**
 * Please use mapper for PromotionSkuModel.
 * Do not directly use getListItemType() in your views.
 * */
@Deprecated("This class will be removed in future releases.")
interface ListItem : Serializable {
    companion object {
        const val BODY = 2
    }
    @Deprecated("Will be removed in future releases.")
    fun getListItemType(): Int
}