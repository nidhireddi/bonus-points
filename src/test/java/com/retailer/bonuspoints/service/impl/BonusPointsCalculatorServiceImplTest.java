package com.retailer.bonuspoints.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.retailer.bonuspoints.service.BonusPointsCalculatorService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BonusPointsCalculatorServiceImplTest {

	@Autowired
	BonusPointsCalculatorService bonusPointsCalculatorService;

	@Test
	public void test0Dollars() {
		Double amount = new Double(0);
		Double res = bonusPointsCalculatorService.calculateBonusPoints(amount);
		assertEquals(0, res);
	}

	@Test
	public void test30Dollars() {
		Double amount = new Double(30);
		Double res = bonusPointsCalculatorService.calculateBonusPoints(amount);
		assertEquals(0, res);
	}

	@Test
	public void test50Dollars() {
		Double amount = new Double(50);
		Double res = bonusPointsCalculatorService.calculateBonusPoints(amount);
		assertEquals(0, res);
	}

	@Test
	public void test70Dollars() {
		Double amount = new Double(70);
		Double res = bonusPointsCalculatorService.calculateBonusPoints(amount);
		assertEquals(20, res);
	}

	@Test
	public void test100Dollars() {
		Double amount = new Double(100);
		Double res = bonusPointsCalculatorService.calculateBonusPoints(amount);
		assertEquals(50, res);
	}

	@Test
	public void test120Dollars() {
		Double amount = new Double(120);
		Double res = bonusPointsCalculatorService.calculateBonusPoints(amount);
		assertEquals(90, res);
	}
}