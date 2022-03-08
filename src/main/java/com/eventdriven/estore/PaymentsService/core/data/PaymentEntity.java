package com.eventdriven.estore.PaymentsService.core.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "payments")
@Data
public class PaymentEntity {
	@Id
	private String paymentId;
	@Column
	public String orderId;
}
