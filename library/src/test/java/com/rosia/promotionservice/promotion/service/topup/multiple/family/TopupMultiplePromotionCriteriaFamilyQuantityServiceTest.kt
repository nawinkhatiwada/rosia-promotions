package com.rosia.promotionservice.promotion.service.topup.multiple.family

import com.rosia.promotionservice.promotion.service.Promotion
import com.rosia.promotionservice.promotion.service.PromotionService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class TopupMultiplePromotionCriteriaFamilyQuantityServiceTest {
    @InjectMocks
    lateinit var promotion: Promotion

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkCriteriaQuantity_AmountDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = TopupMultipleFamilyDataSource.get_quantity_amount_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
        Assert.assertEquals(10.0, promotion.promotionModel.amountModel?.discountAmount)
        Assert.assertEquals("", promotion.message)
    }

    @Test
    fun checkCriteriaQuantity_AmountDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = TopupMultipleFamilyDataSource.get_quantity_amount_error(),
        )
        Assert.assertEquals(false, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkCriteriaQuantity_PercentDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = TopupMultipleFamilyDataSource.get_quantity_percent_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
        Assert.assertEquals(10.0, promotion.promotionModel.disbursementValue)
        println("${promotion.promotionModel.disbursementValue}")
    }

    @Test
    fun checkCriteriaQuantity_PercentDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = TopupMultipleFamilyDataSource.get_quantity_percent_error(),
        )
        Assert.assertEquals(false, promotion.promotionModel.isApplied)
        Assert.assertEquals(0.0, promotion.promotionModel.skuList.first().discountAmount, 0.0)
    }

    @Test
    fun checkCriteriaQuantity_SkuDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = TopupMultipleFamilyDataSource.get_quantity_sku_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
        Assert.assertEquals(1.0, promotion.promotionModel.disbursementValue)
        Assert.assertEquals("", promotion.message)
    }

    @Test
    fun checkNormalQuantity_SkuDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = TopupMultipleFamilyDataSource.get_quantity_sku_error(),
        )
        Assert.assertEquals(false, promotion.promotionModel.isApplied)
    }
}