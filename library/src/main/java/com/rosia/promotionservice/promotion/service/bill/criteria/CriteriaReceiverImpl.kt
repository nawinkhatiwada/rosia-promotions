package com.rosia.promotionservice.promotion.service.bill.criteria

import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.service.PromotionConstant
import com.rosia.promotionservice.promotion.service.PromotionListener
import com.rosia.promotionservice.promotion.service.bill.criteria.operator.OperatorHandler
import com.rosia.promotionservice.promotion.service.bill.disbursement.DisbursementReceiverImpl
import com.rosia.promotionservice.promotion.service.bill.disbursement.commands.*
import com.rosia.promotionservice.promotion.service.checkGroupMOQValidation
import com.rosia.promotionservice.promotion.service.checkMOQValidation

class CriteriaReceiverImpl(private val listener: PromotionListener) : CriteriaReceiver {

    private val disbursementReceiverImpl = DisbursementReceiverImpl(listener)

    override fun handleAmountCriteriaUseCase(promotion: PromotionModel): Boolean {
        val isValidMoq = checkMOQValidation(promotion)
        if (isValidMoq.first) {
            var listOfApplicableSku =
                promotion.applicableSkuModelList?.map { it.skuId }
            if (listOfApplicableSku.isNullOrEmpty()) {
                listOfApplicableSku = promotion.skuList.map { it.skuId }
            }
            val applicableSkuModel = promotion.skuList.filter { it.skuId in listOfApplicableSku }
            val totalAmount = applicableSkuModel.sumByDouble { it.taxableAmount + it.topUpDiscount }
            val isValid = OperatorHandler.isCriteriaValid(
                totalAmount,
                promotion.criteriaMinValue.toDouble(),
                promotion.criteriaMinOpr,
                promotion.criteriaMaxValue.toDouble(),
                promotion.criteriaMaxOpr
            )

            if (isValid) {
                when (promotion.disbursementType) {
                    PromotionConstant.DISBURSEMENT_PERCENT -> PercentBillCommand(
                        disbursementReceiverImpl,
                        promotion
                    ).execute()
                    PromotionConstant.DISBURSEMENT_AMOUNT -> AmountBillCommand(
                        disbursementReceiverImpl,
                        promotion
                    ).execute()
                    PromotionConstant.DISBURSEMENT_FREE_SKU -> FreeSkuBillCommand(
                        disbursementReceiverImpl,
                        promotion
                    ).execute()
                }
            } else {
                promotion.isApplied = false
                listener.getUpdatedPromotion(
                    promotion,
                    PromotionConstant.AMOUNT_CRITERIA_NOT_SATISFIED
                )
                return false
            }
            return true
        } else {
            listener.getUpdatedPromotion(
                promotion,
                isValidMoq.second // Validation failed reason
            )
            return false
        }
    }

    override fun handleQuantityCriteriaUseCase(promotion: PromotionModel): Boolean {
        val isValidMoq = checkMOQValidation(promotion)
        if (isValidMoq.first) {
            var listOfApplicableSku =
                promotion.applicableSkuModelList?.map { it.skuId } // promotion.applicableSkuIds?.split(',')?.map { it.toLong() }
            if (listOfApplicableSku.isNullOrEmpty()) {
                listOfApplicableSku = promotion.skuList.map { it.skuId }
            }
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
                        PromotionConstant.DISBURSEMENT_PERCENT -> PercentBillCommand(
                            disbursementReceiverImpl,
                            promotion
                        ).execute()
                        PromotionConstant.DISBURSEMENT_AMOUNT -> AmountBillCommand(
                            disbursementReceiverImpl,
                            promotion
                        ).execute()
                        PromotionConstant.DISBURSEMENT_FREE_SKU -> FreeSkuBillCommand(
                            disbursementReceiverImpl,
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
            var listOfApplicableSku =
                promotion.applicableSkuModelList?.map { it.skuId } // promotion.applicableSkuIds?.split(',')?.map { it.toLong() } ?: listOf()
            if (listOfApplicableSku.isNullOrEmpty()) {
                listOfApplicableSku = promotion.skuList.map { it.skuId }
            }
            val applicableSkuModel = promotion.skuList.filter { it.skuId in listOfApplicableSku }
            val selectedSkuCount = applicableSkuModel.count { it.quantity > 0 }
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
                        PromotionConstant.DISBURSEMENT_PERCENT -> PercentBillCommand(
                            disbursementReceiverImpl,
                            promotion
                        ).execute()
                        PromotionConstant.DISBURSEMENT_AMOUNT -> AmountBillCommand(
                            disbursementReceiverImpl,
                            promotion
                        ).execute()
                        PromotionConstant.DISBURSEMENT_FREE_SKU -> FreeSkuBillCommand(
                            disbursementReceiverImpl,
                            promotion
                        ).execute()
                    }
                } else {
                    promotion.isApplied = false
                    listener.getUpdatedPromotion(promotion, "Count criteria not satisfied")
                    return false
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
            listener.getUpdatedPromotion(
                promotion,
                isValidMoq.second // Validation failed reason
            )
            return false
        }
        return true
    }

    override fun handleCountMultipleCriteriaUseCase(promotion: PromotionModel): Boolean {
        val isValidMoq = checkMOQValidation(promotion)
        if (isValidMoq.first) {
            var listOfApplicableSku =
                promotion.applicableSkuModelList?.map { it.skuId } // promotion.applicableSkuIds?.split(',')?.map { it.toLong() } ?: listOf()

            if (listOfApplicableSku.isNullOrEmpty()) {
                listOfApplicableSku = promotion.skuList.map { it.skuId }
            }
            val applicableSkuModel = promotion.skuList.filter { it.skuId in listOfApplicableSku }
            val selectedSkuCount = applicableSkuModel.count { it.quantity > 0 }
            if (selectedSkuCount >= promotion.skuCount) {

                val isValid = selectedSkuCount > 0

                /*  OperatorHandler.isCriteriaValid(
                 selectedSkuCount.toDouble(),
                 promotion.criteriaMinValue.toDouble(),
                 promotion.criteriaMinOpr,
                 promotion.criteriaMaxValue.toDouble(),
                 promotion.criteriaMaxOpr
             ) */
                if (isValid) {
                    when (promotion.disbursementType) {
                        PromotionConstant.DISBURSEMENT_PERCENT -> PercentWithCriteriaMultipleBillCommand(
                            disbursementReceiverImpl,
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
                    PromotionConstant.COUNT_CRITERIA_NOT_SATISFIED
                )
                return false
            }
        } else {
            listener.getUpdatedPromotion(
                promotion,
                isValidMoq.second // Validation failed reason
            )
            return false
        }
        return true
    }

    override fun handleGroupCountCriteriaUseCase(promotion: PromotionModel): Boolean {
        val isValidMoq = checkGroupMOQValidation(promotion)
        val selectedSkuCount = isValidMoq.first

        val isValid = OperatorHandler.isCriteriaValid(
            selectedSkuCount.toDouble(),
            promotion.criteriaMinValue.toDouble(),
            promotion.criteriaMinOpr,
            promotion.criteriaMaxValue.toDouble(),
            promotion.criteriaMaxOpr
        )
        if (isValid) {
            when (promotion.disbursementType) {
                PromotionConstant.DISBURSEMENT_PERCENT -> PercentBillCommand(
                    disbursementReceiverImpl,
                    promotion
                ).execute()
                PromotionConstant.DISBURSEMENT_AMOUNT -> AmountBillCommand(
                    disbursementReceiverImpl,
                    promotion
                ).execute()
                PromotionConstant.DISBURSEMENT_FREE_SKU -> FreeSkuBillCommand(
                    disbursementReceiverImpl,
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
        return true
    }

    override fun handleGroupCountMultipleCriteriaUseCase(promotion: PromotionModel): Boolean {
        val groupMoqValidation = checkGroupMOQValidation(promotion)
        val selectedSkuCount = groupMoqValidation.first
        val isValid = selectedSkuCount > 0
        if (isValid) {
            if (isValid) {
                when (promotion.disbursementType) {
                    PromotionConstant.DISBURSEMENT_PERCENT -> {
                        promotion.newDisbursementValue =
                            if (selectedSkuCount < promotion.criteriaMaxValue) {
                                (selectedSkuCount * (promotion.disbursementValue ?: 0.0))
                            } else {
                                promotion.criteriaMaxValue * (promotion.disbursementValue ?: 0.0)
                            }

                        PercentWithCriteriaGroupCountMultipleCommand(
                            disbursementReceiverImpl,
                            promotion
                        ).execute()
                    }
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
    }
}