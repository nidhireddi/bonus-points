package com.retailer.bonuspoints.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.retailer.bonuspoints.model.Transaction;
import com.retailer.bonuspoints.repository.TransactionRepository;
import com.retailer.bonuspoints.service.impl.TransactionServiceImpl;

@SpringBootTest
public class TransactionServiceImplTest {

	@InjectMocks
	TransactionServiceImpl transactionService;

	@Mock
	TransactionRepository transactionRepository;

	@Test
	public void getAllTest() {
		List<Transaction> mockTxns = new ArrayList<>();
		mockTxns.add(new Transaction());
		when(transactionRepository.getAll()).thenReturn(mockTxns);
		List<Transaction> res = transactionService.getAll();
		assertEquals(mockTxns, res);
	}

	@Test
	public void getByCustomerIdTest() {
		List<Transaction> mockTxns = new ArrayList<>();
		mockTxns.add(new Transaction());
		when(transactionRepository.getByCustomerId(123L)).thenReturn(mockTxns);
		List<Transaction> res = transactionService.getByCustomerId(123L);
		assertEquals(mockTxns, res);
	}

	@Test
	public void getByIdTest() {
		Transaction mockTxn = new Transaction();
		when(transactionRepository.getById(123L)).thenReturn(mockTxn);
		Transaction res = transactionService.getById(123L);
		assertEquals(mockTxn, res);
	}

	@Test
	public void saveTest() {
		Transaction mockTxn = new Transaction();
		transactionService.save(mockTxn);
		verify(transactionRepository).save(mockTxn);
	}

}
