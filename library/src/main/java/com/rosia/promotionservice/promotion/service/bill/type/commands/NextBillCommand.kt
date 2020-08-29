package com.rosia.promotionservice.promotion.service.bill.type.commands

import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.service.Command
import com.rosia.promotionservice.promotion.service.bill.type.TypeReceiver

class NextBillCommand(
    private val typeReceiver: TypeReceiver,
    private val promotion: PromotionModel
) : Command {

    override fun execute(): Boolean {
        return typeReceiver.handleNextBillUseCase(promotion)
    }
}