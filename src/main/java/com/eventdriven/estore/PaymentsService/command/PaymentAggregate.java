package com.eventdriven.estore.PaymentsService.command;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
// import org.springframework.beans.BeanUtils;

import com.appsdeveloperblog.estore.core.events.PaymentProcessedEvent;
import com.appsdeveloperblog.estore.core.commands.ProcessPaymentCommand;

@Aggregate
public class PaymentAggregate {
	
	@AggregateIdentifier
	private String orderId;
	private String paymentId;
	
	public PaymentAggregate() {
		
	}

	@CommandHandler
	public PaymentAggregate(ProcessPaymentCommand processPaymentCommand) {
		
		//Validate process payment command
		if(processPaymentCommand.getOrderId() == null
			|| processPaymentCommand.getOrderId().isBlank()) {
			throw new IllegalArgumentException("Order id cannot be empty");
		}
			
		if(processPaymentCommand.getPaymentId() == null
			|| processPaymentCommand.getPaymentId().isBlank()) {
			throw new IllegalArgumentException("Payment id cannot be empty");
		}
		
		if(processPaymentCommand.getPaymentDetails() == null) {
    		throw new IllegalArgumentException("Missing payment details");
    	}
		
		PaymentProcessedEvent paymentProcessedEvent = new PaymentProcessedEvent(
				processPaymentCommand.getOrderId(),
				processPaymentCommand.getPaymentId());
		
		AggregateLifecycle.apply(paymentProcessedEvent);
		
	}
	
	@EventSourcingHandler
	public void on(PaymentProcessedEvent paymentProcessedEvent) {
		this.orderId = paymentProcessedEvent.getOrderId();
		this.paymentId = paymentProcessedEvent.getPaymentId();
	}
}
