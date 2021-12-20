package com.rosia.promotionservice.promotion.service

import com.rosia.promotionservice.promotion.data.PromotionSkuModel
import java.math.RoundingMode
import java.text.DecimalFormat

object AmountCalculator {

    fun calculateAmountDetails(
        quantity: Int,
        rlp: Double,
        rlpWithVat: Double,
        vat: Double,
        disbursementValue: Double? = 0.0,
        isDisbursementTypeAmount: Boolean = false
    ): AmountModel {

        val amount = rlp * quantity
        val grossAmount = rlpWithVat * quantity
        val discountAmount = if (isDisbursementTypeAmount) {
            disbursementValue ?: 0.0
        } else {
            (amount * (disbursementValue ?: 0.0)) / 100
        }
        val taxableAmount = amount - discountAmount
        val netAmount = taxableAmount * (1 + vat)
        val vatAmount = netAmount - taxableAmount
        return AmountModel(
            netAmount = roundOffDecimalPlace(netAmount),
            grossAmount = roundOffDecimalPlace(grossAmount),
            vatAmount = roundOffDecimalPlace(vatAmount),
            taxableAmount = roundOffDecimalPlace(taxableAmount),
            discountAmount = roundOffDecimalPlace(discountAmount)
        )
    }

    fun calculateAmountDetailsForBill(
        skuList: List<PromotionSkuModel>,
        disbursementValue: Double? = 0.0,
        isDisbursementTypeAmount: Boolean = false
    ): AmountModel {
        val sumOfTopUpAmount = skuList.sumByDouble { it.topUpDiscount }
        var sumTaxableAmount = skuList.sumByDouble { it.taxableAmount }
        sumTaxableAmount -= sumOfTopUpAmount
        val discountAmount = if (isDisbursementTypeAmount) {
            disbursementValue ?: 0.0
        } else {
            (sumTaxableAmount * (disbursementValue ?: 0.0)) / 100
        }
        val totalTaxableAmount = sumTaxableAmount - discountAmount - sumOfTopUpAmount
        val netAmount = totalTaxableAmount * (1.13)
        val vatAmount = netAmount - totalTaxableAmount

        return AmountModel(
            netAmount = roundOffDecimalPlace(netAmount),
            grossAmount = roundOffDecimalPlace(sumTaxableAmount), // roundOffDecimalPlace(grossAmount),
            vatAmount = roundOffDecimalPlace(vatAmount),
            taxableAmount = roundOffDecimalPlace(totalTaxableAmount),
            discountAmount = roundOffDecimalPlace(discountAmount)
        )
    }

    fun calculateAmountDetailsForTopUp(
        skuList: List<PromotionSkuModel>,
        disbursementValue: Double? = 0.0,
        isDisbursementTypeAmount: Boolean = false
    ): AmountModel {
        val sumTaxableAmount = skuList.sumByDouble { it.taxableAmount }
        val discountAmount = if (isDisbursementTypeAmount) {
            disbursementValue ?: 0.0
        } else {
            (sumTaxableAmount * (disbursementValue ?: 0.0)) / 100
        }
        val totalTaxableAmount = sumTaxableAmount - discountAmount
        val netAmount = totalTaxableAmount * (1.13)
        val vatAmount = netAmount - totalTaxableAmount

        return AmountModel(
            netAmount = roundOffDecimalPlace(netAmount),
            grossAmount = roundOffDecimalPlace(sumTaxableAmount), // roundOffDecimalPlace(grossAmount),
            vatAmount = roundOffDecimalPlace(vatAmount),
            taxableAmount = roundOffDecimalPlace(totalTaxableAmount),
            discountAmount = roundOffDecimalPlace(discountAmount)
        )
    }

    fun roundOffDecimalPlace(number: Double): Double {
        val decimalFormat = DecimalFormat("#.####")
        decimalFormat.roundingMode = RoundingMode.CEILING
        return decimalFormat.format(number).toDouble()
    }
}

/**
 * netAmount : taxable amount + VAT
 * grossAmount : rlpVat * qty
 * vatAmount : taxableAmount * 13%
 * discountAmount : rlp * qty * promotion disbursement
 * taxableAmount : rlp * qty - discountAmount
 */
class AmountModel(
    var netAmount: Double = 0.0,
    var grossAmount: Double = 0.0,
    var vatAmount: Double = 0.0,
    var discountAmount: Double = 0.0,
    var taxableAmount: Double = 0.0
)