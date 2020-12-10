package com.rosia.promotionservice.promotion.service.bill.multiple.promotion

import com.rosia.promotionservice.promotion.service.Promotion
import com.rosia.promotionservice.promotion.service.PromotionService
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class BillMultiplePromotionCriteriaGroupCountMultipleTest {

    @InjectMocks
    lateinit var promotion: Promotion

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkBillPromotion_MultipleType_CriteriaGroupCount_PercentDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillMultiplePromotionDataSource.get_bill_multiple_group_countMultiple_percent_promotion_success(),
        )
        assertEquals(true, promotion.promotionModel.isApplied)
        assertEquals(400.0, promotion.promotionModel.amountModel?.discountAmount)
    }

    @Test
    fun checkBillPromotion_MultipleType_CriteriaGroupCount_PercentDisbursement_shouldReturnFalse() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillMultiplePromotionDataSource.get_bill_multiple_group_countMultiple_percent_promotion_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Quantity criteria not satisfied", promotion.message)
    }

    /**
     * Only Disbursement type percent is handled
     * */

      /*@Test
      fun checkBillPromotion_MultipleType_CriteriaCountMultiple_AmountDisbursement_shouldReturnTrue() {
          val promotionService = PromotionService(
              listener = promotion
          )
          promotionService.checkPromotion(
              promotionModel = BillMultiplePromotionDataSource.get_bill_multiple_group_countMultiple_amount_promotion_success(),
          )
          assertEquals(true, promotion.promotionModel.isApplied)
          assertEquals(20.0, promotion.promotionModel.amountModel?.discountAmount)
      }

     @Test
     fun checkBillPromotion_MultipleType_CriteriaCountMultiple_AmountDisbursement_shouldReturnFalse() {
         val promotionService = PromotionService(
             listener = promotion
         )
         promotionService.checkPromotion(
             promotionModel = BillMultiplePromotionDataSource.get_bill_multiple_group_countMultiple_amount_promotion_error(),
         )
         assertEquals(false, promotion.promotionModel.isApplied)
         assertEquals("Count criteria not satisfied", promotion.message)
     }*/
}