package com.eventdriven.estore.PaymentsService.query;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.estore.core.events.PaymentProcessedEvent;
import com.eventdriven.estore.PaymentsService.core.data.PaymentEntity;
import com.eventdriven.estore.PaymentsService.core.data.PaymentsRepository;

@Component
@ProcessingGroup("payment-group")
public class PaymentEventsHandler {

	private final PaymentsRepository paymentsRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentEventsHandler.class);

	public PaymentEventsHandler(PaymentsRepository paymentsRepository) {
		this.paymentsRepository = paymentsRepository;
	}
	
	@EventHandler
	public void on(PaymentProcessedEvent event) throws Exception {

		PaymentEntity paymentEntity = new PaymentEntity();
		BeanUtils.copyProperties(event, paymentEntity);

		try {
			paymentsRepository.save(paymentEntity);
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
		
		LOGGER.info("PaymentProcessedEvent is called for paymentID: "+ event.getPaymentId()
		+ " and orderId: " + event.getOrderId());
	}
}
