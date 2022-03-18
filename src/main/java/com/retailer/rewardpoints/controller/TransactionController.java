package com.retailer.rewardpoints.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retailer.rewardpoints.model.Transaction;
import com.retailer.rewardpoints.service.RewardPointsCalculatorService;
import com.retailer.rewardpoints.service.TransactionService;

@RestController
@RequestMapping("/retailer")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@Autowired
	RewardPointsCalculatorService rewardPointsCalculatorService;

	@GetMapping("/getAllTransactions")
	public List<Transaction> getAllTransactions() {
		return transactionService.getAll();
	}

	@GetMapping("/customer-id/{customerId}")
	public List<Transaction> getTransactionsbyCustomerId(@PathVariable Long customerId) {
		return transactionService.getByCustomerId(customerId);
	}

	@GetMapping("/get-reward-points")
	public Float getRewardPointsByAmount(@RequestParam Float amount) {
		return rewardPointsCalculatorService.calculateRewardPoints(amount);
	}

	@GetMapping("/get-reward-points-by-customer-id/{customerId}")
	public Float getRewardPointsByCustomerId(@PathVariable Long customerId) {
		return transactionService.getRewardPointsByCustomerId(customerId);
	}

	@GetMapping("/{id}")
	public Transaction getTransactionById(@PathVariable Long id) {
		return transactionService.getById(id);
	}

	@PostMapping("/saveTransaction")
	public void saveTransaction(@RequestBody Transaction transaction) {
		transactionService.save(transaction);
	}

}
