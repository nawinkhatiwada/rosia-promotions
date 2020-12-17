package com.rosia.promotionservice.promotion.service.normal.type.multiple.sku

import com.rosia.promotionservice.promotion.data.ApplicableSkuLocalModel
import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.data.PromotionSkuModel
import com.rosia.promotionservice.promotion.data.SkuBatchModel
import com.rosia.promotionservice.promotion.data.SkuFamilyCriteriaModel
import com.rosia.promotionservice.promotion.service.PromotionConstant
import com.rosia.promotionservice.promotion.service.bill.criteria.operator.OperatorConstants

object NormalMultipleSkuDataSource {

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
        minMax: Int = 2000
    ): ApplicableSkuLocalModel {
        return ApplicableSkuLocalModel(
            skuId = skuId,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = minMax,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = minMax,
            skuGroupId = skuGroupId,
            familyStatus = false,
            familyId = -1,
            skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                familyId = 1,
                promotionId = 1,
                type = PromotionConstant.CRITERIA_AMOUNT,
                maxType = OperatorConstants.GREATER_THAN_EQUALS,
                maxValue = 0,
                minType = OperatorConstants.GREATER_THAN_EQUALS,
                minValue = 0,
                skuCount = 0,
                allowMultiple = false
            ),
            groupCriteriaLocalModel = null
        )
    }

    private fun getFakeApplicableSkuModelWithQuantityCriteria(
        skuId: Long,
        skuGroupId: Int = 1,
        minMax: Int = 10
    ): ApplicableSkuLocalModel {
        return ApplicableSkuLocalModel(
            skuId = skuId,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = minMax,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = minMax,
            skuGroupId = skuGroupId,
            familyStatus = false,
            familyId = -1,
            skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                familyId = 1,
                promotionId = 1,
                type = PromotionConstant.CRITERIA_AMOUNT,
                maxType = OperatorConstants.GREATER_THAN_EQUALS,
                maxValue = 0,
                minType = OperatorConstants.GREATER_THAN_EQUALS,
                minValue = 0,
                skuCount = 0,
                allowMultiple = false
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
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, minMax = 3000)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 300, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 300, skuId = 2)
            )
        )
    }

    fun get_amount_amount_promotion_false(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff family worth 2000 and get 100 rsoff",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 1000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 1000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 0.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, minMax = 3000)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 50, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 60, skuId = 2)
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
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, minMax = 3000)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 300, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 300, skuId = 2)
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
            criteriaMaxValue = 1000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 1000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, minMax = 3000)
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
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, minMax = 3000)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 300, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 300, skuId = 2)
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
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, minMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, minMax = 3000)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 210, skuId = 1)
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
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 1, minMax = 30),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 2, minMax = 30)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 30, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 30, skuId = 2)
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
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            allowMultiple = true,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 1, minMax = 30),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 2, minMax = 30)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 5, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 6, skuId = 2)
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
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 1, minMax = 30),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 2, minMax = 30)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 30, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 30, skuId = 2)
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
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 1, minMax = 30),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 2, minMax = 30)
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
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 1, minMax = 30),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 2, minMax = 30)
            ),
            skuList = listOf(
                getFakeFamilyPromotionSkuModel(quantity = 30, skuId = 1),
                getFakeFamilyPromotionSkuModel(quantity = 30, skuId = 2)
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
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            allowMultiple = false,
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
                    familyId = 1,
                    skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                        familyId = 1,
                        promotionId = 1,
                        type = PromotionConstant.CRITERIA_QUANTITY,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 15,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 15,
                        skuCount = 0,
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
                    familyId = 1,
                    skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                        familyId = 1,
                        promotionId = 1,
                        type = PromotionConstant.CRITERIA_QUANTITY,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 15,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 15,
                        skuCount = 0,
                        allowMultiple = true
                    ),
                    groupCriteriaLocalModel = null
                )
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
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
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
                    familyStatus = false,
                    familyId = -1,
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
                    familyStatus = false,
                    familyId = -1,
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
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
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
                    familyStatus = false,
                    familyId = -1,
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
                    familyStatus = false,
                    familyId = -1,
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
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
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
                    familyStatus = false,
                    familyId = -1,
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
                    familyStatus = false,
                    familyId = -1,
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
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
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
                    familyStatus = false,
                    familyId = -1,
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
                    familyStatus = false,
                    familyId = -1,
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
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
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
                    familyStatus = false,
                    familyId = -1,
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
                    familyStatus = false,
                    familyId = -1,
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
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
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
                    familyStatus = false,
                    familyId = -1,
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
                    familyStatus = false,
                    familyId = -1,
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