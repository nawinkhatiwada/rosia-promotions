package com.rosia.promotionservice.promotion.service.bill.multiple

import com.rosia.promotionservice.promotion.service.Promotion
import com.rosia.promotionservice.promotion.service.PromotionService
import com.rosia.promotionservice.promotion.service.bill.DataSource
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class BillMultiplePromotionCriteriaAmountTest {

    @InjectMocks
    lateinit var promotion: Promotion

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkBillPromotion_MultipleType_CriteriaAmount_PercentDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_bill_multiple_amount_percent_promotion_success(),
        )
        println(promotion.promotionModel)
        assertEquals(true, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkBillPromotion_MultipleType_CriteriaAmount_PercentDisbursement_shouldReturnFalse() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_bill_multiple_amount_percent_promotion_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Amount criteria not satisfied", promotion.message)
    }

    @Test
    fun checkBillPromotion_MultipleType_CriteriaAmount_AmountDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_bill_multiple_amount_amount_promotion_success(),
        )
        assertEquals(true, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkBillPromotion_MultipleType_CriteriaAmount_AmountDisbursement_shouldReturnFalse() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_bill_multiple_amount_amount_promotion_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Amount criteria not satisfied", promotion.message)
    }

    @Test
    fun checkNormalPromotion_MultipleType_CriteriaAmount_SkuDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = com.rosia.promotionservice.promotion.service.DataSource.get_normal_multiple_amount_sku_promotion_success(),
        )
        assertEquals(true, promotion.promotionModel.isApplied)
        assertEquals(2.0, promotion.promotionModel.newDisbursementValue, 0.0)
        assertEquals("", promotion.message)
        println("${promotion.promotionModel.disbursementValue}")
    }

    @Test
    fun checkNormalPromotion_MultipleType_CriteriaAmount_SkuDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = com.rosia.promotionservice.promotion.service.DataSource.get_normal_multiple_amount_sku_promotion_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Amount criteria not satisfied", promotion.message)
    }
}