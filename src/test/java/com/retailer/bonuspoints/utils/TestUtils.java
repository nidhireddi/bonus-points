package com.retailer.bonuspoints.utils;

import java.io.IOException;
import java.util.Date;

import org.springframework.boot.json.JsonParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retailer.bonuspoints.model.Customer;
import com.retailer.bonuspoints.model.Transaction;

public class TestUtils {

	/**
	 * Builder for Customer
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param address
	 * @param bonusPoints
	 * @return
	 */
	public static Customer builderCustomerInstance(Long id, String firstName, String lastName, Integer age,
			String address, Double bonusPoints) {
		return Customer.builder().id(id).firstName(firstName).lastName(lastName).age(age).address(address)
				.bonusPoints(bonusPoints).build();
	}

	/**
	 * 
	 * 
	 * @param txnId
	 * @param amount
	 * @param createdOn
	 * @param initiatedBy
	 * @param refId
	 * @return
	 */
	public static Transaction builderTransactionInstance(Long txnId, Double amount, Date createdOn,
			Customer initiatedBy, String refId) {
		return Transaction.builder().txnId(txnId).amount(amount).createdOn(createdOn).initiatedBy(initiatedBy)
				.refId(refId).build();
	}

	public static String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	public static <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

}
