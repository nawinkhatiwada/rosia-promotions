package com.rosia.promotionservice.promotion.service.normal.type.commands

import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.service.Command
import com.rosia.promotionservice.promotion.service.normal.type.TypeReceiver

class NormalCommand(
    private val typeReceiver: TypeReceiver,
    private val promotion: PromotionModel
) : Command {

    override fun execute(): Boolean {
        return typeReceiver.handleNormalUseCase(promotion)
    }
}