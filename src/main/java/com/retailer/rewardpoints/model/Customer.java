package com.retailer.rewardpoints.model;

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
public class Customer {

	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String address;
	private Integer rewardPoints;

}
