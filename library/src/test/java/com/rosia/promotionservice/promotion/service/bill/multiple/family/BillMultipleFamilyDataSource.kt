package com.rosia.promotionservice.promotion.service.bill.multiple.family

import com.rosia.promotionservice.promotion.data.ApplicableSkuLocalModel
import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.data.PromotionSkuModel
import com.rosia.promotionservice.promotion.data.SkuBatchModel
import com.rosia.promotionservice.promotion.data.SkuFamilyCriteriaModel
import com.rosia.promotionservice.promotion.service.PromotionConstant
import com.rosia.promotionservice.promotion.service.bill.criteria.operator.OperatorConstants

object BillMultipleFamilyDataSource {

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

    private fun getFakeApplicableSkuModelWithAmountCriteria(
        skuId: Long,
        skuGroupId: Int = 1,
        minMax: Int = 2000,
        applicableSkuGroupIds: String = "1,2,3",
        skuMoq: Int = 50,
        skuGroupMoq: Int = 100
    ): ApplicableSkuLocalModel {
        return ApplicableSkuLocalModel(
            skuId = skuId,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 0,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 0,
            skuGroupId = skuGroupId,
            familyStatus = true,
            skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                familyId = 1,
                promotionId = 1,
                type = PromotionConstant.CRITERIA_AMOUNT,
                maxType = OperatorConstants.GREATER_THAN_EQUALS,
                maxValue = minMax,
                minType = OperatorConstants.GREATER_THAN_EQUALS,
                minValue = minMax,
                skuCount = 0,
                allowMultiple = false
            ),
            groupCriteriaLocalModel = null
        )
    }

    private fun getFakeApplicableSkuModelWithQuantityCriteria(
        skuId: Long,
        skuGroupId: Int = 1,
        minMax: Int = 10,
        applicableSkuGroupIds: String = "1,2,3",
        skuMoq: Int = 50,
        skuGroupMoq: Int = 100
    ): ApplicableSkuLocalModel {
        return ApplicableSkuLocalModel(
            skuId = skuId,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 0,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 0,
            skuGroupId = skuGroupId,
            familyStatus = true,
            skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                familyId = 1,
                promotionId = 1,
                type = PromotionConstant.CRITERIA_QUANTITY,
                maxType = OperatorConstants.GREATER_THAN_EQUALS,
                maxValue = minMax,
                minType = OperatorConstants.GREATER_THAN_EQUALS,
                minValue = minMax,
                skuCount = 0,
                allowMultiple = true
            ),
            groupCriteriaLocalModel = null
        )
    }

    fun get_amount_amount_promotion_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff family worth 2000 and get 100 rsoff",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 0.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 3, minMax = 3000)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 50, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 150, skuId = 2),
                getFakeFamilyPromotionSkuModel(quantity = 100, skuId = 3)
            )
        )
    }

    fun get_amount_amount_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff family worth 2000 and get 100 rsoff",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 0.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 3, minMax = 3000)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 50, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 50, skuId = 2),
                getFakeFamilyPromotionSkuModel(quantity = 100, skuId = 3)
            )
        )
    }

    fun get_amount_percent_promotion_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff family worth 2000 and get 10% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 3, minMax = 3000)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 50, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 150, skuId = 2),
                getFakeFamilyPromotionSkuModel(quantity = 100, skuId = 3)
            )
        )
    }

    fun get_amount_percent_promotion_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff family worth 2000 and get 10% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 3, minMax = 3000)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 100, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 100, skuId = 2)
            )
        )
    }

    fun get_amount_sku_promotion_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff family worth 2000 and get 1 for free",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 3,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 3, minMax = 3000)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 50, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 150, skuId = 2),
                getFakeFamilyPromotionSkuModel(quantity = 100, skuId = 3)
            )
        )
    }

    fun get_amount_sku_promotion_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff family worth 2000 and get 1 for free",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 3, minMax = 3000)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 200, skuId = 1)
//                getFakeFamilyPromotionSkuModel(quantity = 50, skuId = 2)
            )
        )
    }

    fun get_quantity_amount_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 pcs of 2 diff family and get 10 rsoff",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 1, minMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 2, minMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 3, minMax = 20)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 10, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 15, skuId = 2),
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 3)
            )
        )
    }

    fun get_quantity_amount_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 pcs of 2 diff family and get 10 rsoff",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            allowMultiple = true,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 1, minMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 2, minMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 3, minMax = 20)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 10, skuId = 2),
                getFakeFamilyPromotionSkuModel(quantity = 2, skuId = 3)
            )
        )
    }

    fun get_quantity_percent_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 pcs of 2 diff family and get 10 % off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 1, minMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 2, minMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 3, minMax = 20)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 2),
                getFakeFamilyPromotionSkuModel(quantity = 15, skuId = 3)
            )
        )
    }

    fun get_quantity_percent_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 pcs of 2 diff family and get 10 % off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 1, minMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 2, minMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 3, minMax = 20)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 10, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 2, skuId = 2)
            )
        )
    }

    fun get_quantity_sku_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 pcs of 2 diff family and get 1 sku free",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 2,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            allowMultiple = true,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 1, minMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 2, minMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 3, minMax = 20)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 10, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 2),
                getFakeFamilyPromotionSkuModel(quantity = 6, skuId = 3)
            )
        )
    }

    fun get_quantity_sku_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 pcs of 2 diff family and get 1 sku free",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 1, minMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 2, minMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 3, minMax = 20)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 10, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 1, skuId = 2)
            )
        )
    }

    fun get_count_amount_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 2 unique skus of sku family and get 10 rsoff",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                ApplicableSkuLocalModel(
                    skuId = 1,
                    criteriaType = PromotionConstant.CRITERIA_COUNT,
                    criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
                    criteriaMaxValue = 0,
                    criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
                    criteriaMinValue = 0,
                    skuGroupId = 1,
                    familyStatus = true,
                    skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                        familyId = 1,
                        promotionId = 1,
                        type = PromotionConstant.CRITERIA_COUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 1,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 1,
                        skuCount = 1,
                        allowMultiple = true
                    ),
                    groupCriteriaLocalModel = null
                ),
                ApplicableSkuLocalModel(
                    skuId = 2,
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
                        type = PromotionConstant.CRITERIA_COUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 1,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 1,
                        skuCount = 1,
                        allowMultiple = true
                    ),
                    groupCriteriaLocalModel = null
                )
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 2)
            )
        )
    }

    fun get_count_amount_error(): PromotionModel {
        return  PromotionModel(
            promotionId = 1,
            title = "Buy 2 unique skus of sku family and get 10 rsoff",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                ApplicableSkuLocalModel(
                    skuId = 1,
                    criteriaType = PromotionConstant.CRITERIA_COUNT,
                    criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
                    criteriaMaxValue = 0,
                    criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
                    criteriaMinValue = 0,
                    skuGroupId = 1,
                    familyStatus = true,
                    skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                        familyId = 1,
                        promotionId = 1,
                        type = PromotionConstant.CRITERIA_COUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 1,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 1,
                        skuCount = 1,
                        allowMultiple = true
                    ),
                    groupCriteriaLocalModel = null
                ),
                ApplicableSkuLocalModel(
                    skuId = 2,
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
                        type = PromotionConstant.CRITERIA_COUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 1,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 1,
                        skuCount = 1,
                        allowMultiple = true
                    ),
                    groupCriteriaLocalModel = null
                )
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 1)
            )
        )
    }

    fun get_count_percent_success(): PromotionModel {
        return  PromotionModel(
            promotionId = 1,
            title = "Buy 2 unique skus of sku family and get 10 rsoff",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                ApplicableSkuLocalModel(
                    skuId = 1,
                    criteriaType = PromotionConstant.CRITERIA_COUNT,
                    criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
                    criteriaMaxValue = 0,
                    criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
                    criteriaMinValue = 0,
                    skuGroupId = 1,
                    familyStatus = true,
                    skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                        familyId = 1,
                        promotionId = 1,
                        type = PromotionConstant.CRITERIA_COUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 3,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 3,
                        skuCount = 1,
                        allowMultiple = true
                    ),
                    groupCriteriaLocalModel = null
                ),
                ApplicableSkuLocalModel(
                    skuId = 2,
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
                        type = PromotionConstant.CRITERIA_COUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 3,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 3,
                        skuCount = 1,
                        allowMultiple = true
                    ),
                    groupCriteriaLocalModel = null
                )
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 2),
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 3)
            )
        )
    }

    fun get_count_percent_error(): PromotionModel {
        return  PromotionModel(
            promotionId = 1,
            title = "Buy 2 unique skus of sku family and get 10 rsoff",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                ApplicableSkuLocalModel(
                    skuId = 1,
                    criteriaType = PromotionConstant.CRITERIA_COUNT,
                    criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
                    criteriaMaxValue = 0,
                    criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
                    criteriaMinValue = 0,
                    skuGroupId = 1,
                    familyStatus = true,
                    skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                        familyId = 1,
                        promotionId = 1,
                        type = PromotionConstant.CRITERIA_COUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 3,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 3,
                        skuCount = 1,
                        allowMultiple = true
                    ),
                    groupCriteriaLocalModel = null
                ),
                ApplicableSkuLocalModel(
                    skuId = 2,
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
                        type = PromotionConstant.CRITERIA_COUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 3,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 3,
                        skuCount = 1,
                        allowMultiple = true
                    ),
                    groupCriteriaLocalModel = null
                )
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 2)
            )
        )
    }

    fun get_count_sku_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 2 unique skus of sku family and get 1 free sku ",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                ApplicableSkuLocalModel(
                    skuId = 1,
                    criteriaType = PromotionConstant.CRITERIA_COUNT,
                    criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
                    criteriaMaxValue = 0,
                    criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
                    criteriaMinValue = 0,
                    skuGroupId = 1,
                    familyStatus = true,
                    skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                        familyId = 1,
                        promotionId = 1,
                        type = PromotionConstant.CRITERIA_COUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 3,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 3,
                        skuCount = 1,
                        allowMultiple = true
                    ),
                    groupCriteriaLocalModel = null
                ),
                ApplicableSkuLocalModel(
                    skuId = 2,
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
                        type = PromotionConstant.CRITERIA_COUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 3,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 3,
                        skuCount = 1,
                        allowMultiple = true
                    ),
                    groupCriteriaLocalModel = null
                )
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 2),
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 3)
            )
        )
    }

    fun get_count_sku_error(): PromotionModel {
        return  PromotionModel(
            promotionId = 1,
            title = "Buy 2 unique skus of sku family and get 1 free sku ",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                ApplicableSkuLocalModel(
                    skuId = 1,
                    criteriaType = PromotionConstant.CRITERIA_COUNT,
                    criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
                    criteriaMaxValue = 0,
                    criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
                    criteriaMinValue = 0,
                    skuGroupId = 1,
                    familyStatus = true,
                    skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                        familyId = 1,
                        promotionId = 1,
                        type = PromotionConstant.CRITERIA_COUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 3,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 3,
                        skuCount = 1,
                        allowMultiple = true
                    ),
                    groupCriteriaLocalModel = null
                ),
                ApplicableSkuLocalModel(
                    skuId = 2,
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
                        type = PromotionConstant.CRITERIA_COUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 3,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 3,
                        skuCount = 1,
                        allowMultiple = true
                    ),
                    groupCriteriaLocalModel = null
                )
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 2)
            )
        )
    }

}