package com.rosia.promotionservice.promotion.service.normal.type.multiple.criteria

import com.rosia.promotionservice.promotion.service.DataSource
import com.rosia.promotionservice.promotion.service.Promotion
import com.rosia.promotionservice.promotion.service.PromotionService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class MultiplePromotionCriteriaQuantityServiceTest {
    @InjectMocks
    lateinit var promotion: Promotion

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkNormalPromotion_MultipleType_CriteriaQuantity_PercentDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_multiple_quantity_percent_promotion_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
        Assert.assertEquals(2.5, promotion.promotionModel.skuList.first().discountAmount, 0.0)
        Assert.assertEquals("", promotion.message)
        println("${promotion.promotionModel.disbursementValue}")
    }

    @Test
    fun checkNormalPromotion_MultipleType_CriteriaQuantity_PercentDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_multiple_quantity_percent_promotion_error(),
        )
        Assert.assertEquals(false, promotion.promotionModel.isApplied)
        Assert.assertEquals("Quantity criteria not satisfied", promotion.message)
    }

    @Test
    fun checkNormalPromotion_MultipleType_CriteriaQuantity_AmountDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_multiple_quantity_amount_promotion_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
        Assert.assertEquals(33.3334, promotion.promotionModel.skuList.first().discountAmount, 0.0)
        Assert.assertEquals(66.6667, promotion.promotionModel.skuList.last().discountAmount, 0.0)
        Assert.assertEquals("", promotion.message)
        println("${promotion.promotionModel}")
    }

    @Test
    fun checkNormalPromotion_MultipleType_CriteriaQuantity_AmountDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_multiple_quantity_amount_promotion_error(),
        )
        Assert.assertEquals(false, promotion.promotionModel.isApplied)
        Assert.assertEquals("Quantity criteria not satisfied", promotion.message)
    }

    @Test
    fun checkNormalPromotion_MultipleType_CriteriaQuantity_SkuDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_multiple_quantity_sku_promotion_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
        Assert.assertEquals(4.0, promotion.promotionModel.newDisbursementValue, 0.0)
        Assert.assertEquals("", promotion.message)
        println("${promotion.promotionModel.disbursementValue}")
    }

    @Test
    fun checkNormalPromotion_MultipleType_CriteriaQuantity_SkuDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_multiple_quantity_sku_promotion_error(),
        )
        Assert.assertEquals(false, promotion.promotionModel.isApplied)
        Assert.assertEquals("Quantity criteria not satisfied", promotion.message)
    }
}