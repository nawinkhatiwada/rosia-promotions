package com.rosia.promotionservice.promotion.service.normal.type.single.promotion

import com.rosia.promotionservice.promotion.service.normal.type.DataSource
import com.rosia.promotionservice.promotion.service.Promotion
import com.rosia.promotionservice.promotion.service.PromotionService
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class SinglePromotionCriteriaQuantityServiceTest {

    @InjectMocks
    lateinit var promotion: Promotion

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkNormalPromotion_SingleType_CriteriaQuantity_PercentDisbursement_shouldReturnTrue() {
        // Given
        val promotionService = PromotionService(
            listener = promotion
        )

        // When
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_single_quantity_percent_promotion_success(),
        )

        // Then
        val sku = promotion.promotionModel.skuList.first()
        assertEquals(true, promotion.promotionModel.isApplied)
        assertEquals(5.0, sku.discountAmount, 0.0)
        assertEquals(95.0, sku.taxableAmount, 0.0)
        assertEquals(107.35, sku.netAmount, 0.0)
        assertEquals(12.35, sku.vatAmount, 0.0)
        assertEquals("", promotion.message)
    }

    @Test
    fun checkNormalPromotion_SingleType_CriteriaQuantity_PercentDisbursement_shouldReturnFalse() {
        // Given
        val promotionService = PromotionService(
            listener = promotion
        )

        // When
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_single_quantity_percent_promotion_error(),
        )

        // Then
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Quantity criteria not satisfied", promotion.message)
    }

    @Test
    fun checkNormalPromotion_SingleType_CriteriaQuantity_AmountDisbursement_shouldReturnTrue() {
        // Given
        val promotionService = PromotionService(
            listener = promotion
        )

        // When
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_single_quantity_amount_promotion_success(),
        )

        println(promotion.promotionModel)
        // Then
        assertEquals(true, promotion.promotionModel.isApplied)

        val sku = promotion.promotionModel.skuList.first()
        assertEquals(10.0, sku.discountAmount, 0.0)
        assertEquals(90.0, sku.taxableAmount, 0.0)
        assertEquals(101.7, sku.netAmount, 0.0)
        assertEquals(11.7, sku.vatAmount, 0.0)
        assertEquals("", promotion.message)
    }

    @Test
    fun checkNormalPromotion_SingleType_CriteriaQuantity_AmountDisbursement_shouldReturnFalse() {
        // Given
        val promotionService = PromotionService(
            listener = promotion
        )

        // When
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_single_quantity_amount_promotion_error(),
        )

        // Then
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Quantity criteria not satisfied", promotion.message)
    }

    @Test
    fun checkNormalPromotion_SingleType_CriteriaQuantity_SkuDisbursement_shouldReturnTrue() {
        // Given
        val promotionService = PromotionService(
            listener = promotion
        )

        // When
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_single_quantity_sku_promotion_success(),
        )

        // Then
        val sku = promotion.promotionModel.skuList.first()
        assertEquals(3.0, promotion.promotionModel.newDisbursementValue, 0.0)
        assertEquals(100.0, sku.taxableAmount, 0.0)
        assertEquals(113.0, sku.netAmount, 0.0)
        assertEquals(13.0, sku.vatAmount, 0.0)
        assertEquals("", promotion.message)
    }

    @Test
    fun checkNormalPromotion_SingleType_CriteriaQuantity_SkuDisbursement_shouldReturnFalse() {
        // Given
        val promotionService = PromotionService(
            listener = promotion
        )

        // When
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_single_quantity_sku_promotion_error(),
        )

        // Then
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Quantity criteria not satisfied", promotion.message)
    }
}