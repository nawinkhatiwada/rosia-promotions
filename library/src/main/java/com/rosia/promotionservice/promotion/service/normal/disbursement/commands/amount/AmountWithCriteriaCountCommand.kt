package com.rosia.promotionservice.promotion.service.normal.disbursement.commands.amount

import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.service.Command
import com.rosia.promotionservice.promotion.service.normal.disbursement.DisbursementReceiver

class AmountWithCriteriaCountCommand(
    private val disbursementReceiver: DisbursementReceiver,
    private val promotion: PromotionModel
) : Command {

    override fun execute(): Boolean {
        disbursementReceiver.handleAmountWithCriteriaCountUseCase(promotion)
        return true
    }
}