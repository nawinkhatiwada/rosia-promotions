package com.rosia.promotionservice.promotion.service.topup.multiple.promotion

import com.rosia.promotionservice.promotion.data.*
import com.rosia.promotionservice.promotion.service.PromotionConstant
import com.rosia.promotionservice.promotion.service.bill.criteria.operator.OperatorConstants

object TopupMultiplePromotionDataSource {

    private fun getFakePromotionSkuModel(
        quantity: Int,
        isSelected: Boolean = true,
        skuId: Long = 1,
        skuName: String = "Vicks 100ml"
    ): PromotionSkuModel {
        return PromotionSkuModel(
            skuId = skuId,
            skuName = skuName,
            brandName = "Vicks",
            moq = 5,
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
            familyStatus = false,
            skuFamilyCriteriaModel = null,
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

    private fun getFakeApplicableSkuModelWithAmountCriteria(
        skuId: Long,
        skuGroupId: Int = 1,
        applicableSkuGroupIds: String = "1,2",
        skuMoq: Int = 50,
        skuGroupMoq: Int = 100
    ): ApplicableSkuLocalModel {
        return ApplicableSkuLocalModel(
            skuId = skuId,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = skuMoq,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 50,
            skuGroupId = skuGroupId,
            familyStatus = false,
            skuFamilyCriteriaModel = null,
            groupCriteriaLocalModel = PromotionSkuGroupModel(
                id = skuGroupId.toLong(),
                promotionId = 1,
                skuIds = applicableSkuGroupIds,
                type = PromotionConstant.CRITERIA_AMOUNT,
                maxValue = skuGroupMoq,
                maxType = OperatorConstants.GREATER_THAN_EQUALS,
                minValue = skuGroupMoq,
                minType = OperatorConstants.GREATER_THAN_EQUALS,
                skuCount = 1,
                allowMultiple = false

            )
        )
    }

    // Quantity criteria, Percent disbursement

    fun get_topup_multiple_quantity_percent_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and 10 gm and get 2% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
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
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 2
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(
                    1,
                    1,
                    "1,2"
                ),
                getFakeApplicableSkuModel(
                    2,
                    1,
                    "1,2"
                )
            )
        )
    }

    fun get_topup_multiple_quantity_percent_promotion_sku_moq_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and 10 gm and get 2% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 5,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 2.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 10,
                    skuId = 2
                ),
                getFakePromotionSkuModel(
                    quantity = 2,
                    skuId = 3
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(
                    1,
                    1,
                    "1,2,3",
                    skuMoq = 5
                ),
                getFakeApplicableSkuModel(
                    2,
                    1,
                    "1,2,3",
                    skuMoq = 10
                ),
                getFakeApplicableSkuModel(
                    3,
                    1,
                    "1,2,3",
                    skuMoq = 20
                )
            )
        )
    }

    fun get_topup_multiple_quantity_percent_promotion_sku_group_moq_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and 10 gm and get 2% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 5,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 2
                ),
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 3
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(
                    1,
                    1,
                    "1,2,3",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModel(
                    2,
                    1,
                    "1,2,3",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModel(
                    3,
                    1,
                    "1,2,3",
                    skuGroupMoq = 20
                )
            )
        )
    }

    fun get_topup_multiple_quantity_percent_promotion_multiple_group_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and 10 gm and get 2% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 200,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 200,
            skuCount = 4,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 2
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 3
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 4
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(
                    1,
                    1,
                    "1,2",
                    skuGroupMoq = 2
                ),
                getFakeApplicableSkuModel(
                    2,
                    1,
                    "1,2",
                    skuGroupMoq = 2
                ),
                getFakeApplicableSkuModel(
                    3,
                    2,
                    "3,4",
                    skuGroupMoq = 2
                ),
                getFakeApplicableSkuModel(
                    4,
                    2,
                    "3,4",
                    skuGroupMoq = 2
                )
            )
        )
    }

    fun get_topup_multiple_quantity_percent_promotion_multiple_group_sku_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and 10 gm and get 2% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 200,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 200,
            skuCount = 4,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 1,
                    skuName = "Vicks 1"
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 2,
                    skuName = "Vicks 2"
                ),
                getFakePromotionSkuModel(
                    quantity = 1,
                    skuId = 3,
                    skuName = "Vicks 3"
                ),
                getFakePromotionSkuModel(
                    quantity = 1,
                    skuId = 44,
                    skuName = "Vicks 4"
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(
                    1,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModel(
                    2,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModel(
                    3,
                    2,
                    "3,4",
                    skuGroupMoq = 10
                ),
                getFakeApplicableSkuModel(
                    4,
                    2,
                    "3,4",
                    skuGroupMoq = 10
                )
            )
        )
    }

    fun get_topup_multiple_quantity_percent_promotion_multiple_group_sku_group_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and 10 gm and get 2% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 200,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 200,
            skuCount = 4,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 1,
                    skuName = "Vicks 1"
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 2,
                    skuName = "Vicks 2"
                ),
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 3,
                    skuName = "Vicks 3"
                ),
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 44,
                    skuName = "Vicks 4"
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(
                    1,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModel(
                    2,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModel(
                    3,
                    2,
                    "3,4",
                    skuGroupMoq = 12
                ),
                getFakeApplicableSkuModel(
                    4,
                    2,
                    "3,4",
                    skuGroupMoq = 12
                )
            )
        )
    }

    fun get_topup_multiple_quantity_percent_promotion_multiple_group_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and 10 gm and get 2% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 200,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 200,
            skuCount = 4,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 1,
                    skuName = "Vicks 1"
                ),
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 2,
                    skuName = "Vicks 2"
                ),
                getFakePromotionSkuModel(
                    quantity = 10,
                    skuId = 3,
                    skuName = "Vicks 3"
                ),
                getFakePromotionSkuModel(
                    quantity = 10,
                    skuId = 4,
                    skuName = "Vicks 4"
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(
                    1,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModel(
                    2,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModel(
                    3,
                    2,
                    "3,4",
                    skuGroupMoq = 12
                ),
                getFakeApplicableSkuModel(
                    4,
                    2,
                    "3,4",
                    skuGroupMoq = 12
                )
            )
        )
    }

    fun get_topup_multiple_quantity_percent_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and get 2% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
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
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 10,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 10,
                    skuId = 2
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(
                    1,
                    1,
                    "1,2"
                ),
                getFakeApplicableSkuModel(
                    2,
                    1,
                    "1,2"
                )
            )
        )
    }

    // Quantity criteria, Amount disbursement

    fun get_topup_multiple_quantity_amount_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and get 100 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
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
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 2
                ),
                getFakePromotionSkuModel(
                    quantity = 80,
                    skuId = 3
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(
                    1,
                    1,
                    "1,2,3"
                ),
                getFakeApplicableSkuModel(
                    2,
                    1,
                    "1,2,3"
                ),
                getFakeApplicableSkuModel(
                    3,
                    1,
                    "1,2,3"
                )
            )
        )
    }

    fun get_topup_multiple_quantity_amount_promotion_sku_moq_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and get 100 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 5,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 10,
                    skuId = 2
                ),
                getFakePromotionSkuModel(
                    quantity = 2,
                    skuId = 3
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(
                    1,
                    1,
                    "1,2,3",
                    skuMoq = 5
                ),
                getFakeApplicableSkuModel(
                    2,
                    1,
                    "1,2,3",
                    skuMoq = 10
                ),
                getFakeApplicableSkuModel(
                    3,
                    1,
                    "1,2,3",
                    skuMoq = 20
                )
            )
        )
    }

    fun get_topup_multiple_quantity_amount_promotion_sku_group_moq_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and get 100 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 5,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 2
                ),
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 3
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(
                    1,
                    1,
                    "1,2,3",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModel(
                    2,
                    1,
                    "1,2,3",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModel(
                    3,
                    1,
                    "1,2,3",
                    skuGroupMoq = 20
                )
            )
        )
    }

    fun get_topup_multiple_quantity_amount_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and get 100 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 10,
                    skuId = 2
                ),
                getFakePromotionSkuModel(
                    quantity = 80,
                    skuId = 3
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(
                    1,
                    1,
                    "1,2,3"
                ),
                getFakeApplicableSkuModel(
                    2,
                    1,
                    "1,2,3"
                ),
                getFakeApplicableSkuModel(
                    3,
                    1,
                    "1,2,3"
                )
            )
        )
    }

    fun get_topup_multiple_quantity_amount_promotion_multiple_group_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 200 Pcs of Vicks Vaporub - 5 gm and 10 gm and get 100rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 200,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 200,
            skuCount = 4,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1,2,3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 2
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 3
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 4
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(
                    1,
                    1,
                    "1,2",
                    skuGroupMoq = 2
                ),
                getFakeApplicableSkuModel(
                    2,
                    1,
                    "1,2",
                    skuGroupMoq = 2
                ),
                getFakeApplicableSkuModel(
                    3,
                    2,
                    "3,4",
                    skuGroupMoq = 2
                ),
                getFakeApplicableSkuModel(
                    4,
                    2,
                    "3,4",
                    skuGroupMoq = 2
                )
            )
        )
    }

    fun get_topup_multiple_quantity_amount_promotion_multiple_group_sku_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 200 Pcs of Vicks Vaporub - 5 gm and 10 gm and get 100rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 200,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 200,
            skuCount = 4,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1,2,3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 1,
                    skuName = "Vicks 1"
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 2,
                    skuName = "Vicks 2"
                ),
                getFakePromotionSkuModel(
                    quantity = 1,
                    skuId = 3,
                    skuName = "Vicks 3"
                ),
                getFakePromotionSkuModel(
                    quantity = 1,
                    skuId = 44,
                    skuName = "Vicks 4"
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(
                    1,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModel(
                    2,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModel(
                    3,
                    2,
                    "3,4",
                    skuGroupMoq = 10
                ),
                getFakeApplicableSkuModel(
                    4,
                    2,
                    "3,4",
                    skuGroupMoq = 10
                )
            )
        )
    }

    fun get_topup_multiple_quantity_amount_promotion_multiple_group_sku_group_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 200 Pcs of Vicks Vaporub - 5 gm and 10 gm and get 100 off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 200,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 200,
            skuCount = 4,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1,2,3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 1,
                    skuName = "Vicks 1"
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 2,
                    skuName = "Vicks 2"
                ),
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 3,
                    skuName = "Vicks 3"
                ),
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 4,
                    skuName = "Vicks 4"
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(
                    1,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModel(
                    2,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModel(
                    3,
                    2,
                    "3,4",
                    skuGroupMoq = 12
                ),
                getFakeApplicableSkuModel(
                    4,
                    2,
                    "3,4",
                    skuGroupMoq = 12
                )
            )
        )
    }

    fun get_topup_multiple_quantity_amount_promotion_multiple_group_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 100 Pcs of Vicks Vaporub - 5 gm and 10 gm and get 100 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 200,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 200,
            skuCount = 4,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1,2,3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 1,
                    skuName = "Vicks 1"
                ),
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 2,
                    skuName = "Vicks 2"
                ),
                getFakePromotionSkuModel(
                    quantity = 10,
                    skuId = 3,
                    skuName = "Vicks 3"
                ),
                getFakePromotionSkuModel(
                    quantity = 10,
                    skuId = 4,
                    skuName = "Vicks 4"
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModel(
                    1,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModel(
                    2,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModel(
                    3,
                    2,
                    "3,4",
                    skuGroupMoq = 12
                ),
                getFakeApplicableSkuModel(
                    4,
                    2,
                    "3,4",
                    skuGroupMoq = 12
                )
            )
        )
    }

    // Amount criteria, Percent disbursement

    fun get_topup_multiple_amount_percent_promotion_success(): PromotionModel {
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
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 100,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 80,
                    skuId = 2
                ),
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 3
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 4
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    1,
                    1,
                    "1,2,3"
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    2,
                    1,
                    "1,2,3"
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    3,
                    1,
                    "1,2,3"
                )
            )
        )
    }

    fun get_topup_multiple_amount_percent_promotion_sku_moq_error(): PromotionModel {
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
            skuCount = 3,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 1,
                    skuName = "Vicks 1"
                ),
                getFakePromotionSkuModel(
                    quantity = 10,
                    skuId = 2,
                    skuName = "Vicks 2"
                ),
                getFakePromotionSkuModel(
                    quantity = 4,
                    skuId = 3,
                    skuName = "Vicks 3"
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    1,
                    1,
                    "1,2,3",
                    skuMoq = 5
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    2,
                    1,
                    "1,2,3",
                    skuMoq = 10
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    3,
                    1,
                    "1,2,3",
                    skuMoq = 25
                )
            )
        )
    }

    fun get_topup_multiple_amount_percent_promotion_sku_group_moq_error(): PromotionModel {
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
            skuCount = 3,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 2
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 3
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    1,
                    1,
                    "1,2,3",
                    skuGroupMoq = 1900
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    2,
                    1,
                    "1,2,3",
                    skuGroupMoq = 1900
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    3,
                    1,
                    "1,2,3",
                    skuGroupMoq = 1900
                )
            )
        )
    }

    fun get_topup_multiple_amount_percent_promotion_error(): PromotionModel {

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
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 2
                ),
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 3
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    1,
                    1,
                    "1,2,3",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    2,
                    1,
                    "1,2,3",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    3,
                    1,
                    "1,2,3",
                    skuGroupMoq = 20
                )
            )
        )
    }

    fun get_topup_multiple_amount_percent_promotion_multiple_group_success(): PromotionModel {
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
            skuCount = 4,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 2
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 3
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 4
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    1,
                    1,
                    "1,2",
                    skuGroupMoq = 2
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    2,
                    1,
                    "1,2",
                    skuGroupMoq = 2
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    3,
                    2,
                    "3,4",
                    skuGroupMoq = 2
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    4,
                    2,
                    "3,4",
                    skuGroupMoq = 2
                )
            )
        )
    }

    fun get_topup_multiple_amount_percent_promotion_multiple_group_sku_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs200 get 10 % off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 200,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 200,
            skuCount = 4,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 1,
                    skuName = "Vicks 1"
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 2,
                    skuName = "Vicks 2"
                ),
                getFakePromotionSkuModel(
                    quantity = 1,
                    skuId = 3,
                    skuName = "Vicks 3"
                ),
                getFakePromotionSkuModel(
                    quantity = 1,
                    skuId = 44,
                    skuName = "Vicks 4"
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    1,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    2,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    3,
                    2,
                    "3,4",
                    skuGroupMoq = 10
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    4,
                    2,
                    "3,4",
                    skuGroupMoq = 10
                )
            )
        )
    }

    fun get_topup_multiple_amount_percent_promotion_multiple_group_sku_group_error(): PromotionModel {
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
            skuCount = 4,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 1,
                    skuName = "Vicks 1"
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 2,
                    skuName = "Vicks 2"
                ),
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 3,
                    skuName = "Vicks 3"
                ),
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 44,
                    skuName = "Vicks 4"
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    1,
                    1,
                    "1,2",
                    skuGroupMoq = 200
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    2,
                    1,
                    "1,2",
                    skuGroupMoq = 200
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    3,
                    2,
                    "3,4",
                    skuGroupMoq = 120
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    4,
                    2,
                    "3,4",
                    skuGroupMoq = 120
                )
            )
        )
    }

    fun get_topup_multiple_amount_percent_promotion_multiple_group_error(): PromotionModel {
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
            skuCount = 4,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 1,
                    skuName = "Vicks 1"
                ),
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 2,
                    skuName = "Vicks 2"
                ),
                getFakePromotionSkuModel(
                    quantity = 10,
                    skuId = 3,
                    skuName = "Vicks 3"
                ),
                getFakePromotionSkuModel(
                    quantity = 10,
                    skuId = 4,
                    skuName = "Vicks 4"
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    1,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    2,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    3,
                    2,
                    "3,4",
                    skuGroupMoq = 12
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    4,
                    2,
                    "3,4",
                    skuGroupMoq = 12
                )
            )
        )
    }

    // Amount criteria, Amount disbursement

    fun get_topup_multiple_amount_amount_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rsoff",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
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
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 100,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 100,
                    skuId = 2
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    1,
                    1,
                    "1,2"
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    2,
                    1,
                    "1,2"
                )
            )
        )
    }

    fun get_topup_multiple_amount_amount_promotion_sku_moq_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 5,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 10,
                    skuId = 2
                ),
                getFakePromotionSkuModel(
                    quantity = 2,
                    skuId = 3
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    1,
                    1,
                    "1,2,3",
                    skuMoq = 50
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    2,
                    1,
                    "1,2,3",
                    skuMoq = 100
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    3,
                    1,
                    "1,2,3",
                    skuMoq = 20
                )
            )
        )
    }

    fun get_topup_multiple_amount_amount_promotion_sku_group_moq_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 3,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1,2,3",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 2
                ),
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 3
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    1,
                    1,
                    "1,2,3",
                    skuGroupMoq = 200
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    2,
                    1,
                    "1,2,3",
                    skuGroupMoq = 200
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    3,
                    1,
                    "1,2,3",
                    skuGroupMoq = 200
                )
            )
        )
    }

    fun get_topup_multiple_amount_amount_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
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
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 10,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 10,
                    skuId = 2
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    1,
                    1,
                    "1,2"
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    2,
                    1,
                    "1,2"
                )
            )
        )
    }

    fun get_topup_multiple_amount_amount_promotion_multiple_group_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 4,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1,2,3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 1
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 2
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 3
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 4
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 5
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    1,
                    1,
                    "1,2",
                    skuGroupMoq = 2
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    2,
                    1,
                    "1,2",
                    skuGroupMoq = 2
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    3,
                    2,
                    "3,4",
                    skuGroupMoq = 2
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    4,
                    2,
                    "3,4",
                    skuGroupMoq = 2
                )
            )
        )
    }

    fun get_topup_multiple_amount_amount_promotion_multiple_group_sku_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 4,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1,2,3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 1,
                    skuName = "Vicks 1"
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 2,
                    skuName = "Vicks 2"
                ),
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 3,
                    skuName = "Vicks 3"
                ),
                getFakePromotionSkuModel(
                    quantity = 1,
                    skuId = 4,
                    skuName = "Vicks 4"
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    1,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    2,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    3,
                    2,
                    "3,4",
                    skuGroupMoq = 10
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    4,
                    2,
                    "3,4",
                    skuGroupMoq = 10
                )
            )
        )
    }

    fun get_topup_multiple_amount_amount_promotion_multiple_group_sku_group_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 4,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1,2,3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 1,
                    skuName = "Vicks 1"
                ),
                getFakePromotionSkuModel(
                    quantity = 50,
                    skuId = 2,
                    skuName = "Vicks 2"
                ),
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 3,
                    skuName = "Vicks 3"
                ),
                getFakePromotionSkuModel(
                    quantity = 5,
                    skuId = 4,
                    skuName = "Vicks 4"
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    1,
                    1,
                    "1,2",
                    skuGroupMoq = 200
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    2,
                    1,
                    "1,2",
                    skuGroupMoq = 200
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    3,
                    2,
                    "3,4",
                    skuGroupMoq = 150
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    4,
                    2,
                    "3,4",
                    skuGroupMoq = 150
                )
            )
        )
    }

    fun get_topup_multiple_amount_amount_promotion_multiple_group_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 4,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            applicableSkuIds = "1,2,3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            skuList = listOf(
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 1,
                    skuName = "Vicks 1"
                ),
                getFakePromotionSkuModel(
                    quantity = 20,
                    skuId = 2,
                    skuName = "Vicks 2"
                ),
                getFakePromotionSkuModel(
                    quantity = 10,
                    skuId = 3,
                    skuName = "Vicks 3"
                ),
                getFakePromotionSkuModel(
                    quantity = 10,
                    skuId = 4,
                    skuName = "Vicks 4"
                )
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    1,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    2,
                    1,
                    "1,2",
                    skuGroupMoq = 20
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    3,
                    2,
                    "3,4",
                    skuGroupMoq = 12
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    4,
                    2,
                    "3,4",
                    skuGroupMoq = 12
                )
            )
        )
    }
}