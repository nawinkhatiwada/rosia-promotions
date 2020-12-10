package com.rosia.promotionservice.promotion.service.bill.single.promotion

import com.rosia.promotionservice.promotion.service.Promotion
import com.rosia.promotionservice.promotion.service.PromotionService
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class BillSinglePromotionCriteriaAmountTest {

    @InjectMocks
    lateinit var promotion: Promotion

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkBillPromotion_SingleType_CriteriaAmount_PercentDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillSinglePromotionDataSource.get_bill_single_amount_percent_promotion_success(),
        )
        assertEquals(true, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkBillPromotion_SingleType_CriteriaAmount_PercentDisbursement_shouldReturnFalse() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillSinglePromotionDataSource.get_bill_single_amount_percent_promotion_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Amount criteria not satisfied", promotion.message)
    }

    @Test
    fun checkBillPromotion_SingleType_CriteriaAmount_AmountDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillSinglePromotionDataSource.get_bill_single_amount_amount_promotion_success(),
        )
        assertEquals(true, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkBillPromotion_SingleType_CriteriaAmount_AmountDisbursement_shouldReturnFalse() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillSinglePromotionDataSource.get_bill_single_amount_amount_promotion_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Amount criteria not satisfied", promotion.message)
    }

    @Test
    fun checkBillPromotion_SingleFamilyType_CriteriaAmount_AmountDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillSinglePromotionDataSource.get_bill_singlefamily_amount_amount_promotion_success(),
        )
        assertEquals(true, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkBillPromotion_SingleFamilyType_CriteriaAmount_AmountDisbursement_shouldReturnFalse() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillSinglePromotionDataSource.get_bill_singlefamily_amount_amount_promotion_false(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
    }
}