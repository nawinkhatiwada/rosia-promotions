package com.rosia.promotionservice.promotion.service.normal.type

import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.service.PromotionConstant
import com.rosia.promotionservice.promotion.service.PromotionListener
import com.rosia.promotionservice.promotion.service.normal.criteria.CriteriaReceiverImpl
import com.rosia.promotionservice.promotion.service.normal.criteria.commands.*

class TypeReceiverImpl(private val listener: PromotionListener) : TypeReceiver {

    private val criteriaReceiverImpl = CriteriaReceiverImpl(listener)

    override fun handleNormalUseCase(promotion: PromotionModel): Boolean {
        return when (promotion.criteriaType) {
            PromotionConstant.CRITERIA_AMOUNT -> AmountCommand(criteriaReceiverImpl, promotion).execute()
            PromotionConstant.CRITERIA_QUANTITY -> QuantityCommand(criteriaReceiverImpl, promotion).execute()
            PromotionConstant.CRITERIA_COUNT_MULTIPLE -> CountMultipleCommand(criteriaReceiverImpl, promotion).execute()
            PromotionConstant.CRITERIA_GROUP_COUNT -> GroupCountCommand(criteriaReceiverImpl, promotion).execute()
            PromotionConstant.CRITERIA_GROUP_COUNT_MULTIPLE -> GroupCountMultipleCommand(criteriaReceiverImpl, promotion).execute()
            else -> CountCommand(criteriaReceiverImpl, promotion).execute()
        }
    }
}