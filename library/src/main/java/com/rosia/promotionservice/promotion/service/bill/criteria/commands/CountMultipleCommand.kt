package com.rosia.promotionservice.promotion.service.bill.criteria.commands

import com.rosia.feature.promotion.service.Command
import com.rosia.feature.promotion.service.bill.criteria.CriteriaReceiver
import com.rosia.promotionservice.promotion.data.PromotionModel

class CountMultipleCommand(
    private val criteriaReceiver: CriteriaReceiver,
    private val promotion: PromotionModel
) : Command {

    override fun execute(): Boolean {
        return criteriaReceiver.handleCountMultipleCriteriaUseCase(promotion)
    }
}