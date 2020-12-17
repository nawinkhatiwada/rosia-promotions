package com.rosia.promotionservice.promotion.service.bill.multiple.promotion

import com.rosia.promotionservice.promotion.data.ApplicableSkuLocalModel
import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.data.PromotionSkuGroupModel
import com.rosia.promotionservice.promotion.data.PromotionSkuModel
import com.rosia.promotionservice.promotion.data.SkuBatchModel
import com.rosia.promotionservice.promotion.data.SkuFamilyCriteriaModel
import com.rosia.promotionservice.promotion.service.PromotionConstant
import com.rosia.promotionservice.promotion.service.bill.criteria.operator.OperatorConstants

object BillMultiplePromotionDataSource {
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

    private fun getFakeApplicableSkuModelWithAmountCriteria(
        skuId: Long,
        skuGroupId: Int = 1,
        familyMinMax: Int = 0,
        groupMinMax: Int = 0,
        groupSkuIds: String = "1,2,3"
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
            familyId = -1,
            skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                familyId = 1,
                promotionId = 1,
                type = PromotionConstant.CRITERIA_AMOUNT,
                maxType = OperatorConstants.GREATER_THAN_EQUALS,
                maxValue = familyMinMax,
                minType = OperatorConstants.GREATER_THAN_EQUALS,
                minValue = familyMinMax,
                skuCount = 0,
                allowMultiple = false
            ),
            groupCriteriaLocalModel = PromotionSkuGroupModel(
                id = 1,
                promotionId = 1,
                skuIds = groupSkuIds,
                type = PromotionConstant.CRITERIA_AMOUNT,
                maxType = OperatorConstants.GREATER_THAN_EQUALS,
                maxValue = groupMinMax,
                minType = OperatorConstants.GREATER_THAN_EQUALS,
                minValue = groupMinMax,
                skuCount = 0,
                allowMultiple = false
            )
        )
    }

    private fun getFakeApplicableSkuModelWithGroupCountCriteria(
        skuId: Long = 1,
        skuGroupId: Int = 1,
        groupSkuIds: String = "1,2",
        groupMinMax: Int = 5,
        groupId: Long = 1
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
            groupCriteriaLocalModel = PromotionSkuGroupModel(
                id = groupId,
                promotionId = 1,
                skuIds = groupSkuIds,
                type = PromotionConstant.CRITERIA_AMOUNT,
                maxType = OperatorConstants.GREATER_THAN_EQUALS,
                maxValue = groupMinMax,
                minType = OperatorConstants.GREATER_THAN_EQUALS,
                minValue = groupMinMax,
                skuCount = 0,
                allowMultiple = false

            )
        )
    }

    fun get_bill_multiple_quantity_percent_promotion_success(): PromotionModel {

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
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
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
            familyStatus = false,
            familyId = -1,
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
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2)
            ),
            skuList = listOf(
                getFakePromotionSkuModel(1),
                getFakePromotionSkuModel(1)
            ),
            disbursementSkuList = emptyList()
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
                    skuId = 1,familyMinMax = 0
                ),
                getFakeApplicableSkuModelWithAmountCriteria(
                    skuId = 2,familyMinMax = 0
                )
            ),
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 20, skuId = 1)
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

    fun get_bill_multiple_count_percent_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 10 % off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
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
                getFakePromotionSkuModel(quantity = 10, skuId = 5)
            )
        )
    }

    fun get_bill_multiple_count_percent_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 10 % off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
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

    fun get_bill_multiple_count_amount_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rsoff",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
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

    fun get_bill_multiple_count_amount_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 10, skuId = 1),
            )
        )
    }

    fun get_bill_multiple_countMultiple_percent_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 10 % off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT_MULTIPLE,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
            skuCount = 4,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2,3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 100, skuId = 1),
                getFakePromotionSkuModel(quantity = 50, skuId = 2),
                getFakePromotionSkuModel(quantity = 20, skuId = 3),
                getFakePromotionSkuModel(quantity = 30, skuId = 4),
                getFakePromotionSkuModel(quantity = 50, skuId = 5),
                getFakePromotionSkuModel(quantity = 50, skuId = 6),
            )
        )
    }

    fun get_bill_multiple_countMultiple_percent_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 10 % off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_COUNT_MULTIPLE,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "3,4",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 1, skuId = 1)
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(3),
                getFakeApplicableSkuModelWithAmountCriteria(4)
            )
        )
    }

    fun get_bill_multiple_group_count_percent_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 10 % off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_GROUP_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 100, skuId = 1),
                getFakePromotionSkuModel(quantity = 50, skuId = 2),
                getFakePromotionSkuModel(quantity = 20, skuId = 3),
                getFakePromotionSkuModel(quantity = 20, skuId = 4),
                getFakePromotionSkuModel(quantity = 10, skuId = 5)
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithGroupCountCriteria(1, skuGroupId = 1, groupId = 1, groupSkuIds = "1,2"),
                getFakeApplicableSkuModelWithGroupCountCriteria(3, skuGroupId = 2, groupId = 2, groupSkuIds = "3,4")
            )
        )
    }

    fun get_bill_multiple_group_count_percent_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 10 % off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_GROUP_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 100, skuId = 5),
                getFakePromotionSkuModel(quantity = 100, skuId = 1)
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithGroupCountCriteria(1, skuGroupId = 1, groupId = 1, groupSkuIds = "1,2"),
                getFakeApplicableSkuModelWithGroupCountCriteria(3, skuGroupId = 2, groupId = 2, groupSkuIds = "3,4"),
            )
        )
    }

    fun get_bill_multiple_group_count_amount_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rsoff",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_GROUP_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList =listOf(
                getFakePromotionSkuModel(quantity = 100, skuId = 3),
                getFakePromotionSkuModel(quantity = 100, skuId = 1)
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithGroupCountCriteria(1, skuGroupId = 1, groupId = 1, groupSkuIds = "1,2"),
                getFakeApplicableSkuModelWithGroupCountCriteria(3, skuGroupId = 2, groupId = 2, groupSkuIds = "3,4"),
            )
        )
    }

    fun get_bill_multiple_group_count_amount_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_GROUP_COUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 100, skuId = 1)
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithGroupCountCriteria(1, skuGroupId = 1, groupId = 1, groupSkuIds = "1,2"),
                getFakeApplicableSkuModelWithGroupCountCriteria(3, skuGroupId = 2, groupId = 2, groupSkuIds = "3,4"),
            )
        )
    }

    fun get_bill_multiple_group_countMultiple_percent_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 10 % off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_GROUP_COUNT_MULTIPLE,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 100, skuId = 1),
                getFakePromotionSkuModel(quantity = 50, skuId = 2),
                getFakePromotionSkuModel(quantity = 20, skuId = 3),
                getFakePromotionSkuModel(quantity = 20, skuId = 4),
                getFakePromotionSkuModel(quantity = 10, skuId = 5)
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithGroupCountCriteria(1, skuGroupId = 1, groupId = 1, groupSkuIds = "1,2"),
                getFakeApplicableSkuModelWithGroupCountCriteria(3, skuGroupId = 2, groupId = 2, groupSkuIds = "3,4"),
                getFakeApplicableSkuModelWithGroupCountCriteria(5, skuGroupId = 3, groupId = 3, groupSkuIds = "5"),
                getFakeApplicableSkuModelWithGroupCountCriteria(6, skuGroupId = 4, groupId = 4, groupSkuIds = "6"),
                getFakeApplicableSkuModelWithGroupCountCriteria(7, skuGroupId = 5, groupId = 5, groupSkuIds = "7")
            )
        )
    }

    fun get_bill_multiple_group_countMultiple_percent_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 10 % off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_GROUP_COUNT_MULTIPLE,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 1,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 1,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 1, skuId = 30)
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithGroupCountCriteria(1, skuGroupId = 1, groupId = 1, groupSkuIds = "1,2"),
                getFakeApplicableSkuModelWithGroupCountCriteria(3, skuGroupId = 2, groupId = 2, groupSkuIds = "3,4")
            )
        )
    }

    fun get_bill_multiple_group_countMultiple_amount_promotion_success(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rsoff",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_GROUP_COUNT_MULTIPLE,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList =listOf(
                getFakePromotionSkuModel(quantity = 100, skuId = 1),
                getFakePromotionSkuModel(quantity = 50, skuId = 2),
                getFakePromotionSkuModel(quantity = 20, skuId = 3),
                getFakePromotionSkuModel(quantity = 20, skuId = 4),
                getFakePromotionSkuModel(quantity = 10, skuId = 5)
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithGroupCountCriteria(1, skuGroupId = 1, groupId = 1, groupSkuIds = "1,2"),
                getFakeApplicableSkuModelWithGroupCountCriteria(3, skuGroupId = 2, groupId = 2, groupSkuIds = "3,4"),
                getFakeApplicableSkuModelWithGroupCountCriteria(5, skuGroupId = 3, groupId = 3, groupSkuIds = "5"),
                getFakeApplicableSkuModelWithGroupCountCriteria(6, skuGroupId = 4, groupId = 4, groupSkuIds = "6"),
                getFakeApplicableSkuModelWithGroupCountCriteria(7, skuGroupId = 5, groupId = 5, groupSkuIds = "7")
            )
        )
    }

    fun get_bill_multiple_group_countMultiple_amount_promotion_error(): PromotionModel {

        return PromotionModel(
            promotionId = 1,
            title = "Buy products worth of Rs2000 get 100 rs off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_GROUP_COUNT_MULTIPLE,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_CURRENT_BILL,
            skuList = listOf(
                getFakePromotionSkuModel(quantity = 100, skuId = 1),
                getFakePromotionSkuModel(quantity = 50, skuId = 2),
                getFakePromotionSkuModel(quantity = 20, skuId = 3),
                getFakePromotionSkuModel(quantity = 20, skuId = 4),
                getFakePromotionSkuModel(quantity = 10, skuId = 5)
            ),
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithGroupCountCriteria(1, skuGroupId = 1, groupId = 1, groupSkuIds = "1,2"),
                getFakeApplicableSkuModelWithGroupCountCriteria(3, skuGroupId = 2, groupId = 2, groupSkuIds = "3,4"),
                getFakeApplicableSkuModelWithGroupCountCriteria(5, skuGroupId = 3, groupId = 3, groupSkuIds = "5"),
                getFakeApplicableSkuModelWithGroupCountCriteria(6, skuGroupId = 4, groupId = 4, groupSkuIds = "6"),
                getFakeApplicableSkuModelWithGroupCountCriteria(7, skuGroupId = 5, groupId = 5, groupSkuIds = "7")
            )
        )
    }
}