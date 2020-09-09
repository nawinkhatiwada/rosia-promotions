package com.rosia.promotionservice.promotion.service.normal.type.single

import com.rosia.promotionservice.promotion.service.DataSource
import com.rosia.promotionservice.promotion.service.Promotion
import com.rosia.promotionservice.promotion.service.PromotionService
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class SinglePromotionCriteriaAmountServiceTest {

    @InjectMocks
    lateinit var promotion: Promotion

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkNormalPromotion_SingleType_CriteriaAmount_PercentDisbursement_shouldReturnTrue() {
        // Given
        val promotionService = PromotionService(
            listener = promotion
        )

        // When
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_single_amount_percent_promotion_success(),
        )

        // Then
        assertEquals(true, promotion.promotionModel.isApplied)
        assertEquals(10.0, promotion.promotionModel.skuList.first().discountAmount, 0.0)
        assertEquals("", promotion.message)
    }

    @Test
    fun checkNormalPromotion_SingleType_CriteriaAmount_PercentDisbursement_shouldReturnFalse() {
        // Given
        val promotionService = PromotionService(
            listener = promotion
        )

        // When
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_single_amount_percent_promotion_error(),
        )

        // Then
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Amount criteria not satisfied", promotion.message)
    }

    @Test
    fun checkNormalPromotion_SingleType_CriteriaAmount_AmountDisbursement_shouldReturnTrue() {
        // Given
        val promotionService = PromotionService(
            listener = promotion
        )

        // When
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_single_amount_amount_promotion_success(),
        )

        // Then
        assertEquals(10.0, promotion.promotionModel.skuList.first().discountAmount, 0.0)
        assertEquals("", promotion.message)
    }

    @Test
    fun checkNormalPromotion_SingleType_CriteriaAmount_AmountDisbursement_shouldReturnFalse() {
        // Given
        val promotionService = PromotionService(
            listener = promotion
        )

        // When
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_single_amount_amount_promotion_error(),
        )

        // Then
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Amount criteria not satisfied", promotion.message)
    }

    @Test
    fun checkNormalPromotion_SingleType_CriteriaAmount_SkuDisbursement_shouldReturnTrue() {
        // Given
        val promotionService = PromotionService(
            listener = promotion
        )

        // When
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_single_amount_sku_promotion_success(),
        )

        // Then
        assertEquals(2.0, promotion.promotionModel.newDisbursementValue, 0.0)
        assertEquals("", promotion.message)
    }

    @Test
    fun checkNormalPromotion_SingleType_CriteriaAmount_SkuDisbursement_shouldReturnFalse() {
        // Given
        val promotionService = PromotionService(
            listener = promotion
        )

        // When
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_single_amount_sku_promotion_error(),
        )

        // Then
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Amount criteria not satisfied", promotion.message)
    }
}