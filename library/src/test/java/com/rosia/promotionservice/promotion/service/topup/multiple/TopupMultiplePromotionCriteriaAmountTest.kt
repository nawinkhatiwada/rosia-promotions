package com.rosia.promotionservice.promotion.service.topup.multiple

import com.rosia.promotionservice.promotion.service.Promotion
import com.rosia.promotionservice.promotion.service.PromotionService
import com.rosia.promotionservice.promotion.service.topup.DataSource
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class TopupMultiplePromotionCriteriaAmountTest {

    @InjectMocks
    lateinit var promotion: Promotion

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaAmount_PercentDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_amount_percent_promotion_success(),
        )
        assertEquals(true, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaAmount_PercentDisbursement_SkuMoqError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_amount_percent_promotion_sku_moq_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Vicks 3 has Minimum Order Value of amount 25", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaAmount_PercentDisbursement_SkuGroupMoqError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_amount_percent_promotion_sku_group_moq_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Some of the group has Minimum Order Value of amount 1900", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaAmount_PercentDisbursement_shouldReturnFalse() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_amount_percent_promotion_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Amount criteria not satisfied", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaAmount_PercentDisbursement_MultipleGroup_Success() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_amount_percent_promotion_multiple_group_success(),
        )
        assertEquals(true, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaAmount_PercentDisbursement_MultipleGroups_Sku_Error() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_amount_percent_promotion_multiple_group_sku_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Vicks 3 has Minimum Order Value of amount 50", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaAmount_PercentDisbursement_MultipleGroups_SkuGroup_Error() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_amount_percent_promotion_multiple_group_sku_group_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("SKU has MOQ 50", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaAmount_PercentDisbursement_MultipleGroups_Error() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_amount_percent_promotion_multiple_group_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Amount criteria not satisfied", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaAmount_AmountDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_amount_amount_promotion_success(),
        )
        assertEquals(true, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaAmount_AmountDisbursement_SkuMoqError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_amount_amount_promotion_sku_moq_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Vicks 100ml has Minimum Order Value of amount 20", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaAmount_AmountDisbursement_SkuGroupMoqError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_amount_amount_promotion_sku_group_moq_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Some of the group has Minimum Order Value of amount 200", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaAmount_AmountDisbursement_shouldReturnFalse() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_amount_amount_promotion_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Amount criteria not satisfied", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaAmount_AmountDisbursement_MultipleGroup_Success() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_amount_amount_promotion_multiple_group_success(),
        )
        assertEquals(true, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaAmount_AmountDisbursement_MultipleGroups_Sku_Error() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_amount_amount_promotion_multiple_group_sku_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Vicks 4 has Minimum Order Value of amount 50", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaAmount_AmountDisbursement_MultipleGroups_SkuGroup_Error() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_amount_amount_promotion_multiple_group_sku_group_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Some of the group has Minimum Order Value of amount 150", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaAmount_AmountDisbursement_MultipleGroups_Error() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_amount_amount_promotion_multiple_group_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Amount criteria not satisfied", promotion.message)
    }
}