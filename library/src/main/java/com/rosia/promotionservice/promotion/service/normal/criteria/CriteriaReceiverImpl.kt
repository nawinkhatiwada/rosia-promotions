package com.rosia.promotionservice.promotion.service.normal.criteria

import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.service.PromotionConstant
import com.rosia.promotionservice.promotion.service.PromotionListener
import com.rosia.promotionservice.promotion.service.checkMOQValidation
import com.rosia.promotionservice.promotion.service.normal.criteria.operator.OperatorHandler
import com.rosia.promotionservice.promotion.service.normal.disbursement.DisbursementReceiverImpl
import com.rosia.promotionservice.promotion.service.normal.disbursement.commands.amount.AmountWithCriteriaAmountCommand
import com.rosia.promotionservice.promotion.service.normal.disbursement.commands.amount.AmountWithCriteriaCountCommand
import com.rosia.promotionservice.promotion.service.normal.disbursement.commands.amount.AmountWithCriteriaQuantityCommand
import com.rosia.promotionservice.promotion.service.normal.disbursement.commands.freesku.FreeSkuWithCriteriaAmountCommand
import com.rosia.promotionservice.promotion.service.normal.disbursement.commands.freesku.FreeSkuWithCriteriaCountCommand
import com.rosia.promotionservice.promotion.service.normal.disbursement.commands.freesku.FreeSkuWithCriteriaQuantityCommand
import com.rosia.promotionservice.promotion.service.normal.disbursement.commands.percent.PercentCommand

class CriteriaReceiverImpl(private val listener: PromotionListener) : CriteriaReceiver {

    private val disbReceiver = DisbursementReceiverImpl(listener)

    override fun handleAmountCriteriaUseCase(promotion: PromotionModel): Boolean {
        val isValidMoq = checkMOQValidation(promotion)
        if (isValidMoq.first) {
            val totalAmount = promotion.skuList.sumByDouble { promotionSkuModel ->
                promotionSkuModel.batchList?.first { it.isSelected }?.rlp?.times(
                    promotionSkuModel.quantity
                ) ?: 0.0
            }

            val isValid = OperatorHandler.isCriteriaValid(
                totalAmount,
                promotion.criteriaMinValue.toDouble(),
                promotion.criteriaMinOpr,
                promotion.criteriaMaxValue.toDouble(),
                promotion.criteriaMaxOpr
            )

            if (isValid) {
                when (promotion.disbursementType) {
                    PromotionConstant.DISBURSEMENT_PERCENT -> PercentCommand(
                        disbReceiver,
                        promotion
                    ).execute()
                    PromotionConstant.DISBURSEMENT_AMOUNT -> AmountWithCriteriaAmountCommand(
                        disbReceiver,
                        promotion
                    ).execute()
                    PromotionConstant.DISBURSEMENT_FREE_SKU -> FreeSkuWithCriteriaAmountCommand(
                        disbReceiver,
                        promotion
                    ).execute()
                }
                return true
            } else {
                promotion.isApplied = false
                listener.getUpdatedPromotion(
                    promotion,
                    PromotionConstant.AMOUNT_CRITERIA_NOT_SATISFIED
                )
                return false
            }
        } else {
            promotion.isApplied = false
            listener.getUpdatedPromotion(promotion, isValidMoq.second)
            return false
        }
    }

    override fun handleQuantityCriteriaUseCase(promotion: PromotionModel): Boolean {
        val isValidMoq = checkMOQValidation(promotion)
        if (isValidMoq.first) {
//            val listOfApplicableSku = promotion.applicableSkuIds?.split(',')?.map { it.toLong() } ?: listOf()
            val listOfApplicableSku = promotion.applicableSkuModelList?.map { it.skuId }?: emptyList()
            val applicableSkuModel = promotion.skuList.filter { it.skuId in listOfApplicableSku }
            val selectedSkuCount = applicableSkuModel.count { it.quantity > 0 }

            if (selectedSkuCount >= promotion.skuCount) {
                val totalQuantity = applicableSkuModel.sumBy { it.quantity }
                val isValid = OperatorHandler.isCriteriaValid(
                    totalQuantity.toDouble(),
                    promotion.criteriaMinValue.toDouble(),
                    promotion.criteriaMinOpr,
                    promotion.criteriaMaxValue.toDouble(),
                    promotion.criteriaMaxOpr
                )

                if (isValid) {
                    when (promotion.disbursementType) {
                        PromotionConstant.DISBURSEMENT_PERCENT -> PercentCommand(
                            disbReceiver,
                            promotion
                        ).execute()
                        PromotionConstant.DISBURSEMENT_AMOUNT -> AmountWithCriteriaQuantityCommand(
                            disbReceiver,
                            promotion
                        ).execute()
                        PromotionConstant.DISBURSEMENT_FREE_SKU -> FreeSkuWithCriteriaQuantityCommand(
                            disbReceiver,
                            promotion
                        ).execute()
                    }
                } else {
                    promotion.isApplied = false
                    listener.getUpdatedPromotion(
                        promotion,
                        PromotionConstant.QUANTITY_CRITERIA_NOT_SATISFIED
                    )
                    return false
                }
            } else {
                promotion.isApplied = false
                listener.getUpdatedPromotion(
                    promotion,
                    PromotionConstant.QUANTITY_CRITERIA_NOT_SATISFIED
                )
                return false
            }
            return true
        } else {
            promotion.isApplied = false
            listener.getUpdatedPromotion(
                promotion,
                isValidMoq.second // Validation failed reason
            )
            return false
        }
    }

    override fun handleCountCriteriaUseCase(promotion: PromotionModel): Boolean {
        val isValidMoq = checkMOQValidation(promotion)
        if (isValidMoq.first) {
            val selectedSkuCount = promotion.skuList.count { it.quantity > 0 }
            if (selectedSkuCount >= promotion.skuCount) {
                val isValid = OperatorHandler.isCriteriaValid(
                    selectedSkuCount.toDouble(),
                    promotion.criteriaMinValue.toDouble(),
                    promotion.criteriaMinOpr,
                    promotion.criteriaMaxValue.toDouble(),
                    promotion.criteriaMaxOpr
                )

                if (isValid) {
                    when (promotion.disbursementType) {
                        PromotionConstant.DISBURSEMENT_PERCENT -> PercentCommand(
                            disbReceiver,
                            promotion
                        ).execute()
                        PromotionConstant.DISBURSEMENT_AMOUNT -> AmountWithCriteriaCountCommand(
                            disbReceiver,
                            promotion
                        ).execute()
                        PromotionConstant.DISBURSEMENT_FREE_SKU -> FreeSkuWithCriteriaCountCommand(
                            disbReceiver,
                            promotion
                        ).execute()
                    }
                } else {
                    promotion.isApplied = false
                    listener.getUpdatedPromotion(
                        promotion,
                        PromotionConstant.COUNT_CRITERIA_NOT_SATISFIED
                    )
                    return false
                }
            } else {
                promotion.isApplied = false
                listener.getUpdatedPromotion(promotion, PromotionConstant.COUNT_CRITERIA_NOT_SATISFIED)
                return false
            }
        } else {
            promotion.isApplied = false
            listener.getUpdatedPromotion(
                promotion,
                isValidMoq.second
            )
        }
        return true
    }
}