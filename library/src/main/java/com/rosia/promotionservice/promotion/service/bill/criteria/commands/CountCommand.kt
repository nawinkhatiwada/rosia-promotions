package com.rosia.promotionservice.promotion.service.bill.criteria.commands

import com.rosia.promotionservice.promotion.service.Command
import com.rosia.promotionservice.promotion.service.bill.criteria.CriteriaReceiver
import com.rosia.promotionservice.promotion.data.PromotionModel

class CountCommand(
    private val criteriaReceiver: CriteriaReceiver,
    private val promotion: PromotionModel
) : Command {

    override fun execute(): Boolean {
        return criteriaReceiver.handleCountCriteriaUseCase(promotion)
    }
}