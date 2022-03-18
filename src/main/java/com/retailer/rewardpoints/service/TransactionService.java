package com.retailer.rewardpoints.service;

import java.util.List;

import com.retailer.rewardpoints.model.Transaction;

public interface TransactionService {

	Transaction getById(Long id);

	List<Transaction> getAll();

	List<Transaction> getByCustomerId(Long customerId);

	void save(Transaction transaction);

	Float getRewardPointsByCustomerId(Long customerId);
}
