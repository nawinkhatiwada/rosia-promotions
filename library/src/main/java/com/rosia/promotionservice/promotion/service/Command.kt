package com.rosia.promotionservice.promotion.service

/**
 * This a generalized function for handling all cases of promotion in their respective command.
 * Returns boolean to check whether the promotion can be applied or not.
 */
interface Command {
    fun execute(): Boolean
}