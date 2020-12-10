package com.rosia.promotionservice.promotion.service.bill.multiple.promotion

import com.rosia.promotionservice.promotion.service.Promotion
import com.rosia.promotionservice.promotion.service.PromotionService
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class BillMultiplePromotionCriteriaCountTest {

    @InjectMocks
    lateinit var promotion: Promotion

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkBillPromotion_MultipleType_CriteriaCount_PercentDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillMultiplePromotionDataSource.get_bill_multiple_count_percent_promotion_success(),
        )
        println(promotion.promotionModel)
        assertEquals(true, promotion.promotionModel.isApplied)
        assertEquals(200.0, promotion.promotionModel.amountModel?.discountAmount)
    }

    @Test
    fun checkBillPromotion_MultipleType_CriteriaCount_PercentDisbursement_shouldReturnFalse() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillMultiplePromotionDataSource.get_bill_multiple_count_percent_promotion_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Count criteria not satisfied", promotion.message)
    }

    @Test
    fun checkBillPromotion_MultipleType_CriteriaCount_AmountDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillMultiplePromotionDataSource.get_bill_multiple_count_amount_promotion_success(),
        )
        assertEquals(true, promotion.promotionModel.isApplied)
        assertEquals(100.0, promotion.promotionModel.amountModel?.discountAmount)
    }

    @Test
    fun checkBillPromotion_MultipleType_CriteriaCount_AmountDisbursement_shouldReturnFalse() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillMultiplePromotionDataSource.get_bill_multiple_count_amount_promotion_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Count criteria not satisfied", promotion.message)
    }
}