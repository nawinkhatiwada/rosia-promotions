package com.rosia.promotionservice.promotion.service.normal.type.multiple.promotion

import com.rosia.promotionservice.promotion.service.normal.type.DataSource
import com.rosia.promotionservice.promotion.service.Promotion
import com.rosia.promotionservice.promotion.service.PromotionService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class MultiplePromotionCriteriaCountServiceTest {
    @InjectMocks
    lateinit var promotion: Promotion

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkNormalPromotion_MultipleType_CriteriaCount_PercentDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_multiple_count_percent_promotion_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
        Assert.assertEquals(2.5, promotion.promotionModel.skuList.first().discountAmount, 0.0)
        Assert.assertEquals("", promotion.message)
        println("${promotion.promotionModel.disbursementValue}")
    }

    @Test
    fun checkNormalPromotion_MultipleType_CriteriaCount_PercentDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_multiple_count_percent_promotion_error(),
        )
        Assert.assertEquals(false, promotion.promotionModel.isApplied)
        Assert.assertEquals("Count criteria not satisfied", promotion.message)
    }

    @Test
    fun checkNormalPromotion_MultipleType_CriteriaCount_AmountDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_multiple_count_amount_promotion_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
        Assert.assertEquals(5.0, promotion.promotionModel.skuList.first().discountAmount, 0.0)
        Assert.assertEquals(2.0, promotion.promotionModel.skuList.last().discountAmount, 0.0)
        Assert.assertEquals("", promotion.message)
        println("${promotion.promotionModel}")
    }

    @Test
    fun checkNormalPromotion_MultipleType_CriteriaCount_AmountDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_multiple_count_amount_promotion_error(),
        )
        Assert.assertEquals(false, promotion.promotionModel.isApplied)
        Assert.assertEquals("Count criteria not satisfied", promotion.message)
    }

    @Test
    fun checkNormalPromotion_MultipleType_CriteriaCount_SkuDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_multiple_count_sku_promotion_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
        Assert.assertEquals(2.0, promotion.promotionModel.newDisbursementValue, 0.0)
        Assert.assertEquals("", promotion.message)
        println("${promotion.promotionModel.disbursementValue}")
    }

    @Test
    fun checkNormalPromotion_MultipleType_CriteriaCount_SkuDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_normal_multiple_count_sku_promotion_error(),
        )
        Assert.assertEquals(false, promotion.promotionModel.isApplied)
        Assert.assertEquals("Count criteria not satisfied", promotion.message)
    }
}