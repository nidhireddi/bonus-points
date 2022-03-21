package com.retailer.bonuspoints.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailer.bonuspoints.model.Transaction;
import com.retailer.bonuspoints.repository.TransactionRepository;
import com.retailer.bonuspoints.service.BonusPointsCalculatorService;
import com.retailer.bonuspoints.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	BonusPointsCalculatorService bonusPointsCalculatorService;

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
	public Double getBonusPointsByCustomerId(Long customerId) {
		List<Transaction> transactionsList = transactionRepository.getByCustomerId(customerId);
		double totalAmount = transactionsList.stream().mapToDouble(Transaction::getAmount).sum();
		return bonusPointsCalculatorService.calculateBonusPoints(totalAmount);
	}
}
