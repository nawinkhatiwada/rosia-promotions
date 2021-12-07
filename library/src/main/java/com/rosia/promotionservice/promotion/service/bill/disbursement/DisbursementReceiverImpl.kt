package com.rosia.promotionservice.promotion.service.bill.disbursement

import com.rosia.promotionservice.promotion.data.BillAmountModel
import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.service.AmountCalculator
import com.rosia.promotionservice.promotion.service.PromotionConstant
import com.rosia.promotionservice.promotion.service.PromotionListener

// TODO change vat amount to tax amount
class DisbursementReceiverImpl(private val listener: PromotionListener) : DisbursementReceiver {

    override fun handleBillAmountUseCase(promotion: PromotionModel) {
        val amountModel =
            if (promotion.promotionType == PromotionConstant.PROMOTION_TYPE_CURRENT_BILL ||
                promotion.promotionType == PromotionConstant.PROMOTION_TYPE_NEXT_BILL
            ) {
                AmountCalculator.calculateAmountDetailsForBill(
                    promotion.skuList,
                    promotion.disbursementValue,
                    true
                )
            } else {
                val applicableSKUs =
                    promotion.applicableSkuModelList?.map { it.skuId } ?: emptyList()
                val topUpSKUList = promotion.skuList.filter { it.skuId in applicableSKUs }
                AmountCalculator.calculateAmountDetailsForTopUp(
                    topUpSKUList,
                    promotion.disbursementValue,
                    true
                )
            }
        promotion.amountModel = BillAmountModel(
            discountAmount = amountModel.discountAmount,
            grossAmount = amountModel.grossAmount,
            vatAmount = amountModel.vatAmount,
            netAmount = amountModel.netAmount,
            taxableAmount = amountModel.taxableAmount
        )
        promotion.isApplied = true
        listener.getUpdatedPromotion(promotion, "")
    }

    override fun handleBillPercentUseCase(promotion: PromotionModel) {
        val amountModel =
            if (promotion.promotionType == PromotionConstant.PROMOTION_TYPE_CURRENT_BILL ||
                promotion.promotionType == PromotionConstant.PROMOTION_TYPE_NEXT_BILL
            ) {
                AmountCalculator.calculateAmountDetailsForBill(
                    promotion.skuList,
                    promotion.disbursementValue
                )
            } else {
                val applicableSKUs =
                    promotion.applicableSkuModelList?.map { it.skuId } ?: emptyList()
                val topUpSKUList = promotion.skuList.filter { it.skuId in applicableSKUs }
                AmountCalculator.calculateAmountDetailsForTopUp(
                    topUpSKUList,
                    promotion.disbursementValue
                )
            }
        promotion.amountModel = BillAmountModel(
            discountAmount = amountModel.discountAmount,
            grossAmount = amountModel.grossAmount,
            vatAmount = amountModel.vatAmount,
            netAmount = amountModel.netAmount,
            taxableAmount = amountModel.taxableAmount
        )
        promotion.isApplied = true
        listener.getUpdatedPromotion(promotion, "")
    }

    override fun handleBillFreeSkuUseCase(promotion: PromotionModel) {
        val amountModel =
            if (promotion.promotionType == PromotionConstant.PROMOTION_TYPE_CURRENT_BILL ||
                promotion.promotionType == PromotionConstant.PROMOTION_TYPE_NEXT_BILL
            ) {
                AmountCalculator.calculateAmountDetailsForBill(
                    promotion.skuList,
                    promotion.disbursementValue
                )
            } else {
                val applicableSKUs =
                    promotion.applicableSkuModelList?.map { it.skuId } ?: emptyList()
                val topUpSKUList = promotion.skuList.filter { it.skuId in applicableSKUs }
                AmountCalculator.calculateAmountDetailsForTopUp(
                    topUpSKUList,
                    promotion.disbursementValue
                )
            }
        promotion.amountModel = BillAmountModel(
            discountAmount = amountModel.discountAmount,
            grossAmount = amountModel.grossAmount,
            vatAmount = amountModel.vatAmount,
            netAmount = amountModel.netAmount,
            taxableAmount = amountModel.taxableAmount
        )
        promotion.isApplied = true
        promotion.newDisbursementValue = if (promotion.allowMultiple) {
            if (promotion.promotionType == PromotionConstant.PROMOTION_TYPE_TOP_UP) {
                handleTopUpCase(promotion)
            } else {
                handleBillUseCase(promotion)
            }
        } else {
            promotion.disbursementValue ?: 0.0
        }
        listener.getUpdatedPromotion(promotion, "")
    }

    private fun handleTopUpCase(promotion: PromotionModel): Double {
        val applicableSKUs =
            promotion.applicableSkuModelList?.map { it.skuId } ?: emptyList()
        val topUpSKUList = promotion.skuList.filter { it.skuId in applicableSKUs }
        return (topUpSKUList
            .filter { it.quantity > 0 }
            .sumBy { it.quantity } / promotion.criteriaMinValue) * (promotion.disbursementValue
            ?: 0.0)
    }

    private fun handleBillUseCase(promotion: PromotionModel): Double {
        return (promotion.skuList
            .filter { it.quantity > 0 }
            .sumBy { it.quantity } / promotion.criteriaMinValue) * (promotion.disbursementValue
            ?: 0.0)
    }

    override fun handleBillPercentWithCriteriaMultipleAmount(promotion: PromotionModel) {
        val maxCriteria = promotion.criteriaMaxValue
        val totalSkuCount = promotion.skuList.count { it.quantity > 0 }
        promotion.newDisbursementValue = if (totalSkuCount < maxCriteria) {
            (totalSkuCount * (promotion.disbursementValue ?: 0.0))
        } else {
            maxCriteria * (promotion.disbursementValue ?: 0.0)
        }

        val amountModel = AmountCalculator.calculateAmountDetailsForBill(
            promotion.skuList,
            promotion.newDisbursementValue
        )
        promotion.amountModel = BillAmountModel(
            discountAmount = amountModel.discountAmount,
            grossAmount = amountModel.grossAmount,
            vatAmount = amountModel.vatAmount,
            netAmount = amountModel.netAmount,
            taxableAmount = amountModel.taxableAmount
        )
        promotion.isApplied = true
        listener.getUpdatedPromotion(promotion, "")
    }

    override fun handleBillPercentWithCriteriaGroupCountMultipleAmount(promotion: PromotionModel) {
        val amountModel = AmountCalculator.calculateAmountDetailsForBill(
            promotion.skuList,
            promotion.newDisbursementValue
        )
        promotion.amountModel = BillAmountModel(
            discountAmount = amountModel.discountAmount,
            grossAmount = amountModel.grossAmount,
            vatAmount = amountModel.vatAmount,
            netAmount = amountModel.netAmount,
            taxableAmount = amountModel.taxableAmount
        )
        promotion.isApplied = true
        listener.getUpdatedPromotion(promotion, "")
    }
}