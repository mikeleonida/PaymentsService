package com.eventdriven.estore.PaymentsService.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<PaymentEntity, String> {

	PaymentEntity findByPaymentId(String paymentId);
	PaymentEntity findByPaymentIdOrOrderId(String paymentId, String orderId);
	
}
