package com.rosia.promotionservice.promotion.service.bill.multiple.promotion

import com.rosia.promotionservice.promotion.service.Promotion
import com.rosia.promotionservice.promotion.service.PromotionService
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class BillMultiplePromotionCriteriaCountMultipleTest {

    @InjectMocks
    lateinit var promotion: Promotion

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkBillPromotion_MultipleType_CriteriaCountMultiple_PercentDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillMultiplePromotionDataSource.get_bill_multiple_countMultiple_percent_promotion_success(),
        )
        println(promotion.promotionModel)
        assertEquals(true, promotion.promotionModel.isApplied)
        assertEquals(600.0, promotion.promotionModel.amountModel?.discountAmount)
        assertNotEquals(900.0, promotion.promotionModel.amountModel?.discountAmount)
    }

    @Test
    fun checkBillPromotion_MultipleType_CriteriaCountMultiple_PercentDisbursement_shouldReturnFalse() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = BillMultiplePromotionDataSource.get_bill_multiple_countMultiple_percent_promotion_error(),
        )
        assertEquals(false, promotion.promotionModel.isApplied)
        assertEquals("Count criteria not satisfied", promotion.message)
    }

    /*  @Test
      fun checkBillPromotion_MultipleType_CriteriaCountMultiple_AmountDisbursement_shouldReturnTrue() {
          val promotionService = PromotionService(
              listener = promotion
          )
          promotionService.checkPromotion(
              promotionModel = BillMultiplePromotionDataSource.get_bill_multiple_countMultiple_amount_promotion_success(),
          )
          assertEquals(true, promotion.promotionModel.isApplied)
          assertEquals(20.0, promotion.promotionModel.amountModel?.discountAmount)
      }
  */
    /* @Test
     fun checkBillPromotion_MultipleType_CriteriaCountMultiple_AmountDisbursement_shouldReturnFalse() {
         val promotionService = PromotionService(
             listener = promotion
         )
         promotionService.checkPromotion(
             promotionModel = BillMultiplePromotionDataSource.get_bill_multiple_countMultiple_amount_promotion_error(),
         )
         assertEquals(false, promotion.promotionModel.isApplied)
         assertEquals("Count criteria not satisfied", promotion.message)
     }*/
}