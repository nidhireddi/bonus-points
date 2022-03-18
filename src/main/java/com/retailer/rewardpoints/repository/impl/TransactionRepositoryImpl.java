package com.retailer.rewardpoints.repository.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.retailer.rewardpoints.model.Customer;
import com.retailer.rewardpoints.model.Transaction;
import com.retailer.rewardpoints.repository.TransactionRepository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

	private Map<Long, Customer> customersMap = new ConcurrentHashMap<>();
	private Map<Long, Transaction> transactionsMap = new ConcurrentHashMap<>();

	public TransactionRepositoryImpl() {

		customersMap.put(100L, builderCustomerInstance(100L, "fname1", "lname1", 23, "address1", 500));
		customersMap.put(101L, builderCustomerInstance(101L, "fname2", "lname2", 45, "address2", 120));
		customersMap.put(102L, builderCustomerInstance(102L, "fname3", "lname3", 27, "address3", 2500));
		customersMap.put(103L, builderCustomerInstance(103L, "fname4", "lname4", 33, "address4", 70));
		customersMap.put(104L, builderCustomerInstance(104L, "fname5", "lname5", 21, "address5", 800));

		transactionsMap.put(1L, builderTransactionInstance(1L, 100d, new Date(), customersMap.get(100L), "refid"));
		transactionsMap.put(2L, builderTransactionInstance(2L, 240d, new Date(), customersMap.get(100L), "refid"));
		transactionsMap.put(3L, builderTransactionInstance(3L, 30d, new Date(), customersMap.get(100L), "refid"));
		transactionsMap.put(4L, builderTransactionInstance(4L, 175d, new Date(), customersMap.get(101L), "refid"));
		transactionsMap.put(5L, builderTransactionInstance(5L, 80d, new Date(), customersMap.get(101L), "refid"));
		transactionsMap.put(6L, builderTransactionInstance(6L, 1400d, new Date(), customersMap.get(101L), "refid"));
		transactionsMap.put(7L, builderTransactionInstance(7L, 140d, new Date(), customersMap.get(101L), "refid"));
		transactionsMap.put(8L, builderTransactionInstance(8L, 10d, new Date(), customersMap.get(102L), "refid"));
		transactionsMap.put(9L, builderTransactionInstance(9L, 150d, new Date(), customersMap.get(103L), "refid"));
		transactionsMap.put(10L, builderTransactionInstance(10L, 370d, new Date(), customersMap.get(104L), "refid"));
	}

	/**
	 * Builder for Customer
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param address
	 * @param rewardPoints
	 * @return
	 */
	private Customer builderCustomerInstance(Long id, String firstName, String lastName, Integer age, String address,
			Integer rewardPoints) {
		return Customer.builder()
				.id(id)
				.firstName(firstName)
				.lastName(lastName)
				.age(age)
				.address(address)
				.rewardPoints(rewardPoints)
				.build();
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
	private Transaction builderTransactionInstance(Long txnId, Double amount, Date createdOn, Customer initiatedBy,
			String refId) {
		return Transaction.builder()
				.txnId(txnId)
				.amount(amount)
				.createdOn(createdOn)
				.initiatedBy(initiatedBy)
				.refId(refId)
				.build();
	}

	@Override
	public Transaction getById(Long id) {
		return transactionsMap.get(id);
	}

	@Override
	public List<Transaction> getByCustomerId(Long customerId) {
		return transactionsMap.values().stream().filter(txn -> txn.getInitiatedBy().getId() == customerId)
				.collect(Collectors.toList());
	}

	@Override
	public List<Transaction> getAll() {
		return transactionsMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public void save(Transaction transaction) {
		transactionsMap.put(transaction.getTxnId(), transaction);
	}

}
