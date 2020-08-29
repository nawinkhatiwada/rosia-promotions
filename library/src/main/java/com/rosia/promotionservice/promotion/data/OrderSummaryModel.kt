package com.rosia.promotionservice.promotion.data

data class OrderSummaryModel(
    var skuCount: Int,
    var brandCount: Int,
    var grandTotal: Double,
    var princeUnit: String,
    var callId: Int,
    var outletId: Int,
    var orderParentModel: MutableList<OrderParentModel>
)

data class OrderParentModel(
    var orderId: Int,
    var totalPrice: Double,
    var priceUnit: String,
    var promotionId: Int,
    var isMultiplePromotion: Boolean

)

data class OrderChildModel(
    var skuId: Int,
    var skuName: String,
    var batchId: Int,
    var brandName: String,
    var stockUnit: String,
    var priceUnit: String,
    var quantity: Int,
    var promotionId: Int,
    var promotionTitle: String,
    var grossAmount: Double,
    var promotionStatus: Boolean,
    var promotionType: Int
)