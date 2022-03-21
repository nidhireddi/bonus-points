package com.retailer.bonuspoints.service;

import java.util.List;

import com.retailer.bonuspoints.model.Transaction;

public interface TransactionService {

	Transaction getById(Long id);

	List<Transaction> getAll();

	List<Transaction> getByCustomerId(Long customerId);

	void save(Transaction transaction);

	Double getBonusPointsByCustomerId(Long customerId);
}
