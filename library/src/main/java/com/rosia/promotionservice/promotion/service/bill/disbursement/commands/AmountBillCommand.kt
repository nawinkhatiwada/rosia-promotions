package com.rosia.promotionservice.promotion.service.bill.disbursement.commands

import com.rosia.promotionservice.promotion.service.Command
import com.rosia.promotionservice.promotion.service.bill.disbursement.DisbursementReceiver
import com.rosia.promotionservice.promotion.data.PromotionModel

class AmountBillCommand(
    private val disbursementReceiver: DisbursementReceiver,
    private val promotion: PromotionModel
) : Command {

    override fun execute(): Boolean {
        disbursementReceiver.handleBillAmountUseCase(promotion)
        return false
    }
}