package com.rosia.promotionservice.promotion.service.normal.type.multiple.family

import com.rosia.promotionservice.promotion.service.Promotion
import com.rosia.promotionservice.promotion.service.PromotionService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

/**
 * Count criteria for group not handled in Promotion Utils
 * For group count criteria, promotion criteria defers i.e Promotion criteria = GROUP_COUNT/GROUP_COUNT_MULTIPLE
* */

class MultiplePromotionCriteriaFamilyCountServiceTest {
    @InjectMocks
    lateinit var promotion: Promotion

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkCriteriaCount_AmountDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = NormalMultipleFamilyDataSource.get_count_amount_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
        Assert.assertEquals(5.0, promotion.promotionModel.skuList.first().discountAmount,0.0)
        Assert.assertEquals(5.0, promotion.promotionModel.skuList.last().discountAmount,0.0)
        Assert.assertEquals("", promotion.message)
    }

    @Test
    fun checkCriteriaCount_AmountDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = NormalMultipleFamilyDataSource.get_count_amount_error(),
        )
        Assert.assertEquals(false, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkCriteriaCount_PercentDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = NormalMultipleFamilyDataSource.get_count_percent_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
        Assert.assertEquals(5.0, promotion.promotionModel.skuList.first().discountAmount, 0.0)
        println("${promotion.promotionModel.disbursementValue}")
    }

    @Test
    fun checkCriteriaCount_PercentDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = NormalMultipleFamilyDataSource.get_count_percent_error(),
        )
//        Assert.assertEquals(false, promotion.promotionModel.isApplied)
//        Assert.assertEquals(0.0, promotion.promotionModel.skuList.first().discountAmount, 0.0)
    }

    @Test
    fun checkCriteriaCount_SkuDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = NormalMultipleFamilyDataSource.get_count_sku_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
        Assert.assertEquals(1.0, promotion.promotionModel.newDisbursementValue, 0.0)
        Assert.assertEquals("", promotion.message)
    }

    @Test
    fun checkNormalCount_SkuDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = NormalMultipleFamilyDataSource.get_count_sku_error(),
        )
//        Assert.assertEquals(false, promotion.promotionModel.isApplied)
    }
}