package com.rosia.promotionservice.promotion.service.normal.criteria.operator

import com.rosia.promotionservice.promotion.service.bill.criteria.operator.OperatorConstants

class OperatorHandler {
    companion object {
        private fun compareCriteria(
            quantity: Double,
            criteriaValue: Double,
            operator: String
        ): Boolean {
            return when (operator) {
                OperatorConstants.GREATER_THAN -> quantity > criteriaValue
                OperatorConstants.LESS_THAN -> quantity < criteriaValue
                OperatorConstants.GREATER_THAN_EQUALS -> quantity >= criteriaValue
                OperatorConstants.LESS_THAN_EQUALS -> quantity <= criteriaValue
                OperatorConstants.EQUALS -> quantity == criteriaValue
                else -> false
            }
        }

        fun isCriteriaValid(
            totalQuantity: Double,
            minValue: Double,
            minOperator: String,
            maxValue: Double,
            maxOperator: String
        ): Boolean {
            return (compareCriteria(totalQuantity, minValue, minOperator) &&
                    compareCriteria(totalQuantity, maxValue, maxOperator))
        }
    }
}