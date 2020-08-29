package com.rosia.promotionservice.promotion.service

import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.service.bill.disbursement.DisbursementReceiverImpl
import com.rosia.promotionservice.promotion.service.bill.disbursement.commands.AmountBillCommand
import com.rosia.promotionservice.promotion.service.bill.disbursement.commands.FreeSkuBillCommand
import com.rosia.promotionservice.promotion.service.bill.disbursement.commands.PercentBillCommand
import com.rosia.promotionservice.promotion.service.bill.type.commands.CurrentBillCommand
import com.rosia.promotionservice.promotion.service.normal.type.commands.NormalCommand
import com.rosia.promotionservice.promotion.service.bill.type.TypeReceiverImpl as BillTypeReceiverImpl
import com.rosia.promotionservice.promotion.service.normal.type.TypeReceiverImpl as NormalTypeReceiverImpl

class PromotionService(
    private val listener: PromotionListener
) {

    private val billTypeReceiverImpl = BillTypeReceiverImpl(listener)
    private val normalTypeReceiverImpl = NormalTypeReceiverImpl(listener)
    private val disbursementReceiverImpl = DisbursementReceiverImpl(listener)

    fun checkPromotion(promotionModel: PromotionModel): Boolean {
        return when (promotionModel.promotionType) {
            PromotionConstant.PROMOTION_TYPE_NORMAL -> NormalCommand(
                normalTypeReceiverImpl,
                promotionModel
            ).execute()
            PromotionConstant.PROMOTION_TYPE_CURRENT_BILL -> CurrentBillCommand(
                billTypeReceiverImpl,
                promotionModel
            ).execute()
            PromotionConstant.PROMOTION_TYPE_NEXT_BILL -> checkBillDisbursement(promotionModel)
            PromotionConstant.PROMOTION_TYPE_TOP_UP -> CurrentBillCommand(
                billTypeReceiverImpl,
                promotionModel
            ).execute()
            else -> false
        }
    }

    private fun checkBillDisbursement(promotionModel: PromotionModel): Boolean {
        return when (promotionModel.promotionType) {
            PromotionConstant.PROMOTION_TYPE_NEXT_BILL -> {
                return when (promotionModel.disbursementType) {
                    PromotionConstant.DISBURSEMENT_PERCENT -> PercentBillCommand(
                        disbursementReceiverImpl,
                        promotionModel
                    ).execute()
                    PromotionConstant.DISBURSEMENT_AMOUNT -> AmountBillCommand(
                        disbursementReceiverImpl,
                        promotionModel
                    ).execute()
                    PromotionConstant.DISBURSEMENT_FREE_SKU -> FreeSkuBillCommand(
                        disbursementReceiverImpl,
                        promotionModel
                    ).execute()
                    else -> false
                }
            }
            else -> false
        }
    }
}