package com.rosia.promotionservice.promotion.service.bill.single.promotion

import com.rosia.promotionservice.promotion.data.*
import com.rosia.promotionservice.promotion.service.PromotionConstant
import com.rosia.promotionservice.promotion.service.bill.criteria.operator.OperatorConstants

object BillSinglePromotionDataSource {

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
                getFakePromotionSkuModel(
                    100
                )
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
                getFakePromotionSkuModel(
                    100
                )
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
                getFakePromotionSkuModel(
                    200
                )
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
                getFakePromotionSkuModel(
                    200
                )
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


    private fun getFakeFamilyPromotionSkuModel(
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

    fun get_bill_singlefamily_amount_amount_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff family worth 2000 and get 100 rsoff",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1, 2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            applicableSkuModelList = listOf(
                ApplicableSkuLocalModel(
                    skuId = 1,
                    criteriaType = "",
                    criteriaMaxOpr = "",
                    criteriaMaxValue = 0,
                    criteriaMinOpr = "",
                    criteriaMinValue = 0,
                    skuGroupId = 1,
                    familyStatus = true,
                    skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                        familyId = 1,
                        promotionId = 1,
                        type = PromotionConstant.CRITERIA_AMOUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 3000,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 3000,
                        skuCount = 0,
                        allowMultiple = false
                    ),
                    groupCriteriaLocalModel = null
                )
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(
                    quantity = 300,
                    skuId = 1
                )
            )
        )
    }

    fun get_bill_singlefamily_amount_amount_promotion_false(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff family worth 2000 and get 100 rsoff",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 0,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 0,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1, 2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            applicableSkuModelList = listOf(
                ApplicableSkuLocalModel(
                    skuId = 1,
                    criteriaType = PromotionConstant.CRITERIA_QUANTITY,
                    criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
                    criteriaMaxValue = 0,
                    criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
                    criteriaMinValue = 0,
                    skuGroupId = 1,
                    familyStatus = true,
                    skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                        familyId = 1,
                        promotionId = 1,
                        type = PromotionConstant.CRITERIA_AMOUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 2000,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 2000,
                        skuCount = 2,
                        allowMultiple = false
                    ),
                    groupCriteriaLocalModel = null
                ),
                ApplicableSkuLocalModel(
                    skuId = 2,
                    criteriaType = PromotionConstant.CRITERIA_AMOUNT,
                    criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
                    criteriaMaxValue = 0,
                    criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
                    criteriaMinValue = 0,
                    skuGroupId = 1,
                    familyStatus = true,
                    skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                        familyId = 1,
                        promotionId = 1,
                        type = PromotionConstant.CRITERIA_AMOUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 2000,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 2000,
                        skuCount = 2,
                        allowMultiple = false
                    ),
                    groupCriteriaLocalModel = null
                )
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(
                    quantity = 20,
                    skuId = 1
                ),
                getFakeFamilyPromotionSkuModel(
                    quantity = 200,
                    skuId = 3
                )
            )
        )
    }
}