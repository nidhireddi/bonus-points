package com.retailer.bonuspoints.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retailer.bonuspoints.model.Transaction;
import com.retailer.bonuspoints.service.BonusPointsCalculatorService;
import com.retailer.bonuspoints.service.TransactionService;

@RestController
@RequestMapping("/retailer")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@Autowired
	BonusPointsCalculatorService bonusPointsCalculatorService;

	@GetMapping("/getAllTransactions")
	public List<Transaction> getAllTransactions() {
		return transactionService.getAll();
	}

	@GetMapping("/customer-id/{customerId}")
	public List<Transaction> getTransactionsbyCustomerId(@PathVariable Long customerId) {
		return transactionService.getByCustomerId(customerId);
	}

	@GetMapping("/get-bonus-points")
	public Double getBonusPointsByAmount(@RequestParam Double amount) {
		return bonusPointsCalculatorService.calculateBonusPoints(amount);
	}

	@GetMapping("/get-bonus-points-by-customer-id/{customerId}")
	public Double getBonusPointsByCustomerId(@PathVariable Long customerId) {
		return transactionService.getBonusPointsByCustomerId(customerId);
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
