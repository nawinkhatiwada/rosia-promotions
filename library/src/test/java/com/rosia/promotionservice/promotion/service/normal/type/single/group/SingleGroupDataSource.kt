package com.rosia.promotionservice.promotion.service.normal.type.single.group

import com.rosia.promotionservice.promotion.data.ApplicableSkuLocalModel
import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.data.PromotionSkuGroupModel
import com.rosia.promotionservice.promotion.data.PromotionSkuModel
import com.rosia.promotionservice.promotion.data.SkuBatchModel
import com.rosia.promotionservice.promotion.data.SkuFamilyCriteriaModel
import com.rosia.promotionservice.promotion.service.PromotionConstant
import com.rosia.promotionservice.promotion.service.bill.criteria.operator.OperatorConstants

object SingleGroupDataSource {

    private fun getFakeGroupPromotionSkuModel(
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

    fun get_amount_amount_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth 2000 and get 10 rs off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
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
                        maxValue = 2500,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 2500,
                        skuCount = 0,
                        allowMultiple = false
                    ),
                    groupCriteriaLocalModel = PromotionSkuGroupModel(
                        id = 1,
                        promotionId = 1,
                        skuIds = "1",
                        type = PromotionConstant.CRITERIA_AMOUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 3000,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 3000,
                        skuCount = 0,
                        allowMultiple = false

                    )
                )
            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 310, skuId = 1)
            )
        )
    }

    fun get_amount_amount_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff group worth 2000 and get 10 rsoff",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
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
                        maxValue = 2500,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 2500,
                        skuCount = 0,
                        allowMultiple = false
                    ),
                    groupCriteriaLocalModel = PromotionSkuGroupModel(
                        id = 1,
                        promotionId = 1,
                        skuIds = "1",
                        type = PromotionConstant.CRITERIA_AMOUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 3000,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 3000,
                        skuCount = 0,
                        allowMultiple = false

                    )
                )
            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 260, skuId = 1)
            )
        )
    }

    fun get_amount_percent_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff group worth 2000 and get 10% off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                ApplicableSkuLocalModel(
                    skuId = 1,
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
                        maxValue = 2500,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 2500,
                        skuCount = 0,
                        allowMultiple = false
                    ),
                    groupCriteriaLocalModel = PromotionSkuGroupModel(
                        id = 1,
                        promotionId = 1,
                        skuIds = "1",
                        type = PromotionConstant.CRITERIA_AMOUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 3000,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 3000,
                        skuCount = 0,
                        allowMultiple = false

                    )
                )
            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 350, skuId = 1)
            )
        )
    }

    fun get_amount_percent_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff group worth 2000 and get 10% off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                ApplicableSkuLocalModel(
                    skuId = 1,
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
                        maxValue = 2500,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 2500,
                        skuCount = 0,
                        allowMultiple = false
                    ),
                    groupCriteriaLocalModel = PromotionSkuGroupModel(
                        id = 1,
                        promotionId = 1,
                        skuIds = "1",
                        type = PromotionConstant.CRITERIA_AMOUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 3000,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 3000,
                        skuCount = 0,
                        allowMultiple = false

                    )
                )
            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 250, skuId = 1)
            )
        )
    }

    fun get_amount_sku_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff group worth 2000 and get 1 for free",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                ApplicableSkuLocalModel(
                    skuId = 1,
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
                        maxValue = 2500,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 2500,
                        skuCount = 0,
                        allowMultiple = false
                    ),
                    groupCriteriaLocalModel = PromotionSkuGroupModel(
                        id = 1,
                        promotionId = 1,
                        skuIds = "1",
                        type = PromotionConstant.CRITERIA_AMOUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 3000,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 3000,
                        skuCount = 0,
                        allowMultiple = false

                    )
                )
            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 310, skuId = 1)
            )
        )
    }

    fun get_amount_sku_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff group worth 2000 and get 1 for free",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                ApplicableSkuLocalModel(
                    skuId = 1,
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
                        maxValue = 2500,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 2500,
                        skuCount = 0,
                        allowMultiple = false
                    ),
                    groupCriteriaLocalModel = PromotionSkuGroupModel(
                        id = 1,
                        promotionId = 1,
                        skuIds = "1",
                        type = PromotionConstant.CRITERIA_AMOUNT,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 3000,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 3000,
                        skuCount = 0,
                        allowMultiple = false

                    )
                )
            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 260, skuId = 1)
            )
        )
    }

    fun get_quantity_amount_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 of 2 diff group and get 10 rsoff",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
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
                        type = PromotionConstant.CRITERIA_QUANTITY,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 15,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 15,
                        skuCount = 0,
                        allowMultiple = false
                    ),
                    groupCriteriaLocalModel = PromotionSkuGroupModel(
                        id = 1,
                        promotionId = 1,
                        skuIds = "1",
                        type = PromotionConstant.CRITERIA_QUANTITY,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 20,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 20,
                        skuCount = 0,
                        allowMultiple = false

                    )
                )
            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 21, skuId = 1)
            )
        )
    }

    fun get_quantity_amount_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 of 2 diff group and get 10 rsoff",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
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
                        type = PromotionConstant.CRITERIA_QUANTITY,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 15,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 15,
                        skuCount = 0,
                        allowMultiple = false
                    ),
                    groupCriteriaLocalModel = PromotionSkuGroupModel(
                        id = 1,
                        promotionId = 1,
                        skuIds = "1",
                        type = PromotionConstant.CRITERIA_QUANTITY,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 20,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 20,
                        skuCount = 0,
                        allowMultiple = false

                    )
                )
            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 16, skuId = 1)
            )
        )
    }

    fun get_quantity_percent_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 pcs of 2 diff group and get 10 % off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1",
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
                    skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                        familyId = 1,
                        promotionId = 1,
                        type = PromotionConstant.CRITERIA_QUANTITY,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 15,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 15,
                        skuCount = 0,
                        allowMultiple = false
                    ),
                    groupCriteriaLocalModel = PromotionSkuGroupModel(
                        id = 1,
                        promotionId = 1,
                        skuIds = "1",
                        type = PromotionConstant.CRITERIA_QUANTITY,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 20,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 20,
                        skuCount = 0,
                        allowMultiple = false

                    )
                )
            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 20, skuId = 1)
            )
        )
    }

    fun get_quantity_percent_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 pcs of 2 diff group and get 10 % off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1",
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
                    skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                        familyId = 1,
                        promotionId = 1,
                        type = PromotionConstant.CRITERIA_QUANTITY,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 15,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 15,
                        skuCount = 0,
                        allowMultiple = false
                    ),
                    groupCriteriaLocalModel = PromotionSkuGroupModel(
                        id = 1,
                        promotionId = 1,
                        skuIds = "1",
                        type = PromotionConstant.CRITERIA_QUANTITY,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 20,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 20,
                        skuCount = 0,
                        allowMultiple = false

                    )
                )
            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 19, skuId = 1)
            )
        )
    }

    fun get_quantity_sku_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 pcs of 2 diff family and get 1 sku free",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            allowMultiple = true,
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
                        type = PromotionConstant.CRITERIA_QUANTITY,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 15,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 15,
                        skuCount = 0,
                        allowMultiple = false
                    ),
                    groupCriteriaLocalModel = PromotionSkuGroupModel(
                        id = 1,
                        promotionId = 1,
                        skuIds = "1",
                        type = PromotionConstant.CRITERIA_QUANTITY,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 20,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 20,
                        skuCount = 0,
                        allowMultiple = false

                    )
                )
            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 20, skuId = 1)
            )
        )
    }

    fun get_quantity_sku_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 pcs of 2 diff family and get 1 sku free",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            applicableSkuIds = "1",
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
                    skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                        familyId = 1,
                        promotionId = 1,
                        type = PromotionConstant.CRITERIA_QUANTITY,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 15,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 15,
                        skuCount = 0,
                        allowMultiple = false
                    ),
                    groupCriteriaLocalModel = PromotionSkuGroupModel(
                        id = 1,
                        promotionId = 1,
                        skuIds = "1",
                        type = PromotionConstant.CRITERIA_QUANTITY,
                        maxType = OperatorConstants.GREATER_THAN_EQUALS,
                        maxValue = 20,
                        minType = OperatorConstants.GREATER_THAN_EQUALS,
                        minValue = 20,
                        skuCount = 0,
                        allowMultiple = false

                    )
                )
            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 19, skuId = 1)
            )
        )
    }
}