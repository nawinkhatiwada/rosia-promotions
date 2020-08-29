package com.rosia.promotionservice.promotion.service.normal.disbursement.commands.freesku

import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.service.Command
import com.rosia.promotionservice.promotion.service.normal.disbursement.DisbursementReceiver

class FreeSkuWithCriteriaCountCommand(
    private val disbursementReceiver: DisbursementReceiver,
    private val promotion: PromotionModel
) : Command {

    override fun execute(): Boolean {
        disbursementReceiver.handleFreeSkuWithCriteriaCountUseCase(promotion)
        return true
    }
}