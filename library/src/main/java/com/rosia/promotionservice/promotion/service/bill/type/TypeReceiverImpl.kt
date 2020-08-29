package com.rosia.promotionservice.promotion.service.bill.type

import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.service.PromotionConstant
import com.rosia.promotionservice.promotion.service.PromotionListener
import com.rosia.promotionservice.promotion.service.bill.criteria.CriteriaReceiverImpl
import com.rosia.promotionservice.promotion.service.bill.criteria.commands.*

class TypeReceiverImpl(private val listener: PromotionListener) : TypeReceiver {

    private val criteriaReceiverImpl = CriteriaReceiverImpl(listener)

    override fun handleCurrentBillUseCase(promotion: PromotionModel): Boolean {
        return when (promotion.criteriaType) {
            PromotionConstant.CRITERIA_AMOUNT -> AmountCommand(criteriaReceiverImpl, promotion).execute()
            PromotionConstant.CRITERIA_QUANTITY -> QuantityCommand(criteriaReceiverImpl, promotion).execute()
            PromotionConstant.CRITERIA_COUNT -> CountCommand(criteriaReceiverImpl, promotion).execute()
            PromotionConstant.CRITERIA_GROUP_COUNT -> GroupCountCommand(criteriaReceiverImpl, promotion).execute()
            PromotionConstant.CRITERIA_GROUP_COUNT_MULTIPLE -> GroupCountMultipleCommand(criteriaReceiverImpl, promotion).execute()
            else -> CountMultipleCommand(criteriaReceiverImpl, promotion).execute()
        }
    }

    override fun handleNextBillUseCase(promotion: PromotionModel): Boolean {
        return when (promotion.criteriaType) {
            PromotionConstant.CRITERIA_AMOUNT -> AmountCommand(criteriaReceiverImpl, promotion).execute()
            PromotionConstant.CRITERIA_QUANTITY -> QuantityCommand(criteriaReceiverImpl, promotion).execute()
            else -> CountCommand(criteriaReceiverImpl, promotion).execute()
        }
    }
}