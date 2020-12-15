package com.rosia.promotionservice.promotion.data

import android.os.Parcelable
import androidx.room.Ignore
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PromotionModel(
    var promotionId: Long,
    var title: String,
    var promotionState: Int,
    var criteriaId: Long,
    var criteriaType: String,
    var criteriaMaxOpr: String,
    var criteriaMaxValue: Int,
    var criteriaMinOpr: String,
    var criteriaMinValue: Int,
    var allowMultiple: Boolean = false,
    var skuCount: Int,
    var disbursementType: String,
    var disbursementValue: Double? = null,
    var callId: Long? = -1,
    var applicableSkuIds: String? = "",         // todo remove
    var isApplied: Boolean = false,
    var promotionType: String,
    @Ignore var disbursementSkuList: List<DisbursementSkuModel>? = null,
    @Ignore var skuList: List<PromotionSkuModel>,
    @Ignore var amountModel: BillAmountModel? = null,
    @Ignore var applicableSkuModelList: List<ApplicableSkuLocalModel>? = null,
    @Ignore var newDisbursementValue: Double = 0.0,
    @Ignore var pricePerPcsIfPromotionApplies: Double = 0.0
) : Parcelable {
    constructor() : this(
        0,
        "",
        0,
        0,
        "",
        "",
        0,
        "",
        0,
        false,
        skuCount = 0,
        disbursementType = "",
        disbursementValue = 0.0,
        callId = -1,
        disbursementSkuList = null,
        skuList = emptyList<PromotionSkuModel>(),
        isApplied = false,
        promotionType = "",
        amountModel = null,
        applicableSkuModelList = null,
        applicableSkuIds = "",
        newDisbursementValue = 0.0
    )
}

@Parcelize
data class DisbursementSkuModel(
    var skuId: Long,
    var batchId: Long,
    var skuName: String,
    var freeQuantity: Int,
    @Ignore var isSelected: Boolean? = false,
    var selectedQuantity: Int? = null
) : Parcelable {
    constructor() : this(0, 0, "", 0, false, 0)
}

@Parcelize
data class PromotionSkuModel(
    var skuId: Long,
    var skuName: String,
    var brandName: String,
    var moq: Int,
    var quantity: Int,
    var promotionStatus: Boolean,
    var inStock: Boolean,
    @Ignore var batchList: List<SkuBatchModel>? = null,
    @Ignore var discountAmount: Double,
    @Ignore var grossAmount: Double,
    @Ignore var netAmount: Double,
    @Ignore var vatAmount: Double,
    @Ignore var taxableAmount: Double,
    @Ignore var orderId: Long,
    @Ignore var topUpDiscount: Double = 0.0,
    @Ignore var stockQty: Int?,
    @Ignore var imageUrl: String? = ""
) : Parcelable {
    constructor() : this(0, "", "", 0, 0, false, true, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0L, 0.0, 0)
}

@Parcelize
data class SkuBatchModel(
    var id: Long,
    var rlpVat: Double,
    var isSelected: Boolean,
    var rlp: Double,
    var vatPercent: Double,
    @Ignore var batchTitle: String,
    @Ignore var mrp: Double = 0.0
) : Parcelable {
    constructor() : this(0, 0.0, false, 0.0, 0.0, "", 0.0)
}

@Parcelize
data class BillAmountModel(
    var discountAmount: Double,
    var grossAmount: Double,
    var netAmount: Double,
    var vatAmount: Double,
    var taxableAmount: Double
) : Parcelable

@Parcelize
data class ApplicableSkuLocalModel(
    var skuId: Long,
    var criteriaType: String,
    var criteriaMaxOpr: String,
    var criteriaMaxValue: Int,
    var criteriaMinOpr: String,
    var criteriaMinValue: Int,
    var skuGroupId: Int,
    var familyStatus: Boolean,
    @Ignore var groupCriteriaLocalModel: PromotionSkuGroupModel?, // map this model with PromotionSkuGroupEntity
    @Ignore var skuFamilyCriteriaModel: SkuFamilyCriteriaModel?
) : Parcelable {
    constructor() : this(0, "", "", 0, "", 0, 0, false, null, null)
}

@Parcelize
data class PromotionSkuGroupModel(
    var id: Long,
    var promotionId: Long,
    var skuIds: String,
    var type: String,
    var maxValue: Int,
    var maxType: String,
    var minValue: Int,
    var minType: String,
    var skuCount: Int, // MOQ
    var allowMultiple: Boolean
) : Parcelable

@Parcelize
data class SkuFamilyCriteriaModel(
    var familyId: Long,
    var promotionId: Long,
    var type: String,
    var maxValue: Int,
    var maxType: String,
    var minValue: Int,
    var minType: String,
    var skuCount: Int,
    var allowMultiple: Boolean
) : Parcelable