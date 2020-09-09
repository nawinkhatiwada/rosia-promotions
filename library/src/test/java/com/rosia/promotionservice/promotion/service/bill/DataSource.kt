package com.rosia.promotionservice.promotion.service.bill

import com.rosia.promotionservice.promotion.data.*
import com.rosia.promotionservice.promotion.service.PromotionConstant
import com.rosia.promotionservice.promotion.service.bill.criteria.operator.OperatorConstants

object DataSource {

    private fun getFakePromotionSkuModel(
        quantity: Int,
        isSelected: Boolean = true,
        skuId: Long = 1
    ): PromotionSkuModel {
        return PromotionSkuModel(
            skuId = skuId,
            skuName = "Buy 200 Pcs of Vicks Vaporub - 5 gm and get 2% off",
            brandName = "Vicks",
            moq = 2,
            quantity = quantity,
            promotionStatus = true,
            inStock = true,
            batchList = listOf(
                SkuBatchModel(
                    id = 1,
                    rlpVat = 11.30,
                    batchTitle = "First",
                    isSelected = isSelected,
                    rlp = 10.0,
                    vatPercent = 0.13
                )
            ),
            discountAmount = 0.0,
            grossAmount = 10.0 * quantity,
            netAmount = 11.3 * quantity,
            vatAmount = 1.3 * quantity,
            taxableAmount = 10.0 * quantity,
            orderId = 1,
            topUpDiscount = 0.0,
            stockQty = 10
        )
    }

    fun get_bill_single_quantity_percent_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and get 2% off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 2.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(100)
            )
        )
    }

    fun get_bill_single_quantity_percent_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and get 2% off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 2.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(10)
            )
        )
    }

    fun get_bill_single_quantity_amount_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and get 100 rs off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(100)
            )
        )
    }

    fun get_bill_single_quantity_amount_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and get 100 rs off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 100.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(10)
            )
        )
    }

    fun get_bill_single_amount_percent_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 10 % off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(200)
            )
        )
    }

    fun get_bill_single_amount_percent_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 10 % off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(10)
            )
        )
    }

    fun get_bill_single_amount_amount_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rsoff",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(200)
            )
        )
    }

    fun get_bill_single_amount_amount_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rs off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(10)
            )
        )
    }

    fun get_bill_multiple_quantity_percent_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and get 2% off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 2.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 100, skuId = 1),
                getFakePromotionSkuModel(quantity = 50, skuId = 2)
            )
        )
    }

    fun get_bill_multiple_quantity_percent_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and get 2% off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 2.0,
            applicableSkuIds = "1,2",
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(1,10),
                getFakeApplicableSkuModel(2,10),
            ),
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 10, skuId = 1),
                getFakePromotionSkuModel(quantity = 10, skuId = 2),
                getFakePromotionSkuModel(quantity = 100, skuId = 3)
            )
        )
    }

    fun get_bill_multiple_quantity_amount_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and get 100 rs off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 20, skuId = 1),
                getFakePromotionSkuModel(quantity = 20, skuId = 2),
                getFakePromotionSkuModel(quantity = 80, skuId = 3)
            )
        )
    }

    fun get_bill_multiple_quantity_amount_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and get 100 rs off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 100.0,
            applicableSkuIds = "1,2",
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(1,10),
                getFakeApplicableSkuModel(2,10)
            ),
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 10, skuId = 1),
                getFakePromotionSkuModel(quantity = 10, skuId = 2),
                getFakePromotionSkuModel(quantity = 80, skuId = 3)
            )
        )
    }

    private fun getFakeApplicableSkuModel(
        skuId: Long,
        skuGroupId: Int = 1,
        applicableSkuGroupIds: String = "1,2",
        skuMoq: Int = 5,
        skuGroupMoq: Int = 5
    ): ApplicableSkuLocalModel {
        return ApplicableSkuLocalModel(
            skuId = skuId,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = skuMoq,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 5,
            skuGroupId = skuGroupId,
            groupCriteriaLocalModel = PromotionSkuGroupModel(
                id = skuGroupId.toLong(),
                promotionId = 1,
                skuIds = applicableSkuGroupIds,
                type = PromotionConstant.CRITERIA_QUANTITY,
                maxValue = 5,
                maxType = OperatorConstants.GREATER_THAN_EQUALS,
                minValue = skuGroupMoq,
                minType = OperatorConstants.GREATER_THAN_EQUALS,
                skuCount = 1,
                allowMultiple = false

            )
        )
    }


    fun get_bill_multiple_amount_percent_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 10 % off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 5,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3,4,5",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 100, skuId = 1),
                getFakePromotionSkuModel(quantity = 50, skuId = 2),
                getFakePromotionSkuModel(quantity = 20, skuId = 3),
                getFakePromotionSkuModel(quantity = 20, skuId = 4),
                getFakePromotionSkuModel(quantity = 11, skuId = 5)
            )
        )
    }

    fun get_bill_multiple_amount_percent_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 10 % off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 100, skuId = 1)
            )
        )
    }

    fun get_bill_multiple_amount_amount_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rsoff",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 200, skuId = 1),
                getFakePromotionSkuModel(quantity = 100, skuId = 2)
            )
        )
    }

    fun get_bill_multiple_amount_amount_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rs off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 10, skuId = 1),
                getFakePromotionSkuModel(quantity = 10, skuId = 2)
            )
        )
    }
}