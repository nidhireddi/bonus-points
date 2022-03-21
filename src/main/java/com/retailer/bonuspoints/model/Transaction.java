package com.retailer.bonuspoints.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

	private Long txnId;
	private Double amount;
	private Date createdOn;
	private Customer initiatedBy;
	private String refId;

}
