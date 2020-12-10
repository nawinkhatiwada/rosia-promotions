package com.rosia.promotionservice.promotion.service

object PromotionConstant {

    const val PROMOTION_TYPE_NORMAL = "NORMAL"
    const val PROMOTION_TYPE_CURRENT_BILL = "CURRENT_BILL"
    const val PROMOTION_TYPE_NEXT_BILL = "NEXT_BILL"
    const val PROMOTION_TYPE_DIRECT_REIMBURSEMENT = "DIRECT_REIMBURSEMENT"
    const val PROMOTION_TYPE_TOP_UP = "TOP_UP"

    const val CRITERIA_AMOUNT = "AMOUNT"
    const val CRITERIA_QUANTITY = "QUANTITY"
    const val CRITERIA_COUNT = "COUNT"
    const val CRITERIA_COUNT_MULTIPLE = "COUNT_MULTIPLE"
    const val CRITERIA_GROUP_COUNT = "GROUP_COUNT"
    const val CRITERIA_GROUP_COUNT_MULTIPLE = "GROUP_COUNT_MULTIPLE"

    const val DISBURSEMENT_PERCENT = "PERCENT"
    const val DISBURSEMENT_AMOUNT = "AMOUNT"
    const val DISBURSEMENT_FREE_SKU = "FREE_SKU"

    const val SINGLE_PROMOTION = 1
    const val MULTIPLE_PROMOTION = 2

    // Messages
    const val AMOUNT_CRITERIA_NOT_SATISFIED = "Amount criteria not satisfied"
    const val QUANTITY_CRITERIA_NOT_SATISFIED = "Quantity criteria not satisfied"
    const val COUNT_CRITERIA_NOT_SATISFIED = "Count criteria not satisfied"
}