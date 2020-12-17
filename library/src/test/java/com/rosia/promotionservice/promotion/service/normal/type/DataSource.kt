package com.rosia.promotionservice.promotion.service.normal.type

import com.rosia.promotionservice.promotion.data.ApplicableSkuLocalModel
import com.rosia.promotionservice.promotion.data.DisbursementSkuModel
import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.data.PromotionSkuModel
import com.rosia.promotionservice.promotion.data.SkuBatchModel
import com.rosia.promotionservice.promotion.data.SkuFamilyCriteriaModel
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
            skuName = "Ariel 10gm",
            brandName = "Ariel",
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
            grossAmount = 0.0,
            netAmount = 0.0,
            vatAmount = 0.0,
            taxableAmount = 0.0,
            orderId = 0,
            topUpDiscount = 0.0,
            stockQty = 10
        )
    }

    private fun getFakeApplicableSkuModelWithAmountCriteria(
        skuId: Long = 1,
        skuGroupId: Int = 1
    ): ApplicableSkuLocalModel {
        return ApplicableSkuLocalModel(
            skuId = skuId,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 0,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 0,
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

    private fun getFakeApplicableSkuModelWithCountCriteria(
        skuId: Long = 1,
        skuGroupId: Int = 1
    ): ApplicableSkuLocalModel {
        return ApplicableSkuLocalModel(
            skuId = skuId,
            criteriaType = PromotionConstant.CRITERIA_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 0,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 0,
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
        skuId: Long = 1,
        skuGroupId: Int = 1
    ): ApplicableSkuLocalModel {
        return ApplicableSkuLocalModel(
            skuId = skuId,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 0,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 0,
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

    fun get_normal_single_quantity_percent_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 3 get 5% off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 3,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 3,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 5.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria()
            ),
            skuList = listOf(
                getFakePromotionSkuModel(10)
            )
        )
    }

    fun get_normal_single_quantity_percent_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 3 get 5% off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 3,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 3,
            skuCount = 1,
            applicableSkuIds = "1",
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 5.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria()
            ),
            skuList = listOf(
                getFakePromotionSkuModel(1)
            )
        )
    }

    fun get_normal_single_quantity_amount_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 get 10rs off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 1,
            allowMultiple = false,
            applicableSkuIds = "1",
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria()
            ),
            skuList = listOf(
                getFakePromotionSkuModel(10)
            )
        )
    }

    fun get_normal_single_quantity_amount_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 3 get 100rs off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 3,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 3,
            skuCount = 1,
            applicableSkuIds = "1",
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria()
            ),
            skuList = listOf(
                getFakePromotionSkuModel(1)
            )
        )
    }

    fun get_normal_single_quantity_sku_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 3 get 1 free",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 3,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 3,
            skuCount = 1,
            applicableSkuIds = "1",
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            allowMultiple = true,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria()
            ),
            skuList = listOf(
                getFakePromotionSkuModel(10)
            ),
            disbursementSkuList = listOf(
                DisbursementSkuModel(
                    skuId = 1,
                    batchId = 1,
                    skuName = "Ariel 1gm",
                    freeQuantity = 1,
                    isSelected = true,
                    selectedQuantity = 1
                )
            )
        )
    }

    fun get_normal_single_quantity_sku_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 3 SKUs and get 1 SKU free",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 3,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 3,
            skuCount = 1,
            applicableSkuIds = "1",
            allowMultiple = true,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria()
            ),
            skuList = listOf(
                PromotionSkuModel(
                    skuId = 1,
                    skuName = "Ariel 10gm",
                    brandName = "Ariel",
                    moq = 2,
                    quantity = 2,
                    promotionStatus = true,
                    inStock = true,
                    batchList = listOf(
                        SkuBatchModel(
                            id = 1,
                            rlpVat = 11.30,
                            batchTitle = "First",
                            isSelected = true,
                            rlp = 10.0,
                            vatPercent = 0.13
                        )
                    ),
                    discountAmount = 0.0,
                    grossAmount = 0.0,
                    netAmount = 0.0,
                    vatAmount = 0.0,
                    taxableAmount = 0.0,
                    orderId = 0L,
                    topUpDiscount = 0.0,
                    stockQty = 10
                )
            ),
            disbursementSkuList = listOf(
                DisbursementSkuModel(
                    skuId = 1,
                    batchId = 1,
                    skuName = "Ariel 1gm",
                    freeQuantity = 1,
                    isSelected = true,
                    selectedQuantity = 2
                )
            )
        )
    }

    fun get_normal_single_amount_percent_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy worth rs 100 and get 5% off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 5.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria()
            ),
            skuList = listOf(
                getFakePromotionSkuModel(20)
            )
        )
    }

    fun get_normal_single_amount_percent_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy worth rs 100 and get 5% off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            applicableSkuIds = "1",
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 5.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria()
            ),
            skuList = listOf(
                getFakePromotionSkuModel(1)
            )
        )
    }

    fun get_normal_single_amount_amount_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy worth rs 100 and get 5 rs off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            applicableSkuIds = "1",
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 5.0,
            allowMultiple = true,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria()
            ),
            skuList = listOf(
                getFakePromotionSkuModel(20)
            )
        )
    }

    fun get_normal_single_amount_amount_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy worth rs 100 and get 5 rs off off",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            applicableSkuIds = "1",
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 5.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria()
            ),
            skuList = listOf(
                getFakePromotionSkuModel(1)
            )
        )
    }

    fun get_normal_single_amount_sku_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy worth rs 100 and get 1 free",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            applicableSkuIds = "1",
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            allowMultiple = true,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria()
            ),
            skuList = listOf(
                getFakePromotionSkuModel(20)
            ),
            disbursementSkuList = listOf(
                DisbursementSkuModel(
                    skuId = 1,
                    batchId = 1,
                    skuName = "Ariel 1gm",
                    freeQuantity = 1,
                    isSelected = true,
                    selectedQuantity = 1
                )
            )
        )
    }

    fun get_normal_single_amount_sku_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy worth rs 100 and get 1 free",
            promotionState = PromotionConstant.SINGLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            applicableSkuIds = "1",
            allowMultiple = true,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria()
            ),
            skuList = listOf(
                getFakePromotionSkuModel(2)

            ),
            disbursementSkuList = listOf()
        )
    }

    fun get_normal_multiple_quantity_percent_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 3 get 5% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 3,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 3,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 5.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithQuantityCriteria(
                    skuId = 2
                )
            ),
            skuList = listOf(
                getFakePromotionSkuModel(5),
                getFakePromotionSkuModel(1)
            )
        )
    }

    fun get_normal_multiple_quantity_percent_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 3 get 5% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 3,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 3,
            skuCount = 1,
            applicableSkuIds = "1,2",
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 5.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithQuantityCriteria(
                    skuId = 2
                )
            ), skuList = listOf(
                getFakePromotionSkuModel(1),
                getFakePromotionSkuModel(1)
            )
        )
    }

    fun get_normal_multiple_quantity_amount_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 3 get 100 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 3,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 3,
            skuCount = 1,
            applicableSkuIds = "1,2",
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 100.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithQuantityCriteria(
                    skuId = 2
                )
            ),
            skuList = listOf(
                getFakePromotionSkuModel(1),
                getFakePromotionSkuModel(2)
            )
        )
    }

    fun get_normal_multiple_quantity_amount_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 3 get 100rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 3,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 3,
            skuCount = 1,
            applicableSkuIds = "1,2",
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 5.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithQuantityCriteria(
                    skuId = 2
                )
            ),
            skuList = listOf(
                getFakePromotionSkuModel(1),
                getFakePromotionSkuModel(1)
            )
        )
    }

    fun get_normal_multiple_quantity_sku_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 3 get 1 sku for free",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 3,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 3,
            skuCount = 1,
            applicableSkuIds = "1,2",
            allowMultiple = true,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 2.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithQuantityCriteria(
                    skuId = 2
                )
            ),
            skuList = listOf(
                getFakePromotionSkuModel(2),
                getFakePromotionSkuModel(5)
            ),
            disbursementSkuList = listOf(
                DisbursementSkuModel(
                    skuId = 1,
                    batchId = 1,
                    skuName = "Ariel 1gm",
                    freeQuantity = 1,
                    isSelected = false,
                    selectedQuantity = 1
                )
            )
        )
    }

    fun get_normal_multiple_quantity_sku_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy 3 get 1 free",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 3,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 3,
            skuCount = 1,
            applicableSkuIds = "1,2",
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithQuantityCriteria(
                    skuId = 2
                )
            ),
            skuList = listOf(
                getFakePromotionSkuModel(1),
                getFakePromotionSkuModel(1)
            ),
            disbursementSkuList = emptyList()
        )
    }

    fun get_normal_multiple_amount_percent_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy worth Rs 100 get 5% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            applicableSkuIds = "1,2",
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 5.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    skuId = 2
                )
            ),
            skuList = listOf(
                getFakePromotionSkuModel(10),
                getFakePromotionSkuModel(5)
            )
        )
    }

    fun get_normal_multiple_amount_percent_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy worth Rs 100 and get 5% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            applicableSkuIds = "1,2",
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 100.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    skuId = 2
                )
            ), skuList = listOf(
                getFakePromotionSkuModel(1),
                getFakePromotionSkuModel(1)
            )
        )
    }

    fun get_normal_multiple_amount_amount_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy worth Rs 100 and get 10 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            applicableSkuIds = "1,2",
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            allowMultiple = true,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    skuId = 2
                )
            ),
            skuList = listOf(
                getFakePromotionSkuModel(5),
                getFakePromotionSkuModel(5)
            )
        )
    }

    fun get_normal_multiple_amount_amount_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy worth Rs 100 and get 100rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            applicableSkuIds = "1,2",
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    skuId = 2
                )
            ),
            skuList = listOf(
                getFakePromotionSkuModel(1),
                getFakePromotionSkuModel(1)
            )
        )
    }

    fun get_normal_multiple_amount_sku_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy worth Rs 100 and get 1 sku for free",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            allowMultiple = true,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    skuId = 2
                )
            ),
            skuList = listOf(
                getFakePromotionSkuModel(20)
            ),
            disbursementSkuList = listOf(
                /*DisbursementSkuModel(
                    skuId = 1,
                    skuName = "Ariel 1gm",
                    freeQuantity = 1,
                    isSelected = false,
                    selectedQuantity = 1
                )*/
            )
        )
    }

    fun get_normal_multiple_amount_sku_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy worth Rs 100 and get 1 free",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 100,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 100,
            skuCount = 1,
            applicableSkuIds = "1,2",
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    skuId = 2
                )
            ),
            skuList = listOf(
                getFakePromotionSkuModel(1),
                getFakePromotionSkuModel(1)
            ),
            disbursementSkuList = emptyList()
        )
    }

    fun get_normal_multiple_count_percent_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy any 3 sku and get 5% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 3,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 3,
            skuCount = 1,
            applicableSkuIds = "1,2",
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 5.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithCountCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithCountCriteria(
                    skuId = 2
                )
            ),
            skuList = listOf(
                getFakePromotionSkuModel(5),
                getFakePromotionSkuModel(1),
                getFakePromotionSkuModel(5)
            )
        )
    }

    fun get_normal_multiple_count_percent_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy any 3 skus and get 5% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 3,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 3,
            skuCount = 1,
            applicableSkuIds = "1,2",
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 1.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithCountCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithCountCriteria(
                    skuId = 2
                )
            ),
            skuList = listOf(
                getFakePromotionSkuModel(1),
                getFakePromotionSkuModel(1)
            )
        )
    }

    fun get_normal_multiple_count_amount_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy any 3 skus and get 10 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 3,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 3,
            skuCount = 1,
            applicableSkuIds = "1,2",
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            allowMultiple = true,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithCountCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithCountCriteria(
                    skuId = 2
                )
            ),
            skuList = listOf(
                getFakePromotionSkuModel(5),
                getFakePromotionSkuModel(5),
                getFakePromotionSkuModel(3),
                getFakePromotionSkuModel(3),
                getFakePromotionSkuModel(2),
                getFakePromotionSkuModel(2)
            )
        )
    }

    fun get_normal_multiple_count_amount_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy any 3 skus and get 10rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 3,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 3,
            skuCount = 1,
            applicableSkuIds = "1,2",
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 1.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithCountCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithCountCriteria(
                    skuId = 2
                )
            ),
            skuList = listOf(
                getFakePromotionSkuModel(1),
                getFakePromotionSkuModel(1)
            )
        )
    }

    fun get_normal_multiple_count_sku_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy any 3 skus and get 1 sku for free",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 3,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 3,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            allowMultiple = true,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithCountCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithCountCriteria(
                    skuId = 2
                )
            ),
            skuList = listOf(
                getFakePromotionSkuModel(5),
                getFakePromotionSkuModel(5),
                getFakePromotionSkuModel(5),
                getFakePromotionSkuModel(5),
                getFakePromotionSkuModel(5),
                getFakePromotionSkuModel(5)
            ),
            disbursementSkuList = listOf(
                DisbursementSkuModel(
                    skuId = 1,
                    batchId = 1,
                    skuName = "Ariel 1gm",
                    freeQuantity = 1,
                    isSelected = false,
                    selectedQuantity = 1
                )
            )
        )
    }

    fun get_normal_multiple_count_sku_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy any 3 skus and get 1 free",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 3,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 3,
            skuCount = 1,
            applicableSkuIds = "1,2",
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            promotionType = PromotionConstant.PROMOTION_TYPE_NORMAL,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithCountCriteria(
                    skuId = 1
                ),
                getFakeApplicableSkuModelWithCountCriteria(
                    skuId = 2
                )
            ),
            skuList = listOf(
                getFakePromotionSkuModel(1),
                getFakePromotionSkuModel(1)
            ),
            disbursementSkuList = emptyList()
        )
    }
}