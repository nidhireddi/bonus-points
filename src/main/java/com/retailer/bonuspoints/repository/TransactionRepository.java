package com.retailer.bonuspoints.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.retailer.bonuspoints.model.Transaction;

@Repository
public interface TransactionRepository {

	Transaction getById(Long id);

	List<Transaction> getByCustomerId(Long customerId);

	List<Transaction> getAll();

	void save(Transaction transaction);

}
