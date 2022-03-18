package com.retailer.rewardpoints.service.impl;

import java.util.List;
import java.util.stream.DoubleStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailer.rewardpoints.model.Transaction;
import com.retailer.rewardpoints.repository.TransactionRepository;
import com.retailer.rewardpoints.service.RewardPointsCalculatorService;
import com.retailer.rewardpoints.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	RewardPointsCalculatorService rewardPointsCalculatorService;

	@Override
	public Transaction getById(Long id) {
		return transactionRepository.getById(id);
	}

	@Override
	public List<Transaction> getAll() {
		return transactionRepository.getAll();
	}

	@Override
	public List<Transaction> getByCustomerId(Long customerId) {
		return transactionRepository.getByCustomerId(customerId);
	}

	@Override
	public void save(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	@Override
	public Float getRewardPointsByCustomerId(Long customerId) {
		List<Transaction> transactionsList = transactionRepository.getByCustomerId(customerId);
		Float sum = (float) transactionsList.stream().flatMapToDouble(txn -> DoubleStream.of(txn.getAmount())).sum();
		
		//Float sum = (float) .stream()
			//	.flatMapToDouble(txn -> DoubleStream.of(txn.getAmount())).sum();
		return rewardPointsCalculatorService.calculateRewardPoints(sum);
		//return null;
	}
}
