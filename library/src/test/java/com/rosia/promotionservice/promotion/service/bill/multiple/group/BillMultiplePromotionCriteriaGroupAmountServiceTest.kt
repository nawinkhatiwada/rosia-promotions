package com.rosia.promotionservice.promotion.service.bill.multiple.group

import com.rosia.promotionservice.promotion.service.Promotion
import com.rosia.promotionservice.promotion.service.PromotionService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class BillMultiplePromotionCriteriaGroupAmountServiceTest {
    @InjectMocks
    lateinit var promotion: Promotion

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkCriteriaAmount_AmountDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillMultipleGroupDataSource.get_amount_amount_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
        Assert.assertEquals(10.0, promotion.promotionModel.amountModel?.discountAmount)
    }

    @Test
    fun checkCriteriaAmount_AmountDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillMultipleGroupDataSource.get_amount_amount_error(),
        )
        Assert.assertEquals(false, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkCriteriaAmount_PercentDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillMultipleGroupDataSource.get_amount_percent_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
        Assert.assertEquals(300.0, promotion.promotionModel.amountModel?.discountAmount)
    }

    @Test
    fun checkCriteriaAmount_PercentDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillMultipleGroupDataSource.get_amount_percent_error(),
        )
        Assert.assertEquals(false, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkCriteriaAmount_SkuDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillMultipleGroupDataSource.get_amount_sku_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
        Assert.assertEquals(1.0, promotion.promotionModel.newDisbursementValue, 0.0)
        Assert.assertEquals("", promotion.message)
    }

    @Test
    fun checkNormalAmount_SkuDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillMultipleGroupDataSource.get_amount_sku_error(),
        )
        Assert.assertEquals(false, promotion.promotionModel.isApplied)
    }
}