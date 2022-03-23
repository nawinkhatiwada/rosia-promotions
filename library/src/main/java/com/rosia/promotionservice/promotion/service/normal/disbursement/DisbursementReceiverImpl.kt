package com.rosia.promotionservice.promotion.service.normal.disbursement

import com.rosia.promotionservice.promotion.data.BillAmountModel
import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.service.AmountCalculator
import com.rosia.promotionservice.promotion.service.PromotionListener

class DisbursementReceiverImpl(private val listener: PromotionListener) : DisbursementReceiver {

    override fun handleAmountWithCriteriaQuantityUseCase(promotion: PromotionModel) {
        val orderSkuCount = promotion.skuList.sumBy { it.quantity }
        val amountSeparation = (promotion.disbursementValue ?: 0.0) / orderSkuCount

        /**
         * 100/3
         * 33.33 33.33 33.33 = 99.99  ---- 0.01???
         * 33.33 33.33 33.34 = 100   <---- here in the last
         */

        val totalDisbursement = amountSeparation * orderSkuCount
        val remainDisbursementAmount = (promotion.disbursementValue!!) - totalDisbursement
        val orderedSkuList = promotion.skuList.filter { it.quantity > 0 }

        orderedSkuList.forEachIndexed { index, sku ->

            sku.batchList?.let { batchList ->
                val skuBatch = batchList.first { it.isSelected }

                val newDisbursementValue = if (promotion.allowMultiple) {
                    (amountSeparation * sku.quantity) * (orderSkuCount / promotion.criteriaMinValue)
                } else {
                    (amountSeparation * sku.quantity)
                }

                val amountModel = AmountCalculator.calculateAmountDetails(
                    quantity = sku.quantity,
                    rlp = skuBatch.rlp,
                    rlpWithVat = skuBatch.rlpVat,
                    vat = skuBatch.vatPercent,
                    disbursementValue = if (index == (orderedSkuList.size - 1))
                        newDisbursementValue + remainDisbursementAmount
                    else
                        newDisbursementValue,
                    isDisbursementTypeAmount = true
                )

                sku.apply {
                    grossAmount = amountModel.grossAmount
                    discountAmount = amountModel.discountAmount
                    vatAmount = amountModel.vatAmount
                    netAmount = amountModel.netAmount
                    taxableAmount = amountModel.taxableAmount
                }
            }
        }
        promotion.isApplied = true
        listener.getUpdatedPromotion(promotion, "")
    }

    override fun handleAmountWithCriteriaAmountUseCase(promotion: PromotionModel) {
        val orderSkuCount = promotion.skuList.sumBy { it.quantity }
        val orderAmount =
            promotion.skuList.sumByDouble { it.batchList?.first()?.rlp?.times(it.quantity) ?: 0.0 }

        val amountSeparation = (promotion.disbursementValue ?: 0.0) / orderSkuCount

        val totalDisbursement = amountSeparation * orderSkuCount
        val remainDisbursementAmount = (promotion.disbursementValue!!) - totalDisbursement
        val orderedSkuList = promotion.skuList.filter { it.quantity > 0 }

        orderedSkuList.forEachIndexed { index, sku ->

            val newDisbursementValue = if (promotion.allowMultiple) {
                (amountSeparation * sku.quantity) * (orderAmount / promotion.criteriaMinValue)
            } else {
                (amountSeparation * sku.quantity)
            }

            sku.batchList?.let { batchList ->
                val skuBatch = batchList.first { it.isSelected }
                val amountModel = AmountCalculator.calculateAmountDetails(
                    quantity = sku.quantity,
                    rlp = skuBatch.rlp,
                    rlpWithVat = skuBatch.rlpVat,
                    vat = skuBatch.vatPercent,
                    disbursementValue = if (index == (orderedSkuList.size - 1))
                        newDisbursementValue + remainDisbursementAmount
                    else
                        newDisbursementValue,
                    isDisbursementTypeAmount = true
                )

                sku.apply {
                    grossAmount = amountModel.grossAmount
                    discountAmount = amountModel.discountAmount
                    vatAmount = amountModel.vatAmount
                    netAmount = amountModel.netAmount
                    taxableAmount = amountModel.taxableAmount
                }
            }
        }
        promotion.isApplied = true
        listener.getUpdatedPromotion(promotion, "")
    }

    override fun handleAmountWithCriteriaCountUseCase(promotion: PromotionModel) {
        val orderSkuCount = promotion.skuList.count { it.quantity > 0 }
        val orderSkuQuantity = promotion.skuList.sumBy { it.quantity }

        val amountSeparation = (promotion.disbursementValue ?: 0.0) / orderSkuQuantity

        val totalDisbursement = amountSeparation * orderSkuQuantity
        val remainDisbursementAmount = (promotion.disbursementValue!!) - totalDisbursement
        val orderedSkuList = promotion.skuList.filter { it.quantity > 0 }

        orderedSkuList.forEachIndexed { index, sku ->

            sku.batchList?.let { batchList ->
                val skuBatch = batchList.first { it.isSelected }

                val newDisbursementValue = if (promotion.allowMultiple) {
                    (amountSeparation * sku.quantity) * (orderSkuCount / promotion.criteriaMinValue)
                } else {
                    (amountSeparation * sku.quantity)
                }

                val amountModel = AmountCalculator.calculateAmountDetails(
                    quantity = sku.quantity,
                    rlp = skuBatch.rlp,
                    rlpWithVat = skuBatch.rlpVat,
                    vat = skuBatch.vatPercent,
                    disbursementValue = if (index == (orderedSkuList.size - 1))
                        newDisbursementValue + remainDisbursementAmount
                    else
                        newDisbursementValue,
                    isDisbursementTypeAmount = true
                )

                sku.apply {
                    grossAmount = amountModel.grossAmount
                    discountAmount = amountModel.discountAmount
                    vatAmount = amountModel.vatAmount
                    netAmount = amountModel.netAmount
                    taxableAmount = amountModel.taxableAmount
                }
            }
        }
        promotion.isApplied = true
        listener.getUpdatedPromotion(promotion, "")
    }

    override fun handlePercentUseCase(promotion: PromotionModel) {
        promotion.skuList.forEach { sku ->
            sku.batchList?.let { batchList ->

                val skuBatch = batchList.first { it.isSelected }
                val amountModel = AmountCalculator.calculateAmountDetails(
                    quantity = sku.quantity,
                    rlp = skuBatch.rlp,
                    rlpWithVat = skuBatch.rlpVat,
                    vat = skuBatch.vatPercent,
                    disbursementValue = promotion.disbursementValue
                )

                sku.apply {
                    grossAmount = amountModel.grossAmount
                    discountAmount = amountModel.discountAmount
                    vatAmount = amountModel.vatAmount
                    netAmount = amountModel.netAmount
                    taxableAmount = amountModel.taxableAmount
                }
            }
        }
        promotion.isApplied = true
        listener.getUpdatedPromotion(promotion, "")
    }

    override fun handleFreeSkuWithCriteriaQuantityUseCase(promotion: PromotionModel) {
        promotion.skuList.forEach { sku ->
            sku.batchList?.let { batchList ->
                val skuBatch = batchList.first { it.isSelected }
                val amountModel = AmountCalculator.calculateAmountDetails(
                    quantity = sku.quantity,
                    rlp = skuBatch.rlp,
                    rlpWithVat = skuBatch.rlpVat,
                    vat = skuBatch.vatPercent,
                    disbursementValue = null
                )

                sku.apply {
                    grossAmount = amountModel.grossAmount
                    discountAmount = amountModel.discountAmount
                    vatAmount = amountModel.vatAmount
                    netAmount = amountModel.netAmount
                    taxableAmount = amountModel.taxableAmount
                }
            }
        }

        // buy1 get 2 free...but2 get 4 free usecase v
        promotion.newDisbursementValue = if (promotion.allowMultiple) {
            (promotion.skuList
                .filter { it.quantity > 0 }
                .sumBy { it.quantity } / promotion.criteriaMinValue) * (promotion.disbursementValue
                ?: 0.0)
        } else {
            (promotion.disbursementValue ?: 0.0)
        }

        promotion.isApplied = true
        listener.getUpdatedPromotion(promotion, "")
    }

    override fun handleFreeSkuWithCriteriaAmountUseCase(promotion: PromotionModel) {
        val orderAmount =
            promotion.skuList.sumByDouble { it.batchList?.first()?.rlp?.times(it.quantity) ?: 0.0 }

        promotion.skuList.forEach { sku ->
            sku.batchList?.let { batchList ->
                val skuBatch = batchList.first { it.isSelected }
                val amountModel = AmountCalculator.calculateAmountDetails(
                    quantity = sku.quantity,
                    rlp = skuBatch.rlp,
                    rlpWithVat = skuBatch.rlpVat,
                    vat = skuBatch.vatPercent,
                    disbursementValue = null
                )

                sku.apply {
                    grossAmount = amountModel.grossAmount
                    discountAmount = amountModel.discountAmount
                    vatAmount = amountModel.vatAmount
                    netAmount = amountModel.netAmount
                    taxableAmount = amountModel.taxableAmount
                }
            }
        }

        // buy1 get 2 free...but2 get 4 free use case v
        val newDisbursementValue = if (promotion.allowMultiple) {
            ((orderAmount / promotion.criteriaMinValue).toInt()) * (promotion.disbursementValue
                ?: 0.0)
        } else {
            promotion.disbursementValue ?: 0.0
        }
        promotion.newDisbursementValue = newDisbursementValue.toInt().toDouble()
        promotion.isApplied = true
        listener.getUpdatedPromotion(promotion, "")
    }

    override fun handleFreeSkuWithCriteriaCountUseCase(promotion: PromotionModel) {
        val orderSkuCount = promotion.skuList.count { it.quantity > 0 }
        val orderSkuQuantity = promotion.skuList.sumBy { it.quantity }

        val amountSeparation = (promotion.disbursementValue ?: 0.0) / orderSkuQuantity

        val totalDisbursement = amountSeparation * orderSkuQuantity
        val remainDisbursementAmount = (promotion.disbursementValue!!) - totalDisbursement
        val orderedSkuList = promotion.skuList.filter { it.quantity > 0 }

        orderedSkuList.forEachIndexed { index, sku ->

            sku.batchList?.let { batchList ->
                val skuBatch = batchList.first { it.isSelected }

                val newDisbursementValue = if (promotion.allowMultiple) {
                    (amountSeparation * sku.quantity) * (orderSkuCount / promotion.criteriaMinValue)
                } else {
                    (amountSeparation * sku.quantity)
                }

                val amountModel = AmountCalculator.calculateAmountDetails(
                    quantity = sku.quantity,
                    rlp = skuBatch.rlp,
                    rlpWithVat = skuBatch.rlpVat,
                    vat = skuBatch.vatPercent,
                    disbursementValue = if (index == (orderedSkuList.size - 1))
                        newDisbursementValue + remainDisbursementAmount
                    else
                        newDisbursementValue,
                    isDisbursementTypeAmount = true
                )

                sku.apply {
                    grossAmount = amountModel.grossAmount
                    discountAmount = amountModel.discountAmount
                    vatAmount = amountModel.vatAmount
                    netAmount = amountModel.netAmount
                    taxableAmount = amountModel.taxableAmount
                }
            }
        }
        promotion.newDisbursementValue = if (promotion.allowMultiple) {
            ((promotion.skuList.count { it.quantity > 0 }) / promotion.criteriaMinValue) * (promotion.disbursementValue
                ?: 0.0)
        } else {
            (promotion.disbursementValue ?: 0.0)
        }

        promotion.isApplied = true
        listener.getUpdatedPromotion(promotion, "")
    }

    //TODO fix
    override fun handlePercentWithCriteriaMultipleAmount(promotion: PromotionModel) {
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

    //TODO fix
    override fun handlePercentWithCriteriaGroupCountMultipleAmount(promotion: PromotionModel) {
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