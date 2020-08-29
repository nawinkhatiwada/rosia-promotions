package com.rosia.promotionservice.promotion.service.bill.disbursement.commands

import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.service.Command
import com.rosia.promotionservice.promotion.service.bill.disbursement.DisbursementReceiver

class PercentBillCommand(
    private val disbursementReceiver: DisbursementReceiver,
    private val promotion: PromotionModel
) : Command {

    override fun execute(): Boolean {
        disbursementReceiver.handleBillPercentUseCase(promotion)
        return true
    }
}