package com.retailer.rewardpoints.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.retailer.rewardpoints.model.Transaction;

@Repository
public interface TransactionRepository {

	Transaction getById(Long id);

	List<Transaction> getByCustomerId(Long customerId);

	List<Transaction> getAll();

	void save(Transaction transaction);

}
