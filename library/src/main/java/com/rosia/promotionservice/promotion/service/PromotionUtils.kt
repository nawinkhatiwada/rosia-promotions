package com.rosia.promotionservice.promotion.service

import com.rosia.promotionservice.promotion.data.ApplicableSkuLocalModel
import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.data.PromotionSkuGroupModel
import com.rosia.promotionservice.promotion.data.PromotionSkuModel
import com.rosia.promotionservice.promotion.service.bill.criteria.operator.OperatorHandler

fun checkMOQValidation(promotionModel: PromotionModel): Pair<Boolean, String> {
    val promotionApplicableSKUs =
        promotionModel.applicableSkuModelList?.groupBy { it.skuGroupId }

    promotionApplicableSKUs?.forEach { (skuGroupId, skuList) ->
        val applicableSKUs = skuList.map { it.skuId }
        val orderedSKUList = promotionModel.skuList.filter { it.skuId in applicableSKUs }

        val isValidSku = handlePromotionSkuCriteria(skuList, orderedSKUList)
        if (!isValidSku.first)
            return isValidSku

        // groupCriteria NULL means its normal promotion without custom group
        val groupCriteria = skuList.first().groupCriteriaLocalModel
        groupCriteria?.let {
            val isValidSkuGroup = handlePromotionSkuGroupCriteria(
                orderedSKUList,
                groupCriteria,
                orderedSKUList.sumBy { it.quantity })
            if (!isValidSkuGroup.first)
                return isValidSkuGroup
        }
    }
    return Pair(true, "Validation is OKAY")
}

private fun handlePromotionSkuCriteria(
    skuList: List<ApplicableSkuLocalModel>,
    orderedSKUList: List<PromotionSkuModel>
): Pair<Boolean, String> {
    skuList.forEach { skuCriteria ->
        val promotionModel = orderedSKUList.find { it.skuId == skuCriteria.skuId }
        promotionModel?.let {
            if (skuCriteria.criteriaType == PromotionConstant.CRITERIA_QUANTITY) {
                val isValid =
                    OperatorHandler.isCriteriaValid(
                        promotionModel.quantity.toDouble(),
                        skuCriteria.criteriaMinValue.toDouble(),
                        skuCriteria.criteriaMinOpr,
                        skuCriteria.criteriaMaxValue.toDouble(),
                        skuCriteria.criteriaMaxOpr
                    )
                if (!isValid) {
                    return Pair(
                        false,
                        "${promotionModel.skuName} has MOQ ${skuCriteria.criteriaMinValue}"
                    )
                }
            } else if (skuCriteria.criteriaType == PromotionConstant.CRITERIA_AMOUNT) {
                val rlp =
                    promotionModel.batchList?.first { it.isSelected }?.rlpVat ?: 0.0
                val totalAmount = promotionModel.quantity.times(rlp)
                val isValid =
                    OperatorHandler.isCriteriaValid(
                        totalAmount,
                        skuCriteria.criteriaMinValue.toDouble(),
                        skuCriteria.criteriaMinOpr,
                        skuCriteria.criteriaMaxValue.toDouble(),
                        skuCriteria.criteriaMaxOpr
                    )
                if (!isValid) {
                    return Pair(
                        false,
                        "${promotionModel.skuName} has Minimum Order Value of amount ${skuCriteria.criteriaMinValue}"
                    )
                }
            }
        }.orElse {
            val isValid =
                OperatorHandler.isCriteriaValid(
                    0.0,
                    skuCriteria.criteriaMinValue.toDouble(),
                    skuCriteria.criteriaMinOpr,
                    skuCriteria.criteriaMaxValue.toDouble(),
                    skuCriteria.criteriaMaxOpr
                )
            if (!isValid) {
                return Pair(
                    false,
                    "SKU has MOQ ${skuCriteria.criteriaMinValue}"
                )
            }
        }
    }
    return Pair(true, "")
}

private fun handlePromotionSkuGroupCriteria(
    skuList: List<PromotionSkuModel>,
    groupCriteria: PromotionSkuGroupModel,
    totalQuantity: Int
): Pair<Boolean, String> {
    if (groupCriteria.type == PromotionConstant.CRITERIA_QUANTITY) {
        val isValid =
            OperatorHandler.isCriteriaValid(
                totalQuantity.toDouble(),
                groupCriteria.minValue.toDouble(),
                groupCriteria.minType,
                groupCriteria.maxValue.toDouble(),
                groupCriteria.maxType
            )
        if (!isValid) {
            return Pair(
                false,
                "Some of the group has MOQ ${groupCriteria.minValue}"
            )
        }
    } else if (groupCriteria.type == PromotionConstant.CRITERIA_AMOUNT) {
        val totalAmount = skuList.sumByDouble {
            ((it.batchList?.filter { it.isSelected }?.first()?.rlpVat) ?: 0.0).times(it.quantity)
        }
        val isValid =
            OperatorHandler.isCriteriaValid(
                totalAmount,
                groupCriteria.minValue.toDouble(),
                groupCriteria.minType,
                groupCriteria.maxValue.toDouble(),
                groupCriteria.maxType
            )
        if (!isValid) {
            return Pair(
                false,
                "Some of the group has Minimum Order Value of amount ${groupCriteria.minValue}"
            )
        }
    }
    return Pair(true, "")
}

/**
 * this function orElse(params) works like if-else condition while using `kotlin let`
 * */
internal inline fun <R> R?.orElse(block: () -> R): R {
    return this ?: block()
}