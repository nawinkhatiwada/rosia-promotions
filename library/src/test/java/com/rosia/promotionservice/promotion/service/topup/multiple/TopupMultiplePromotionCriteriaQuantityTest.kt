package com.rosia.promotionservice.promotion.service.topup.multiple

import com.rosia.promotionservice.promotion.service.Promotion
import com.rosia.promotionservice.promotion.service.PromotionService
import com.rosia.promotionservice.promotion.service.topup.DataSource
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class TopupMultiplePromotionCriteriaQuantityTest {

    @InjectMocks
    lateinit var promotion: Promotion

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaQuantity_PercentDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(promotionModel = DataSource.get_topup_multiple_quantity_percent_promotion_success())
        assertEquals(true, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaQuantity_PercentDisbursement_SkuMoqError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(promotionModel = DataSource.get_topup_multiple_quantity_percent_promotion_sku_moq_error())
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Vicks 100ml has MOQ 20", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaQuantity_PercentDisbursement_SkuGroupMoqError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_quantity_percent_promotion_sku_group_moq_error()
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Some of the group has MOQ 20", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaQuantity_PercentDisbursement_MultipleGroup_Success() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_quantity_percent_promotion_multiple_group_success()
        )
        assertEquals(true, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaQuantity_PercentDisbursement_MultipleGroups_Sku_Error() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_quantity_percent_promotion_multiple_group_sku_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Vicks 3 has MOQ 5", promotion.message)
    }

   /* @Test
    fun checkTopupPromotion_MultipleType_CriteriaQuantity_PercentDisbursement_MultipleGroups_SkuGroup_Error() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_quantity_percent_promotion_multiple_group_sku_group_error()
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Some of the group has MOQ 12", promotion.message)
    }*/

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaQuantity_PercentDisbursement_MultipleGroups_Error() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_quantity_percent_promotion_multiple_group_error()
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Quantity criteria not satisfied", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaQuantity_PercentDisbursement_shouldReturnFalse() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_quantity_percent_promotion_error()
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Quantity criteria not satisfied", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaQuantity_AmountDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_quantity_amount_promotion_success()
        )
        assertEquals(true, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaQuantity_AmountDisbursement_SkuMoqError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_quantity_amount_promotion_sku_moq_error()
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Vicks 100ml has MOQ 20", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaQuantity_AmountDisbursement_SkuGroupMoqError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_quantity_amount_promotion_sku_group_moq_error()
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Some of the group has MOQ 20", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaQuantity_AmountDisbursement_shouldReturnFalse() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_quantity_amount_promotion_error()
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Quantity criteria not satisfied", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaQuantity_AmountDisbursement_MultipleGroup_Success() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_quantity_amount_promotion_multiple_group_success(),
        )
        assertEquals(true, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaQuantity_AmountDisbursement_MultipleGroups_Sku_Error() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_quantity_amount_promotion_multiple_group_sku_error()
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Vicks 3 has MOQ 5", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaQuantity_AmountDisbursement_MultipleGroups_SkuGroup_Error() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_quantity_amount_promotion_multiple_group_sku_group_error()
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Some of the group has MOQ 12", promotion.message)
    }

    @Test
    fun checkTopupPromotion_MultipleType_CriteriaQuantity_AmountDisbursement_MultipleGroups_Error() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = DataSource.get_topup_multiple_quantity_amount_promotion_multiple_group_error()
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Quantity criteria not satisfied", promotion.message)
    }
}